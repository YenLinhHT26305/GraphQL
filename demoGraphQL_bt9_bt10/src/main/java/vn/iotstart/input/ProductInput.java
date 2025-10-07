package vn.iotstart.input;
import lombok.Data;

import java.util.Set;

@Data
public class ProductInput {
    private String title;
    private Integer quantity;
    private String desc;
    private Double price;
    private Long userId;
    private Set<Long> categoryIds;
} 

