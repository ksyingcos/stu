package org.stu.spring.cloud.app2.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.stu.spring.cloud.app2.service.ComputeClient;

@RestController
@RequestMapping("/feign")
public class FeignDemoController {
  private final Logger logger = Logger.getLogger(getClass());
  
  @Autowired
  private DiscoveryClient client;
  
  @Autowired
  private ComputeClient computeClient;

  @RequestMapping(value = "/add", method = RequestMethod.GET)
  public String add(@RequestParam Integer a, @RequestParam Integer b) {
    ServiceInstance instance = client.getLocalServiceInstance();
    Integer r = computeClient.add(a, b);
    logger.info("/add, host:" + instance.getHost() + ", service_id:"
        + instance.getServiceId() + ", result:" + r);
    return "Result from " + instance.getServiceId() + " FeignDemoController : " + r;
  }

}
