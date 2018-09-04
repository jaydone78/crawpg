package com.example.cc;

public class SimpleInfo {
  private String program;
  private String type;
  private String databaseType;
  private String workingTime;
  private Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getProgram() {
    return program;
  }

  public void setProgram(String program) {
    this.program = program;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getDatabaseType() {
    return databaseType;
  }

  public void setDatabaseType(String databaseType) {
    this.databaseType = databaseType;
  }

  public String getWorkingTime() {
    return workingTime;
  }

  public void setWorkingTime(String workingTime) {
    this.workingTime = workingTime;
  }
}
