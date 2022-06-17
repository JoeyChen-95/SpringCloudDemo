package net.biancheng.c.service;

import net.biancheng.c.entity.Item;

import java.util.List;

public interface ItemService {

    Item get(Integer itemId);

    List<Item> selectAll();

//    void addNewMember(Integer deptNo, String deptName, String dbSource);

}