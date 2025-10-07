package vn.iotstart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.iotstart.service.ProductService;
import vn.iotstart.service.CategoryService;
import vn.iotstart.dto.ProductDTO;
import vn.iotstart.dto.CategoryDTO;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ProductService productService;
    private final CategoryService categoryService;

    public AdminController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String dashboard() {
        return "admin/index"; // trang tổng quan admin
    }

    @GetMapping("/products")
    public String manageProducts(Model model) {
        model.addAttribute("products", productService.findAllProducts());
        model.addAttribute("productDTO", new ProductDTO());
        return "admin/product"; // form + list product
    }

    @GetMapping("/categories")
    public String manageCategories(Model model) {
        model.addAttribute("categories", categoryService.findAllCategories());
        model.addAttribute("categoryDTO", new CategoryDTO());
        return "admin/category"; // form + list category
    }
}
