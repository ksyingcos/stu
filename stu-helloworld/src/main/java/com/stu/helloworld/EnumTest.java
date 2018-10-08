package com.stu.helloworld;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.Arrays;

public class EnumTest {

  public static void main(String[] args) {

    // 打印所有枚举
    String colors = Arrays.toString(Color.values());
    String message = MessageFormat.format("颜色：{0}", colors);
    System.out.println(message);

    Class colorClazz = Color.class;
    Class superClazz = colorClazz.getSuperclass();
    System.out.println(superClazz.getName());
    // 获取自身所有的方法(private、public、protected，和访问权限无关)，不包括继承的
    Method[] methods = colorClazz.getDeclaredMethods();
    for(Method method : methods){
      System.out.println("DeclaredMethod: " + method.getName());
    }

    // 获取包括自身和继承（实现）过来的所有的public方法——Method不支持泛型<>，即后面不接<>
    methods = colorClazz.getMethods();
    for(Method method : methods){
      System.out.println("Methods: " + method.getName());
      try {
        if("name".equals(method.getName())){
          Object reVal = method.invoke(Color.BLACK);
          System.out.println("name: " + reVal);
        }
      } catch (IllegalAccessException | InvocationTargetException e) {
        e.printStackTrace();
      }
    }

    // 打印
    System.out.println(Color.BLACK.toString());

    Color Red = Color.valueOf("RED");

    System.out.println(Red);

    switch (Red.toString()) {
    case "RED":
      System.out.println("red");
    }

  }

}
