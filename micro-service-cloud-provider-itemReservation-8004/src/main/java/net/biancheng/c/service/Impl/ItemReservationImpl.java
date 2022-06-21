package net.biancheng.c.service.Impl;
import lombok.extern.slf4j.Slf4j;
import net.biancheng.c.dto.ItemReservationDTO;
import net.biancheng.c.entity.ItemReservation;
import net.biancheng.c.exception.ErrorCode;
import net.biancheng.c.exception.ItemReservationException;
import net.biancheng.c.mapper.ItemReservationMapper;
import net.biancheng.c.service.ItemReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import static net.biancheng.c.util.TimeUtils.*;

@Service("itemReservationService")
@Slf4j
public class ItemReservationImpl implements ItemReservationService {
    @Autowired
    private ItemReservationMapper itemReservationMapper;

    private static final int MAX_RESERVE_HOUR=14*24;

    @Override
    public ItemReservation findItemReservationById(Integer itemReservationId) {
        return itemReservationMapper.findItemReservationById(itemReservationId);
    }

    @Override
    public List<ItemReservation> getAllItemReservation() {
        return itemReservationMapper.getAllItemReservation();
    }

    @Override
    public void reserve(ItemReservationDTO itemReservationDTO) {
        if(itemReservationDTO.getEndTime().before(itemReservationDTO.getStartTime())){
            log.error("Start time cannot be latter than end time!");
            throw new ItemReservationException(ErrorCode.INVALID_RESERVATION_TIMESLOT,"Start time cannot be latter than end time!");
        }
        log.info("Item Reservation Length: "+getTimeDifferenceByString(itemReservationDTO.getStartTime(),itemReservationDTO.getEndTime()));
        if(getTimeDifference(itemReservationDTO.getStartTime(),itemReservationDTO.getEndTime())>=MAX_RESERVE_HOUR){
            log.error("Time of reservation is too long!");
            throw new ItemReservationException(ErrorCode.RESERVATION_TIME_TOO_LONG,"Time of reservation is too long!");
        }
        List<ItemReservation> itemReservationList=getAllItemReservation();
        for(ItemReservation ir:itemReservationList){
            if(ir.getItemId().equals(itemReservationDTO.getItemId())&&checkTimeConflict(itemReservationDTO.getStartTime(),itemReservationDTO.getEndTime(),ir.getStartTime(),ir.getEndTime())){
                log.error("Conflict with an existing reservation:{}!",ir.getItemReservationId());
                throw new ItemReservationException(ErrorCode.CONFLICT_RESERVATION_TIMESLOT,"Conflict with an existing reservation!");
            }
        }
        itemReservationMapper.reserve(itemReservationDTO.getUserId(),itemReservationDTO.getItemId(),itemReservationDTO.getStartTime(),itemReservationDTO.getEndTime());
    }

    @Override
    public void removeReservation(Integer itemReservationId) {
        itemReservationMapper.removeReservation(itemReservationId);
    }

}