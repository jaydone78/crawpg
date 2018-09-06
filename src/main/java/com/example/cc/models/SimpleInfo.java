package com.example.cc.models;

public class SimpleInfo {
  private String program;
  private String programType;
  private String databaseType;
  private String workingTime;
  private String id;

  public SimpleInfo() {}

  public SimpleInfo(String program, String programType, String databaseType, String workingTime, String id) {
    this.program = program;
    this.programType = programType;
    this.databaseType = databaseType;
    this.workingTime = workingTime;
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getProgram() {
    return program;
  }

  public void setProgram(String program) {
    this.program = program;
  }

  public String getProgramType() {
    return programType;
  }

  public void setProgramType(String programType) {
    this.programType = programType;
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
