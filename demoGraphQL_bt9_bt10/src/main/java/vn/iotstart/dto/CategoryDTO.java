package vn.iotstart.dto;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CategoryDTO {

    @NotBlank(message = "Tên danh mục không được để trống")
    private String name;

    @Size(max = 255, message = "Đường dẫn hình ảnh tối đa 255 ký tự")
    private String images;

    // getter & setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}

