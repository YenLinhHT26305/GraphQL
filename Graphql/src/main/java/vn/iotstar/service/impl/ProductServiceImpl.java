package vn.iotstar.service.impl;

import vn.iotstar.entity.Category;
import vn.iotstar.entity.Product;
import vn.iotstar.entity.User;
import vn.iotstar.input.ProductInput;
import vn.iotstar.repository.CategoryRepository;
import vn.iotstar.repository.ProductRepository;
import vn.iotstar.repository.UserRepository;
import vn.iotstar.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Product createProduct(ProductInput input) {
        Product product = new Product();
        product.setTitle(input.getTitle());
        product.setQuantity(input.getQuantity());
        product.setDesc(input.getDesc());
        product.setPrice(input.getPrice());
        Optional<User> user = userRepository.findById(input.getUserId());
        user.ifPresent(product::setUser);
        if (input.getCategoryIds() != null) {
            product.setCategories(input.getCategoryIds().stream()
                    .map(categoryRepository::findById)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toSet()));
        }
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, ProductInput input) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            if (input.getTitle() != null) product.setTitle(input.getTitle());
            if (input.getQuantity() != null) product.setQuantity(input.getQuantity());
            if (input.getDesc() != null) product.setDesc(input.getDesc());
            if (input.getPrice() != null) product.setPrice(input.getPrice());
            if (input.getUserId() != null) {
                Optional<User> user = userRepository.findById(input.getUserId());
                user.ifPresent(product::setUser);
            }
            if (input.getCategoryIds() != null) {
                product.setCategories(input.getCategoryIds().stream()
                        .map(categoryRepository::findById)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toSet()));
            }
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public boolean deleteProduct(Long id) {
        productRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAllProductsSortedByPrice() {
        return productRepository.findAllByOrderByPriceAsc();
    }

    @Override
    public List<Product> findProductsByCategory(Long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        return new ArrayList<>(category.map(Category::getProducts).orElse(Set.of()));
    }
}