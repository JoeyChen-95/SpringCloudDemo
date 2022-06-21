package net.biancheng.c.service;

import net.biancheng.c.dto.ItemReservationDTO;
import net.biancheng.c.entity.ItemReservation;

import java.util.List;

public interface ItemReservationService {
    //根据主键获取数据
    ItemReservation findItemReservationById(Integer itemReservationId);

    //获取表中的全部数据
    List<ItemReservation> getAllItemReservation();

    void reserve(ItemReservationDTO itemReservationDTO);

    void removeReservation(Integer itemReservationId);
}
