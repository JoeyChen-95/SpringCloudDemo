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

    @Override
    public void removeUser(Integer id) {
        userMapper.removeUser(id);

    }

    @Override
    public void updatePassword(Integer id, String newPassword) {
        userMapper.updatePassword(id, newPassword);

    }

    @Override
    public void updateUserName(Integer id, String newUsername) {
        userMapper.updateUsername(id, newUsername);
    }

    @Override
    public void updateUserAccountCredit(Integer id, Integer newAccountCredit) {
        userMapper.updateUserAccountCredit(id, newAccountCredit);
    }

    @Override
    public void updateUserAccountLevel(Integer id, Integer newAccountLevel) {
        userMapper.updateUserAccountLevel(id, newAccountLevel);
    }

    @Override
    public List<User> findUserByLevel(Integer levelLowerBound, Integer levelUpperBound) {
        return userMapper.findUserByLevel(levelLowerBound, levelUpperBound);
    }

    @Override
    public List<User> searchUserByUsername(String username) {
        return userMapper.searchUserByUsername(username);
    }

    @Override
    public List<User> getDebtAccounts() {
        return userMapper.getDebtAccounts();
    }


}