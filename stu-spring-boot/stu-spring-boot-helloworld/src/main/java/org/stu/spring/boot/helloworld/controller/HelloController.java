package org.stu.spring.boot.helloworld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

  @Autowired
  RestTemplate restTemplate;

  @RequestMapping("/")
  public String greeting() {
    return "Hello World!";
  }

  @RequestMapping(value = "/person", method = RequestMethod.GET)//GET 方法按RFC标准不能有body
  public Person getPersonByCondition(@RequestBody Person person) {
    person.setName("Jack Ma");
    return person;
    
  }
  
  @RequestMapping("/run")
  public void runRunRun() {

    int count = 0;
    while (count < 1000) {
      count += 1;
      // 获取sessionId
      ResponseEntity<String> getRespEnt = restTemplate
          .getForEntity("https://jinshuju.net/f/dT6ks9", String.class);
      // cookie
      List<String> cookies = getRespEnt.getHeaders().get("Set-Cookie");
      String html = getRespEnt.getBody();
      //    System.out.println(html);
      //    System.out.println(html.indexOf("csrf-token"));
      int stIdx = html.indexOf("csrf-token") + 21;
      int edIdx = stIdx + 88;
      //    System.out.println(html.substring(stIdx, edIdx));
      String authenticity_token = html.substring(stIdx, edIdx);
      System.out.println("认证token:" + authenticity_token);
      String entry = "6HH3";// awu的编号
      MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<String, String>();
      postParameters.add("authenticity_token", authenticity_token);
      postParameters.add("entry[field_10][]", entry);
      // 设置头，带上cookies
      HttpHeaders headers = new HttpHeaders();
      headers.put(HttpHeaders.COOKIE, cookies);
      HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(
          postParameters, headers);
      String postResp = restTemplate.postForObject(
          "https://jinshuju.net/f/dT6ks9", requestEntity, String.class);
      System.out.println("响应结果:" + postResp);
      System.out.println("提交次数:" + count);
      try {
        Thread.sleep(30 * 1000L);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

}
