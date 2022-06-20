package net.biancheng.c.service.Impl;

import net.biancheng.c.entity.Item;
import net.biancheng.c.mapper.ItemMapper;
import net.biancheng.c.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("itemService")
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper itemMapper;


    @Override
    public Item get(Integer itemId) {
        return itemMapper.selectByPrimaryKey(itemId);
    }

    @Override
    public List<Item> selectAll() {
        return itemMapper.GetAll();
    }

    @Override
    public Integer addNewItem(Integer id, String category, boolean isInLibrary, String name, Integer price) {
        return itemMapper.addNewItem(id, category, isInLibrary, name, price);
    }

    @Override
    public void removeItem(Integer id) {
        itemMapper.removeItem(id);

    }

    @Override
    public void updateItemName(Integer id, String newName) {
        itemMapper.updateItemName(id,newName);

    }

    @Override
    public void updateItemPrice(Integer id, Integer newPrice) {
        itemMapper.updateItemPrice(id,newPrice);
    }
}