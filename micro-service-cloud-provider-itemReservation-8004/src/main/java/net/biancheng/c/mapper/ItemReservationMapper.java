package net.biancheng.c.mapper;

import net.biancheng.c.entity.ItemReservation;
import net.biancheng.c.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface ItemReservationMapper {
    //根据主键获取数据
    ItemReservation findItemReservationById(Integer itemReservationId);

    //获取表中的全部数据
    List<ItemReservation> getAllItemReservation();

    void reserve(Integer userId, Integer itemId, Timestamp startTime, Timestamp endTime);

    void removeReservation(Integer itemReservationId);
}