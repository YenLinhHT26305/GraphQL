package vn.iotstart.dto;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    @NotBlank(message = "Họ tên không được để trống")
    private String fullname;

    @Email(message = "Email không hợp lệ")
    @NotBlank(message = "Email bắt buộc")
    private String email;

    @Size(min = 6, message = "Mật khẩu tối thiểu 6 ký tự")
    private String password;

    @Pattern(regexp = "^\\d{9,11}$", message = "SĐT 9-11 chữ số")
    private String phone;

    // getter/setter
}
