package com.example.cc.models;

public class SimpleInfo {
  private String program;
  private String programType;
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
