package net.biancheng.c.dto;

import lombok.Data;

@Data
public class ItemDTO {
    private Integer id;
    private String category;
    private Integer price;
    private String name;
    private Boolean isInLibrary;
}
