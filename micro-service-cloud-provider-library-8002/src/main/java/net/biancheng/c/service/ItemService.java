package net.biancheng.c.service;

import net.biancheng.c.dto.ItemDTO;
import net.biancheng.c.entity.Item;

import java.util.List;

public interface ItemService {

    Item get(Integer itemId);

    List<Item> selectAll();

    void addNewItem(ItemDTO itemDTO);

    void removeItem(Integer id);

    void updateItemName(Integer id, String newName);

    void updateItemPrice(Integer id, Integer newPrice);

}