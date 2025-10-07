package vn.iotstart.input;
import lombok.Data;
import java.util.Set;

@Data
public class CategoryInput {
    private String name;
    private Set<String> images;
}