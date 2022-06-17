package net.biancheng.c.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
public class ItemController {
    @Autowired
    private ItemService itemService;


    @Value("${server.port}")
    private String serverPort;

    @ApiOperation(value="people's id",notes = "根据deptNo获取人")
    @RequestMapping(value = "/item/get/{itemid}", method = RequestMethod.GET)
    public Item get(@PathVariable("itemid") int itemId) {
        return itemService.get(itemId);
    }


    @RequestMapping(value = "/item/itemlist", method = RequestMethod.GET)
    public List<Item> list() {
        return itemService.selectAll();
    }

//    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
//    public void addNewMember(Integer deptNo, String deptName, String dbSource) {
//        deptService.addNewMember(deptNo, deptName, dbSource);
//    }

}