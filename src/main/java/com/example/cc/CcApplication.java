package com.example.cc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
  private static List<UserInfo> userInfoList = new ArrayList<>();

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

    for (int i = 0; i < 5; i++) {
      simpleInfoList.add(info1);
    }

    try {
      BufferedReader reader = new BufferedReader(
          new FileReader("./file/userinfo"));
      String line;
      while ((line = reader.readLine()) != null) {
        UserInfo userInfo = new UserInfo();
        String[] words = line.split("\t");
        userInfo.setName(words[0]);
        userInfo.setPosition(words[1]);
        userInfo.setOffice(words[2]);
        userInfo.setAge(words[3]);
        userInfo.setStartDate(words[4]);
        userInfo.setSalary(words[5]);
        userInfoList.add(userInfo);
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
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

  @RequestMapping(value = "/userinfo.json")
  public List<UserInfo> getUserInfoList() {
    return userInfoList;
  }
}
