package vn.iotstart.entity;

import jakarta.persistence.*;
import lombok.*;
import vn.iotstart.security.Role;

import java.util.HashSet;
import java.util.Set;

@Entity 
@Table(name="users")
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder
public class User {
  @Id 
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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
  @Builder.Default
  private Set<Category> categories = new HashSet<>();

  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(
		    name = "user_roles",
		    joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
		)
  @Enumerated(EnumType.STRING)
  @Builder.Default
  private Set<Role> roles = new HashSet<>();
}

