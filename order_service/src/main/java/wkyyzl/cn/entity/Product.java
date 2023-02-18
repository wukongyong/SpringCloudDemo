package wkyyzl.cn.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private Long id;
    private String productName;
    private Integer status;
    private Long price;
    private String productDesc;
    private String caption;
    private Integer inventory;
}
