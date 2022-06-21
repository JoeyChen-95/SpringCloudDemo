package net.biancheng.c.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ItemReservationDTO {
    private Integer userId;
    private Integer itemId;
    private Timestamp startTime;
    private Timestamp endTime;
}
