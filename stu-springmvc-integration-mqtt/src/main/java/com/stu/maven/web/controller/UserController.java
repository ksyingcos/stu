package com.stu.maven.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stu.maven.web.model.User;

@Api(tags = {"User Api"})
@RestController
@RequestMapping("/user")
public class UserController {
  
  @ApiOperation(value = "获取全部用户")
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<User>> getUsers() {
    List<User> users = new ArrayList<User>();
    User user = new User();
    user.setUserId(1);
    user.setUserName("zhansan");
    users.add(user);
    return new ResponseEntity<List<User>>(users, HttpStatus.OK);
  }

  @ApiOperation(value = "获取用户", notes = "获取用户的接口")
  @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
  public User getUser(
      @ApiParam(value = "用户ID", required = true) @PathVariable("userId") int userId) {
    User user = new User();
    user.setUserId(userId);
    user.setUserName("zhansan");
    return user;
  }

  @ApiOperation(value = "新增用户", httpMethod = "POST")
  @RequestMapping(method = RequestMethod.POST)
  public String addUser(
      @ApiParam(value = "用户ID", required = true) @RequestParam("userId") int userId,
      @ApiParam(value = "用户姓名", required = true) @RequestParam("userName") String userName) {
    return "userId:" + userId + ",userName:" + userName;
  }

  @ApiOperation(value = "修改用户")
  @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
  public String updateUser(
      @ApiParam(value = "用户ID", required = true) @PathVariable("userId") int userId,
      @ApiParam(value = "用户姓名", required = true) @RequestParam("userName") String userName) {
    return "update success";
  }

  @ApiOperation(value = "删除用户")
  @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
  public String deleteUser(
      @ApiParam(value = "用户ID", required = true) @PathVariable("userId") int userId) {
    return "delete success";
  }

}
