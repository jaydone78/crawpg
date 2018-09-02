package com.example.cc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
public class CcApplication {
  private static Map<String, CrawlerInfo> InfoTable = new HashMap<>();
  private static List<SimpleInfo> simpleInfoList = new ArrayList<>();
  public static void init() {
    CrawlerInfo info = new CrawlerInfo();
    info.setAddress("/home/jar/crawler_test.jar");
    info.setDatabaseName("test2");
    info.setDatabaseType("mongo");
    info.setDescription("爬取爱奇艺首页的热门电影列表");
    info.setTableitems("{\"爬取时间\": \"crawl time\"} ");
    info.setParameters("iqiyi");
    info.setTableName("test2");
    InfoTable.put("1", info);

    SimpleInfo info1 = new SimpleInfo();
    info1.setDatabaseType("mongo");
    info1.setProgram("iqiyi");
    info1.setType("腾讯任务");
    info1.setWorkingTime("2018.7.19-2018.8.16");

    for (int i = 0; i < 5; i++)
      simpleInfoList.add(info1);

  }
  public static void main(String[] args) {
    init();
    SpringApplication.run(CcApplication.class, args);
  }

  @RequestMapping(value = "/crawlerinfo.json")
  public CrawlerInfo getCrawlerInfo(@RequestParam("id") String id) {
    return InfoTable.get(id);
  }
  @RequestMapping(value = "/crawlersimpleinfo.json")
  public List<SimpleInfo> getCrawlerSimpleInfo() {
    return simpleInfoList;
  }

}
