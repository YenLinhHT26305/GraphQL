package vn.iotstar.service;

import vn.iotstar.entity.Product;
import vn.iotstar.input.ProductInput;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product createProduct(ProductInput input);
    Product updateProduct(Long id, ProductInput input);
    boolean deleteProduct(Long id);
    List<Product> findAllProducts();
    Optional<Product> findProductById(Long id);
    List<Product> findAllProductsSortedByPrice();
    List<Product> findProductsByCategory(Long categoryId);
}