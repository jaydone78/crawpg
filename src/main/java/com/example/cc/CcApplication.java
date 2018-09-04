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
  private static List<RunningProj> runningProjList = new ArrayList<>();

  private static void initInfoTable() {
    CrawlerInfo info = new CrawlerInfo();
    info.setAddress("/home/jar/crawler_test.jar");
    info.setDatabaseName("test2");
    info.setDatabaseType("mongo");
    info.setDescription("爬取爱奇艺首页的热门电影列表");
    info.setTableitems("{\"爬取时间\": \"crawl time\"} ");
    info.setParameters("iqiyi");
    info.setTableName("test2");
    InfoTable.put("1", info);
  }

  private static void initSimpleInfoList() {
    for (int i = 0; i < 5; i++) {
      SimpleInfo info1 = new SimpleInfo();
      info1.setDatabaseType("mongo");
      info1.setProgram("iqiyi");
      info1.setType("腾讯任务");
      info1.setWorkingTime("2018.7.19-2018.8.16");
      info1.setId(simpleInfoList.size() + 1);
      simpleInfoList.add(info1);
    }
  }

  private static void initUserInfoList() {
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

  private static void initRunningProjList() {
    try {
      BufferedReader reader = new BufferedReader(
          new FileReader("./file/running_proc"));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] words = line.split(" ");

        RunningProj proj = new RunningProj();
        proj.setProjName(words[0]);
        proj.setStatus(words[1]);
        proj.setProjType(words[2]);
        proj.setDatabaseType(words[3]);
        proj.setDatabaseAddress(words[4]);
        proj.setTableName(words[5]);
        proj.setId(runningProjList.size() + 1);
        runningProjList.add(proj);
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void init() {
    initInfoTable();
    initSimpleInfoList();
    initUserInfoList();
    initRunningProjList();
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

  @RequestMapping(value = "/projinfo.json")
  public List<RunningProj> getRunningProjList() {
    return runningProjList;
  }
}
