package vn.iotstart.repository;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.iotstart.entity.Product;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
  // Lấy tất cả product theo price tăng dần
  List<Product> findAllByOrderByPriceAsc();

  // Lấy product theo category id (join bảng N-N)
  @Query("""
     select p from Product p join p.categories c
     where c.id = :categoryId
  """)
  List<Product> findByCategoryId(@Param("categoryId") Long categoryId);
}

