package vn.iotstart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.iotstart.service.ProductService;

@Controller
@RequestMapping("/user")
public class UserController {

    private final ProductService productService;

    public UserController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String userHome(Model model) {
        model.addAttribute("products", productService.findAllProducts());
        return "user/index"; // trang hiển thị sản phẩm
    }
}
