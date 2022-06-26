package com.webcrawler;

import java.io.IOException;

public class WebCrawlerApplication {

    private static final String ROOT_URL = "https://www.screwfix.com/c/heating-plumbing/pipe/cat831500";
    private static final int BREAK_POINT = 10000;

    public static void main(String[] args) throws IOException {
        WebCrawler webCrawler = new WebCrawler();
        webCrawler.crawl(ROOT_URL, BREAK_POINT);
    }
}
