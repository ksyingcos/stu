package com.stu.helloworld;

public enum Color {
  
  RED("red", "红色"),
  BLACK("black", "黑色"),
  WHITE("white", "白色");
  
  Color(String code, String text){
    this.code = code;
    this.text = text;
  }
  
  private String code;
  
  private String text;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

}
