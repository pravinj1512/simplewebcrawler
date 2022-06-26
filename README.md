# Simple Web crawler

This project contains a very basic web crawler.

1) This web crawler crawls and stores 10K target urls those urls are related to construction websites.
2) BFS (Breadth First Search) algorithm is used for crawling child nodes.
3) Queue is used for target nodes so that once they visited can be removed with first in first out basis.
4) TreeSet is used to store the visited nodes so that while searching the current url in visited nodes it should take lesser time (O(log n)) to find that node.
5) For other requirements to implement with unit testing, it will take approximately another couple of weeks.


To execute this application follow below steps.

1) You should have installed JRE 1.8 and above to run this application.
2) On Windows machine, you need to execute the execute.bat file at root location.
3) On Linux machine, you need to execute the execute.sh file at root location.
   Note :- Since the execute.sh file is created on Windows, you may need to convert it to linux compatible by using some tool like dos2linux etc.


Optional Section: 

Build Steps

1) You have to set up maven with setting.xml configured to point to some logical repository.
2) Then you need to run mvn clean install to build the project from root location.


