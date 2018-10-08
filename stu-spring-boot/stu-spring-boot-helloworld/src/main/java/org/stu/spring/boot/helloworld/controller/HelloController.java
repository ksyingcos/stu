package org.stu.spring.boot.helloworld.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @RequestMapping("/")
  public String greeting() {
    return "Hello World!";
  }

  @RequestMapping(value = "/person", method = RequestMethod.GET)
  //GET 方法按RFC标准不能有body
  public Person getPersonByCondition(@RequestBody Person person) {
    person.setName("Jack Ma");
    return person;

  }

  @RequestMapping(value = "/person", method = RequestMethod.POST)
  public Person addPerson(@RequestBody @Validated Person person) {
    return person;
  }

}
