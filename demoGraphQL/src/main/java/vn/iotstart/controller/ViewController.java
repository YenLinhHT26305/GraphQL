package vn.iotstart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import vn.iotstart.entity.Product;
import vn.iotstart.input.CategoryInput;
import vn.iotstart.input.ProductInput;
import vn.iotstart.input.UserInput;
import vn.iotstart.service.ProductService;
import vn.iotstart.service.CategoryService;
import vn.iotstart.service.UserService;

import java.util.List;

@Controller
public class ViewController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String index(Model model) {
        List<Product> products = productService.findAllProducts();
        model.addAttribute("products", products);

        // Thêm object rỗng cho form
        model.addAttribute("userInput", new UserInput());
        model.addAttribute("categoryInput", new CategoryInput());
        model.addAttribute("productInput", new ProductInput());

        return "index";
    }

    // Tạo Category
    @PostMapping("/categories")
    public String createCategory(CategoryInput input) {
        categoryService.createCategory(input);
        return "redirect:/home"; 
    }

    // Tạo User
    @PostMapping("/users")
    public String createUser(UserInput input) {
        userService.createUser(input);
        return "redirect:/home";
    }
}
