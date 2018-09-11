package com.stu.helloworld;

import java.util.*;

public class CollectionIterateTest {

  public static void main(String[] args) {
    List<Map<String, String>> strList = new ArrayList<>();
    strList.add(new HashMap<String, String>(){

      /** 
       * 
       */ 
      private static final long serialVersionUID = 1L;
      {
        put("1", "111");
      }});
    strList.add(new HashMap<String, String>(){

      /** 
       * 
       */ 
      private static final long serialVersionUID = 1L;
      {
        put("2", "111");
      }});
    strList.add(new HashMap<String, String>(){

      /** 
       * 
       */ 
      private static final long serialVersionUID = 1L;
      {
        put("3", "111");
      }});
    strList.add(new HashMap<String, String>(){

      /** 
       * 
       */ 
      private static final long serialVersionUID = 1L;
      {
        put("4", "222");
      }});
    Iterator<Map<String, String>> it = strList.iterator();
    String key = "";
    while(it.hasNext()) {
      System.out.println(strList);
      Map<String, String> str = it.next();
      it.remove();
    }
//    Iterator<String> _strIt = strList.iterator();
//    while(_strIt.hasNext()) {
//      System.out.println(strList);
//      String _str = _strIt.next();
//      Iterator<String> strIt = strList.iterator();
//      while(strIt.hasNext()) {
//        String str = strIt.next();
//        System.out.println(str);
//        if(_str.equals(str)) {
//          strIt.remove();
//        }
//      }
//    }
  }

}
