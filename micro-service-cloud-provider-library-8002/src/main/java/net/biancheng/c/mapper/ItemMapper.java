package net.biancheng.c.mapper;

import net.biancheng.c.entity.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {
    //根据主键获取数据
    Item selectByPrimaryKey(Integer itemId);

    //获取表中的全部数据
    List<Item> GetAll();

//    boolean addNewMember(Integer dept_No, String dept_Name, String dbSource);

}