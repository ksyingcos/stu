package org.stu.spring.boot.jodconverter;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * <strong>Description : </strong> war包方式，添加初始化Spring应用上下文，继承 SpringBootServletInitializer 并重写 configure 方法
 * <br>
 * <strong>Create on : </strong> 2018/10/15
 * <br>
 * <p>
 *
 * @author ShiYing.Ke
 * @since 2.0.0
 */
public class JodconverterServletInitializer
    extends SpringBootServletInitializer {
  @Override
  protected SpringApplicationBuilder configure(
      SpringApplicationBuilder builder) {
    // 注意这里要指向原先用main方法执行的Application启动类
    return builder.sources(JodconverterApplication.class);
  }
}
