package vn.iotstar.service;

import vn.iotstar.entity.Category;
import vn.iotstar.input.CategoryInput;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Category createCategory(CategoryInput input);
    Category updateCategory(Long id, CategoryInput input);
    boolean deleteCategory(Long id);
    List<Category> findAllCategories();
    Optional<Category> findCategoryById(Long id);
}