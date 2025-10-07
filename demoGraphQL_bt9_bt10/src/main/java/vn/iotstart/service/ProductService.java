package vn.iotstart.service;
import java.util.List;
import java.util.Optional;

import vn.iotstart.dto.ProductDTO;
import vn.iotstart.entity.Product;
import vn.iotstart.input.ProductInput;

public interface ProductService {
    Product createProduct(ProductInput input);
    Product updateProduct(Long id, ProductInput input);
    boolean deleteProduct(Long id);
    List<Product> findAllProducts();
    Optional<Product> findProductById(Long id);
    List<Product> findAllProductsSortedByPrice();
    List<Product> findProductsByCategory(Long categoryId);
    
    Product create(ProductDTO productDTO);
}




