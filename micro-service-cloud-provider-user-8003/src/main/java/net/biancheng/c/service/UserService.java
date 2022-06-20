package net.biancheng.c.service;

import net.biancheng.c.dto.UserDTO;
import net.biancheng.c.entity.User;

import java.util.List;

public interface UserService {
    //根据主键获取数据
    User findUserById(Integer userId);

    //获取表中的全部数据
    List<User> getAllUser();

    void addNewUser(UserDTO userDTO);

}
