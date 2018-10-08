package com.stu.helloworld;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <strong>Description : </strong> TODO
 * <br>
 * <strong>Create on : </strong> 2018/10/8
 * <br>
 * <p>
 *
 * @author ShiYing.Ke
 * @since 2.0.0
 */
public class RegexTest {

  private static final String ALPHANUMERIC_UNDERLINE = "[a-zA-Z0-9_]*";

  public static void main(String[] args) {

    Pattern pattern = Pattern.compile(ALPHANUMERIC_UNDERLINE);

    Matcher m = pattern.matcher("a-zA-Z0-9_");
    System.out.println(m.matches());
  }
}
