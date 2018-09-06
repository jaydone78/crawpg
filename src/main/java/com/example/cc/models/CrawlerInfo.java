package com.example.cc.models;

public class CrawlerInfo {
  private String program;
  private String programType;

  private String description;
  private String dataItems;
  private String databaseType;
  private String databaseAddress;
  private String databasePassword;
  private String workingTime;
  private String tableName;
  private String parameters;
  private String address;
  private String id;


  public SimpleInfo create() {
    return new SimpleInfo(program, programType, databaseType, workingTime, id);
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

  public String getWorkingTime() {
    return workingTime;
  }

  public void setWorkingTime(String workingTime) {
    this.workingTime = workingTime;
  }

  public String getDatabasePassword() {
    return databasePassword;
  }

  public void setDatabasePassword(String databasePassword) {
    this.databasePassword = databasePassword;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDataItems() {
    return dataItems;
  }

  public void setDataItems(String dataItems) {
    this.dataItems = dataItems;
  }

  public String getDatabaseType() {
    return databaseType;
  }

  public void setDatabaseType(String databaseType) {
    this.databaseType = databaseType;
  }

  public String getDatabaseAddress() {
    return databaseAddress;
  }

  public void setDatabaseAddress(String databaseAddress) {
    this.databaseAddress = databaseAddress;
  }

  public String getTableName() {
    return tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  public String getParameters() {
    return parameters;
  }

  public void setParameters(String parameters) {
    this.parameters = parameters;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
