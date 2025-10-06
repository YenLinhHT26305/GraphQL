package vn.iotstart.dto;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ProductDTO {

    @NotBlank(message = "Tên sản phẩm không được để trống")
    private String title;

    @NotNull(message = "Số lượng bắt buộc nhập")
    @Min(value = 0, message = "Số lượng phải >= 0")
    private Integer quantity;

    @Size(max = 1000, message = "Mô tả tối đa 1000 ký tự")
    private String desc;

    @NotNull(message = "Giá sản phẩm bắt buộc nhập")
    @DecimalMin(value = "0.01", message = "Giá phải > 0")
    private Double price;

    @NotNull(message = "Phải chọn người đăng (userId)")
    private Long userId;

    // getter & setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
