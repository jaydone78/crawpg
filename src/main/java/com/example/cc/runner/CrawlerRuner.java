package com.example.cc.runner;


import java.util.Map;

public class CrawlerRuner {
  private Map<String, Thread> crawlers;
  public void addNewCrawler(String jarPath) {
    Thread newcrawler = new Thread(new Crawler(jarPath));
    newcrawler.start();
  }
  public void shutDownJob(String id) {
    Thread crawler = crawlers.get(id);
    crawler.interrupt();
  }
}
