package vn.iotstart.entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity 
@Table(name="product")
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor @Builder
public class Product {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;
  private Integer quantity;
  @Column(name="description") private String desc;
  private Double price;

  // Người đăng/thuộc về (theo đề có userid)
  @ManyToOne
  @JoinColumn(name="userid")
  private User user;

  // Product <-> Category (N-N) để hỗ trợ query theo category
  @ManyToMany
  @JoinTable(
      name = "product_category",
      joinColumns = @JoinColumn(name="product_id"),
      inverseJoinColumns = @JoinColumn(name="category_id")
  )
  private Set<Category> categories;
}

