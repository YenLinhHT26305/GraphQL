package vn.iotstart.service.impl;
import vn.iotstart.entity.Category;
import vn.iotstart.repository.CategoryRepository;
import vn.iotstart.service.CategoryService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import vn.iotstart.input.CategoryInput;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(CategoryInput input) {
        Category category = new Category();
        category.setName(input.getName());
        category.setImages(input.getImages());
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, CategoryInput input) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            if (input.getName() != null) category.setName(input.getName());
            if (input.getImages() != null) category.setImages(input.getImages());
            return categoryRepository.save(category);
        }
        return null;
    }

    @Override
    public boolean deleteCategory(Long id) {
        categoryRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findCategoryById(Long id) {
        return categoryRepository.findById(id);
    }
}