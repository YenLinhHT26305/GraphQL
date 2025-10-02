package vn.iotstart.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity 
@Table(name="users")
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor @Builder
public class User {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String fullname;
  private String email;
  private String password;
  private String phone;

  // User <-> Category (N-N)
  @ManyToMany
  @JoinTable(
      name = "user_category",
      joinColumns = @JoinColumn(name="user_id"),
      inverseJoinColumns = @JoinColumn(name="category_id")
  )
  private Set<Category> categories;
}
