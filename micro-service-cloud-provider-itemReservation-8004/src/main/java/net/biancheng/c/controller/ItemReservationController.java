package net.biancheng.c.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import net.biancheng.c.dto.ItemReservationDTO;
import net.biancheng.c.entity.ItemReservation;
import net.biancheng.c.entity.User;
import net.biancheng.c.service.ItemReservationService;
import net.biancheng.c.util.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * 服务提供者的控制层
 * author:c语言中文网 c.biancheng.net
 */
@RestController
@Slf4j
@RequestMapping("/itemReservation")
public class ItemReservationController {
    @Autowired
    private ItemReservationService itemReservationService;


    @Value("${server.port}")
    private String serverPort;

    @ApiOperation(value = "Find item reservation by id", notes = "Find item reservation by id")
    @GetMapping(value = "/findItemReservationById/{itemReservationId}")
    public ItemReservation findItemReservationById(@PathVariable("itemReservationId") int itemReservationId) {
        return itemReservationService.findItemReservationById(itemReservationId);
    }

    @ApiOperation(value = "Display item reservations", notes = "Display item reservations")
    @GetMapping(value = "/itemReservationList")
    public List<ItemReservation> list() {
        return itemReservationService.getAllItemReservation();
    }

    @ApiOperation(value = "Reserve an item now", notes = "Reserve an item now")
    @PostMapping(value = "/reserveNow")
    public void reserveNow(Integer userId, Integer itemId, Timestamp endTime) {
        Timestamp startTime = new Timestamp(System.currentTimeMillis());
        ItemReservationDTO itemReservationDTO = new ItemReservationDTO();
        itemReservationDTO.setUserId(userId);
        itemReservationDTO.setItemId(itemId);
        itemReservationDTO.setStartTime(startTime);
        itemReservationDTO.setEndTime(endTime);
        itemReservationService.reserve(itemReservationDTO);
    }

    @ApiOperation(value = "Reserve an item for a period in the future", notes = "Reserve an item for a period in the future")
    @PostMapping(value = "/reserveFuture")
    public void reserveFuture(Integer userId, Integer itemId, Timestamp startTime, Timestamp endTime) {
        ItemReservationDTO itemReservationDTO = new ItemReservationDTO();
        itemReservationDTO.setUserId(userId);
        itemReservationDTO.setItemId(itemId);
        itemReservationDTO.setStartTime(startTime);
        itemReservationDTO.setEndTime(endTime);
        itemReservationService.reserve(itemReservationDTO);
    }
    @ApiOperation(value = "Delete an item reservation", notes = "Delete an item reservation")
    @DeleteMapping(value = "/removeItemReservation")
    public ResponseBody removeReservation(Integer itemReservationId) {
        Integer errorCode=itemReservationService.removeReservation(itemReservationId);
        if(errorCode==1){
            return new ResponseBody(200,"Remove successfully!");
        }else{
            return new ResponseBody(500,"Item reservation does not exist!");
        }
    }

    @ApiOperation(value = "Find all item reservations by a user", notes = "Find all item reservations by a user")
    @GetMapping(value = "/findItemReservationByUser")
    public List<ItemReservation> findItemReservationByUser(Integer userId) {
        return itemReservationService.findItemReservationByUser(userId);
    }

    @ApiOperation(value = "Find all VALID item reservations by a user", notes = "Find all VALID item reservations by a user")
    @GetMapping(value = "/findValidItemReservationByUser")
    public List<ItemReservation> findValidItemReservationByUser(Integer userId) {
        return itemReservationService.findItemReservationByUser(userId);
    }
    @ApiOperation(value = "Find all item reservations of an item", notes = "Find all item reservations of an item")
    @GetMapping(value = "/findItemReservationByItem")
    public List<ItemReservation> findItemReservationByItem(Integer itemId) {
        return itemReservationService.findItemReservationByItem(itemId);
    }

    @ApiOperation(value = "Find all VALID item reservations of an item", notes = "Find all VALID item reservations of an item")
    @GetMapping(value = "/findValidItemReservationByItem")
    public List<ItemReservation> findValidItemReservationByItem(Integer itemId) {
        return itemReservationService.findValidItemReservationByItem(itemId);
    }

    @ApiOperation(value="Return an item",notes="Return an item")
    @PutMapping(value = "/return")
    public ResponseBody returnItem(Integer itemReservationId){
        Integer errorCode=itemReservationService.returnItem(itemReservationId);
        if(errorCode==1){
            return new ResponseBody(200,"Return successfully!");
        }else{
            return new ResponseBody(500,"Invalid/Not existing reservation!");
        }
    }

    @ApiOperation(value="Cancel an item reservation",notes = "Cancel an item reservation")
    @PutMapping(value = "/cancel")
    public ResponseBody cancelReservation(Integer itemReservationId){
        Integer errorCode=itemReservationService.cancelReservation(itemReservationId);
        if(errorCode==1){
            return new ResponseBody(200,"Cancel successfully!");
        }else if(errorCode==-1){
            return new ResponseBody(500,"Item reservation has begun, cannot be cancelled!");
        }else{
            return new ResponseBody(500,"Item reservation does not exist or invalid, cannot be cancelled!");
        }
    }

    @ApiOperation(value="Find users who ever borrow an item",notes = "Find users who ever borrow an item")
    @GetMapping(value="/findUserByItem")
    public List<User> findUserByItem(Integer itemId){
        return itemReservationService.findUserByItem(itemId);
    }





//    @ApiOperation(value="Add a new user",notes = "Add a new user")
//    @PostMapping(value = "/reserve")
//    public void addNewMember(Integer id, String username, String password, String realName, String address, String email) {
//
//    }


}