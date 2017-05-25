package com.stu.demo;

import java.util.HashMap;
import java.util.Map;

public class HelloWord {

  public static void main(String[] args) {
    Map<String, Object> map1 = new HashMap<String, Object>();
    map1.put("test1", "test1");
    map1.put("test3", null);
    Map<String, Object> map2 = new HashMap<String, Object>();
    map2.put("test1", "11");
    map2.put("test2", "22");
    map1.putAll(map2);
    System.out.println(map1);
  }

}
