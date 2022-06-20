package net.biancheng.c.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.biancheng.c.dto.UserDTO;
import net.biancheng.c.entity.User;
import net.biancheng.c.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 服务提供者的控制层
 * author:c语言中文网 c.biancheng.net
 */
@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;


    @Value("${server.port}")
    private String serverPort;

    @ApiOperation(value="Find user by his/her id",notes = "Find user by his/her id")
    @GetMapping(value = "/get/{userId}")
    public User findUserById(@PathVariable("userId") int userId) {
        return userService.findUserById(userId);
    }

    @ApiOperation(value="Display all users in the library",notes = "Display all users in the library")
    @GetMapping(value = "/userList")
    public List<User> list() {
        return userService.getAllUser();
    }

    @ApiOperation(value="Add a new user",notes = "Add a new user")
    @PostMapping(value = "/createUser")
    public void addNewMember(Integer id, String username, String password, String realName, String address, String email) {
        UserDTO userDTO=new UserDTO();
        userDTO.setId(id);
        userDTO.setUsername(username);
        userDTO.setPassword(password);
        userDTO.setRealName(realName);
        userDTO.setAddress(address);
        userDTO.setEmail(email);
        userService.addNewUser(userDTO);
    }


}