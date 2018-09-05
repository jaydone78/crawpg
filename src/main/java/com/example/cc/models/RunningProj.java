package com.example.cc.models;

/**
 * Created by qianjay on 2018/9/4.
 */
public class RunningProj {
  private String projName;
  private String projType;
  private String status;
  private String databaseType;
  private String databaseAddress;
  private String tableName;
  private Integer id;

  public String getProjName() {
    return projName;
  }

  public void setProjName(String projName) {
    this.projName = projName;
  }

  public String getProjType() {
    return projType;
  }

  public void setProjType(String projType) {
    this.projType = projType;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
