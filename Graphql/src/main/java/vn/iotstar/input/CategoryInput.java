package vn.iotstar.input;

import lombok.Data;

import java.util.Set;

@Data
public class CategoryInput {
    private String name;
    private Set<String> images;
}