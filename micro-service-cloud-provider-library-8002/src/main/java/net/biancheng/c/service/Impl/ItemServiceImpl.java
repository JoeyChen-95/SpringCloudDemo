package net.biancheng.c.service.Impl;

import net.biancheng.c.dto.ItemDTO;
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
    public void addNewItem(ItemDTO itemDTO) {
        itemMapper.addNewItem(itemDTO.getId(), itemDTO.getCategory(), itemDTO.getIsInLibrary(), itemDTO.getName(), itemDTO.getPrice());
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