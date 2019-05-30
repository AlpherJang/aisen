package com.birthday.aisen.controllers;

import com.birthday.aisen.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.birthday.aisen.dto.UserDTO;

import java.util.List;

@Controller
@RequestMapping("/api/user")
@CrossOrigin()
@Api(tags = "用户管理->获取用户信息")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "获取用户信息", notes = "用户管理", httpMethod = "GET")
    @RequestMapping(value = "{uid}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<UserDTO> info(@PathVariable long uid) {
        UserDTO info = userService.getUserById(uid);
        return new ResponseEntity<>(info, HttpStatus.OK);
    }

    @ApiOperation(value = "根据用户名搜索用户", notes = "用户管理", httpMethod = "GET")
    @RequestMapping(value = "/search", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<UserDTO>> searchUser(String q) {
        List<UserDTO> info = userService.getUsersByName(q);
        return new ResponseEntity<>(info, HttpStatus.OK);
    }
}
