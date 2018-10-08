package com.stu.helloworld;

import org.apache.commons.lang3.math.NumberUtils;

import java.text.DecimalFormat;

public class NumberTest {
  
  public static void main(String[] args) {
    //Integer i = null;
    //System.out.println((long)i);
    
    //Long l = i.longValue();
    //System.out.println(l);

    float f = 0.194765F;
    String fs = new DecimalFormat("#.00").format(f);
    System.out.println(fs);
    System.out.println(NumberUtils.toFloat(fs));
  }

}
