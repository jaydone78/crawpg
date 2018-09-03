package com.example.cc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CrawledDataController {
  @RequestMapping(value = "/tables")
  public String getCrawledData(@RequestParam("id") String id) {
    return "tables";
  }
}
