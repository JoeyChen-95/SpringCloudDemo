package net.biancheng.c.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.biancheng.c.dto.ItemReservationDTO;
import net.biancheng.c.entity.ItemReservation;
import net.biancheng.c.service.ItemReservationService;
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

    @ApiOperation(value="Find item reservation by his/her id",notes = "Find item reservation by his/her id")
    @GetMapping(value = "/findItemReservationById/{itemReservationId}")
    public ItemReservation findItemReservationById(@PathVariable("itemReservationId") int itemReservationId) {
        return itemReservationService.findItemReservationById(itemReservationId);
    }

    @ApiOperation(value="Display item reservations in the library",notes = "Display item reservations in the library")
    @GetMapping(value = "/itemReservationList")
    public List<ItemReservation> list() {
        return itemReservationService.getAllItemReservation();
    }

    @ApiOperation(value="Reserve an item now",notes="Reserve an item now")
    @PostMapping(value = "/reserveNow")
    public void reserveNow(Integer userId, Integer itemId, Timestamp endTime){
        Timestamp startTime = new Timestamp(System.currentTimeMillis());
        ItemReservationDTO itemReservationDTO=new ItemReservationDTO();
        itemReservationDTO.setUserId(userId);
        itemReservationDTO.setItemId(itemId);
        itemReservationDTO.setStartTime(startTime);
        itemReservationDTO.setEndTime(endTime);
        itemReservationService.reserve(itemReservationDTO);
    }

    @DeleteMapping(value = "/removeItemReservation")
    public void removeReservation(Integer itemReservationId){
        itemReservationService.removeReservation(itemReservationId);
    }


//    @ApiOperation(value="Add a new user",notes = "Add a new user")
//    @PostMapping(value = "/reserve")
//    public void addNewMember(Integer id, String username, String password, String realName, String address, String email) {
//
//    }



}