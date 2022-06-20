package net.biancheng.c.mapper;

import net.biancheng.c.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //根据主键获取数据
    User findUserById(Integer userId);

    //获取表中的全部数据
    List<User> getAllUser();

    void addNewUser(Integer id, String username, String password, String realName, String address, String email, Integer accountCredit, Integer accountLevel );




}