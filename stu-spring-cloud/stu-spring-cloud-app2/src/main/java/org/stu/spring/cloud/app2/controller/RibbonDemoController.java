package org.stu.spring.cloud.app2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.stu.spring.cloud.app2.service.ComputeService;

@RestController
@RequestMapping("/ribbon")
public class RibbonDemoController {

    @Autowired
    private ComputeService computeService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(@RequestParam Integer a, @RequestParam Integer b) {
      String r = computeService.addService(a, b);
        return "Result from app2 RibbonDemoController : " + r;
    }

}