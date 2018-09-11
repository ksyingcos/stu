package com.stu.demo;

public class StringTest {

  public static void main(String[] args) {
    String ptn = "PTN_000001";
    String prefix = ptn.substring(0, ptn.length() - 6);
    System.out.println(prefix);
    String ordinal = ptn.replaceFirst(prefix, "");
    System.out.println(ordinal);
    System.out.println(Integer.parseInt(ordinal));
  }

}
