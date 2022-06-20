package net.biancheng.c.service;

import net.biancheng.c.entity.Item;

import java.util.List;

public interface ItemService {

    Item get(Integer itemId);

    List<Item> selectAll();

    Integer addNewItem(Integer id, String category, boolean isInLibrary, String name, Integer price);

}