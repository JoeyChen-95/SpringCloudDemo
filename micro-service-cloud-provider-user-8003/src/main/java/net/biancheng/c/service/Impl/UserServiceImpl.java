package net.biancheng.c.service.Impl;
import net.biancheng.c.dto.UserDTO;
import net.biancheng.c.entity.User;
import net.biancheng.c.mapper.UserMapper;
import net.biancheng.c.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public User findUserById(Integer userId) {
        return userMapper.findUserById(userId);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public void addNewUser(UserDTO userDTO) {
        userMapper.addNewUser(userDTO.getId(), userDTO.getUsername(), userDTO.getPassword(), userDTO.getRealName(), userDTO.getAddress(), userDTO.getEmail(), 0,1);
    }
}