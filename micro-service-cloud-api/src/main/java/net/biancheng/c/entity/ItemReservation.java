package net.biancheng.c.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

@NoArgsConstructor //无参构造函数
@Data // 提供类的get、set、equals、hashCode、canEqual、toString 方法
@Accessors(chain = true)
public class ItemReservation {
    private Integer itemReservationId;
    private Integer userId;
    private Integer itemId;
    private Timestamp startTime;
    private Timestamp endTime;
}
