package vn.iotstart.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iotstart.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {}

