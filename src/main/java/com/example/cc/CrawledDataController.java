package com.example.cc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CrawledDataController {
  @RequestMapping(value = "/tables")
  public String getCrawledData() {
    return "tables";
  }
}
