package net.biancheng.c.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor //无参构造函数
@Data // 提供类的get、set、equals、hashCode、canEqual、toString 方法
@Accessors(chain = true)
public class Item {
    private Integer id;
    private String category;
    private Integer price;
    private String name;
    private Boolean isInLibrary;

}
