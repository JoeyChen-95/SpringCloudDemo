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

    @ApiOperation(value="Find item by its id",notes = "Find item by its id")
    @GetMapping(value = "/get/{itemid}")
    public Item get(@PathVariable("itemid") int itemId) {
        return itemService.get(itemId);
    }

    @ApiOperation(value="Display all items in the library",notes = "Display all items in the library")
    @GetMapping(value = "/itemList")
    public List<Item> list() {
        return itemService.selectAll();
    }

    @PostMapping(value = "/createItem")
    public void addNewMember(Integer itemId, String itemCategory, boolean isInLibrary, String itemName, Integer itemPrice) {
        ItemDTO itemDTO=new ItemDTO();
        itemDTO.setId(itemId);
        itemDTO.setCategory(itemCategory);
        itemDTO.setIsInLibrary(isInLibrary);
        itemDTO.setName(itemName);
        itemDTO.setPrice(itemPrice);
        itemService.addNewItem(itemDTO);
    }

    @DeleteMapping(value = "/removeItem")
    public void removeItem(Integer itemId){
        itemService.removeItem(itemId);
    }

    @PutMapping(value = "updateItemName")
    public void updateItemName(Integer itemId, String newName){
        itemService.updateItemName(itemId, newName);
    }
    @PutMapping(value = "updateItemPrice")
    public void updateItemPrice(Integer itemId, Integer newPrice){
        itemService.updateItemPrice(itemId, newPrice);
    }

}