package net.biancheng.c.service.Impl;
import lombok.extern.slf4j.Slf4j;
import net.biancheng.c.dto.ItemReservationDTO;
import net.biancheng.c.entity.ItemReservation;
import net.biancheng.c.entity.User;
import net.biancheng.c.exception.ErrorCode;
import net.biancheng.c.exception.ItemReservationException;
import net.biancheng.c.mapper.ItemReservationMapper;
import net.biancheng.c.service.ItemReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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
        if(getTimeDifference(itemReservationDTO.getStartTime(),itemReservationDTO.getEndTime())>=MAX_RESERVE_HOUR){
            log.error("Time of reservation is too long! Length:{}",getTimeDifferenceByString(itemReservationDTO.getStartTime(),itemReservationDTO.getEndTime()));
            throw new ItemReservationException(ErrorCode.RESERVATION_TIME_TOO_LONG,"Time of reservation is too long!");
        }
        List<ItemReservation> itemReservationList=getAllItemReservation();
        for(ItemReservation ir:itemReservationList){
            if(ir.getItemId().equals(itemReservationDTO.getItemId())&&ir.getIsValid()&&checkTimeConflict(itemReservationDTO.getStartTime(),itemReservationDTO.getEndTime(),ir.getStartTime(),ir.getEndTime())){
                log.error("Conflict with an existing reservation:{}!",ir.getItemReservationId());
                throw new ItemReservationException(ErrorCode.CONFLICT_RESERVATION_TIMESLOT,"Conflict with an existing reservation!");
            }
        }
        log.info("Reservation created successfully, User:"+itemReservationDTO.getUserId()+"  Item:"+itemReservationDTO.getItemId()+"  Timeslot:"+itemReservationDTO.getStartTime()+"->"+itemReservationDTO.getEndTime());
        itemReservationMapper.reserve(itemReservationDTO.getUserId(),itemReservationDTO.getItemId(),itemReservationDTO.getStartTime(),itemReservationDTO.getEndTime());
    }

    @Override
    public Integer removeReservation(Integer itemReservationId) {
        if(findItemReservationById(itemReservationId)==null){
            return 0;
        }else{
            itemReservationMapper.removeReservation(itemReservationId);
            return 1;
        }
    }

    @Override
    public List<ItemReservation> findItemReservationByUser(Integer userId) {
        return itemReservationMapper.findItemReservationByUser(userId);
    }

    @Override
    public List<ItemReservation> findValidItemReservationByUser(Integer userId) {
        List<ItemReservation> itemReservationList=itemReservationMapper.findItemReservationByItem(userId);
        itemReservationList.removeIf(ir->(ir.getIsValid()==false));
        return itemReservationList;
    }

    @Override
    public List<ItemReservation> findItemReservationByItem(Integer itemId) {
        return itemReservationMapper.findItemReservationByItem(itemId);
    }

    @Override
    public List<ItemReservation> findValidItemReservationByItem(Integer itemId) {
        List<ItemReservation> itemReservationList=itemReservationMapper.findItemReservationByItem(itemId);
        itemReservationList.removeIf(ir->(ir.getIsValid()==false));
        return itemReservationList;
    }

    @Override
    public Integer returnItem(Integer itemReservationId) {
        if(findItemReservationById(itemReservationId)!=null&&findItemReservationById(itemReservationId).getIsValid()){
            log.info("ItemReservation "+itemReservationId+" is checked out successfully");
            itemReservationMapper.returnItem(itemReservationId);
            return 1;
        }else{
            log.warn("ItemReservation "+itemReservationId+" does not exist or invalid, cannot be checked out");
            return 0;
        }

    }

    @Override
    public Integer cancelReservation(Integer itemReservationId) {
        if(findItemReservationById(itemReservationId)!=null&&findItemReservationById(itemReservationId).getIsValid()){
            if(findItemReservationById(itemReservationId).getStartTime().before(new Timestamp(System.currentTimeMillis()))){
                log.warn("ItemReservation "+itemReservationId+" has begun, cannot be canceled");
                return -1;
            }else{
                itemReservationMapper.cancelReservation(itemReservationId);
                log.info("ItemReservation "+itemReservationId+" is canceled out successfully");
                return 1;
            }
        }else{
            log.warn("ItemReservation "+itemReservationId+" does not exist or invalid, cannot be canceled");
            return 0;
        }
    }

    @Override
    public List<User> findUserByItem(Integer itemId) {
        return itemReservationMapper.findUserByItem(itemId);
    }
}