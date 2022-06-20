package net.biancheng.c.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor //无参构造函数
@Data // 提供类的get、set、equals、hashCode、canEqual、toString 方法
@Accessors(chain = true)
abstract class Person {
    private Integer id;
    private String username;
    private String password;
    private String realName;
    private String address;
    private String email;
}
