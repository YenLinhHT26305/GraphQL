package vn.iotstart.service;
import java.util.List;
import java.util.Optional;

import vn.iotstart.dto.CategoryDTO;
import vn.iotstart.entity.Category;
import vn.iotstart.input.CategoryInput;

public interface CategoryService {
    Category createCategory(CategoryInput input);
    Category updateCategory(Long id, CategoryInput input);
    boolean deleteCategory(Long id);
    List<Category> findAllCategories();
    Optional<Category> findCategoryById(Long id);
    
    Category create(CategoryDTO dto);
}