package org.stu.spring.cloud.zuul;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.stu.spring.cloud.zuul.filter.AccessFilter;

@EnableZuulProxy
@SpringCloudApplication
public class ZuulGatewayApplication {

  public static void main(String[] args) {
    new SpringApplicationBuilder(ZuulGatewayApplication.class).web(true).run(args);
  }

  @Bean
  public AccessFilter accessFilter() {
    return new AccessFilter();
  }

}
