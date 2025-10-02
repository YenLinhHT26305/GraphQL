package vn.iotstart.controller;
import org.springframework.stereotype.Controller;
import vn.iotstart.entity.Category;
import vn.iotstart.entity.Product;
import vn.iotstart.entity.User;
import vn.iotstart.input.CategoryInput;
import vn.iotstart.input.ProductInput;
import vn.iotstart.input.UserInput;
import vn.iotstart.service.CategoryService;
import vn.iotstart.service.ProductService;
import vn.iotstart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class GraphQLController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    // ================= Queries =================

    @QueryMapping
    public List<Product> allProductsSortedByPrice() {
        return productService.findAllProductsSortedByPrice();
    }

    @QueryMapping
    public List<Product> productsByCategory(@Argument Long categoryId) {
        return productService.findProductsByCategory(categoryId);
    }

    @QueryMapping
    public List<User> users() {
        return userService.findAllUsers();
    }

    @QueryMapping
    public Optional<User> user(@Argument Long id) {
        return userService.findUserById(id);
    }

    @QueryMapping
    public List<Product> products() {
        return productService.findAllProducts();
    }

    @QueryMapping
    public Optional<Product> product(@Argument Long id) {
        return productService.findProductById(id);
    }

    @QueryMapping
    public List<Category> categories() {
        return categoryService.findAllCategories();
    }

    @QueryMapping
    public Optional<Category> category(@Argument Long id) {
        return categoryService.findCategoryById(id);
    }

    // ================= Mutations =================

    @MutationMapping
    public User createUser(@Argument UserInput input) {
        return userService.createUser(input);
    }

    @MutationMapping
    public User updateUser(@Argument Long id, @Argument UserInput input) {
        return userService.updateUser(id, input);
    }

    @MutationMapping
    public Boolean deleteUser(@Argument Long id) {
        return userService.deleteUser(id);
    }

    @MutationMapping
    public Product createProduct(@Argument ProductInput input) {
        return productService.createProduct(input);
    }

    @MutationMapping
    public Product updateProduct(@Argument Long id, @Argument ProductInput input) {
        return productService.updateProduct(id, input);
    }

    @MutationMapping
    public Boolean deleteProduct(@Argument Long id) {
        return productService.deleteProduct(id);
    }

    @MutationMapping
    public Category createCategory(@Argument CategoryInput input) {
        return categoryService.createCategory(input);
    }

    @MutationMapping
    public Category updateCategory(@Argument Long id, @Argument CategoryInput input) {
        return categoryService.updateCategory(id, input);
    }

    @MutationMapping
    public Boolean deleteCategory(@Argument Long id) {
        return categoryService.deleteCategory(id);
    }
}

