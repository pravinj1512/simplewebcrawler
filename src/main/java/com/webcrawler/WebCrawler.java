package com.webcrawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {

    private Queue<String> targetUrls;
    private TreeSet<String> visitedUrls;

    private static final String URL_PATTERN = "\\b(http|https)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    public WebCrawler() {
        targetUrls = new LinkedList<>();
        visitedUrls = new TreeSet<>(Comparator.naturalOrder());
    }

    public void crawl(String rootUrl, int breakPoint) throws IOException {

        targetUrls.add(rootUrl);
        visitedUrls.add(rootUrl);
        BufferedReader bufferedReader = null;

        while (!targetUrls.isEmpty()) {

            String rawHtml = "";
            URL url = null;

            try {
                url = new URL(targetUrls.remove());
                bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
                String line = bufferedReader.readLine();

                while (line != null) {
                    rawHtml = rawHtml.concat(line);
                    line = bufferedReader.readLine();
                }

            } catch (IOException exception) {
                System.out.println("Page not found for " + url);
            } finally {
                bufferedReader.close();
            }

            Pattern pattern = Pattern.compile(URL_PATTERN);
            Matcher matcher = pattern.matcher(rawHtml);
            breakPoint = traverseChildNodeUrls(matcher, breakPoint);

            if (breakPoint == 0) {
                break;
            }
        }
    }

    private int traverseChildNodeUrls(Matcher matcher, int breakPoint) {

        while (matcher.find() && breakPoint > 0) {

            String childUrl = matcher.group();

            if (!visitedUrls.contains(childUrl)) {

                visitedUrls.add(childUrl);
                System.out.println("Url => " + childUrl);
                targetUrls.add(childUrl);
                --breakPoint;
            }
        }

        return breakPoint;
    }

}
