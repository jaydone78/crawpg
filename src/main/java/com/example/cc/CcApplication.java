package com.example.cc;

import com.example.cc.models.CrawlerInfo;
import com.example.cc.models.RunningProj;
import com.example.cc.models.SimpleInfo;
import com.example.cc.models.UserInfo;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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

  private static Map<String, CrawlerInfo> infoTable = new HashMap<>();
  private static List<SimpleInfo> simpleInfoList = new ArrayList<>();
  private static List<UserInfo> userInfoList = new ArrayList<>();
  private static List<RunningProj> runningProjList = new ArrayList<>();
  private static Gson gson = new Gson();


  private static void initInfoTable() {
    try {
      BufferedReader reader = new BufferedReader(new FileReader("./file/infotable"));
      String line;
      while ((line = reader.readLine()) != null) {
        CrawlerInfo info = gson.fromJson(line, CrawlerInfo.class);
        infoTable.put(info.getId(), info);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void initSimpleInfoList() {
    for (String id : infoTable.keySet()) {
      SimpleInfo info1 = infoTable.get(id).create();
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

  public static void write() {
    CrawlerInfo info = new CrawlerInfo();
  }

  public static void main(String[] args) {
    init();
//    initInfoTable();
    SpringApplication.run(CcApplication.class, args);
  }

  @RequestMapping(value = "/crawlerinfo.json")
  public CrawlerInfo getCrawlerInfo(@RequestParam("id") String id) {
    return infoTable.get(id);
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

  @RequestMapping(value = "/newcrawlersubmit", method = RequestMethod.POST)
  public void process(@RequestParam Map<String, String> crawlerinfo) {
    CrawlerInfo info = new CrawlerInfo();
    info.setAddress(crawlerinfo.get("address"));
    info.setDescription(crawlerinfo.get("description"));
    info.setProgram(crawlerinfo.get("program"));
    info.setProgramType(crawlerinfo.get("programType"));
    info.setDatabaseType(crawlerinfo.get("databaseType"));
    info.setWorkingTime(crawlerinfo.get("workingTime"));
    info.setDatabaseAddress(crawlerinfo.get("databaseAddress"));
    info.setDataItems(crawlerinfo.get("dataItems"));
    info.setDatabasePassword(crawlerinfo.get("databasePassword"));
    info.setParameters(crawlerinfo.get("parameters"));
    info.setTableName(crawlerinfo.get("tableName"));

    info.setId(String.valueOf(simpleInfoList.size() + 1));

    SimpleInfo simple = info.create();

    simpleInfoList.add(simple);
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter("./file/infotable", true));
      writer.write("\n" + gson.toJson(info, CrawlerInfo.class));
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
