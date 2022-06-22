package net.biancheng.c.service;

import net.biancheng.c.dto.ItemReservationDTO;
import net.biancheng.c.entity.ItemReservation;
import net.biancheng.c.entity.User;

import java.util.List;

public interface ItemReservationService {
    //根据主键获取数据
    ItemReservation findItemReservationById(Integer itemReservationId);

    //获取表中的全部数据
    List<ItemReservation> getAllItemReservation();

    void reserve(ItemReservationDTO itemReservationDTO);

    Integer removeReservation(Integer itemReservationId);

    List<ItemReservation> findItemReservationByUser(Integer userId);
    List<ItemReservation> findValidItemReservationByUser(Integer userId);

    List<ItemReservation> findItemReservationByItem(Integer itemId);
    List<ItemReservation> findValidItemReservationByItem(Integer itemId);
    Integer returnItem(Integer itemReservationId);

    Integer cancelReservation(Integer itemReservationId);

    List<User> findUserByItem(Integer itemId);


}
