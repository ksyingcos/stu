package com.stu.helloworld;

public class EnumTest {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    System.out.println(Color.BLACK.toString());

    Color Red = Color.valueOf("RED");

    System.out.println(Red);

    switch (Red.toString()) {
    case "RED":
      System.out.println("red");
    }

  }

}
