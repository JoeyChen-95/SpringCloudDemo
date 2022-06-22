package net.biancheng.c.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import net.biancheng.c.dto.ItemDTO;
import net.biancheng.c.entity.Item;
import net.biancheng.c.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 服务提供者的控制层
 * author:c语言中文网 c.biancheng.net
 */
@RestController
@Slf4j
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;


    @Value("${server.port}")
    private String serverPort;

    @ApiOperation(value="Find item by id",notes = "Find item by id")
    @GetMapping(value = "/findItemById/{itemid}")
    public Item get(@PathVariable("itemid") int itemId) {
        return itemService.get(itemId);
    }

    @ApiOperation(value="Display all items",notes = "Display all items")
    @GetMapping(value = "/itemList")
    public List<Item> list() {
        return itemService.selectAll();
    }

    @ApiOperation(value="Add a new item",notes = "Add a new item")
    @PostMapping(value = "/createItem")
    public void addNewItem(Integer itemId, String itemCategory, boolean isInLibrary, String itemName, Integer itemPrice) {
        ItemDTO itemDTO=new ItemDTO();
        itemDTO.setId(itemId);
        itemDTO.setCategory(itemCategory);
        itemDTO.setIsInLibrary(isInLibrary);
        itemDTO.setName(itemName);
        itemDTO.setPrice(itemPrice);
        itemService.addNewItem(itemDTO);
    }
    @ApiOperation(value="remove an item",notes = "remove an item")
    @DeleteMapping(value = "/removeItem")
    public void removeItem(Integer itemId){
        itemService.removeItem(itemId);
    }

    @ApiOperation(value="Update item name",notes = "Update item name")
    @PutMapping(value = "updateItemName")
    public void updateItemName(Integer itemId, String newName){
        itemService.updateItemName(itemId, newName);
    }
    @ApiOperation(value="Update item price",notes = "Update item price")
    @PutMapping(value = "updateItemPrice")
    public void updateItemPrice(Integer itemId, Integer newPrice){
        itemService.updateItemPrice(itemId, newPrice);
    }

}