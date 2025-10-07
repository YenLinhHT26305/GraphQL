package vn.iotstart.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Ảnh (1-nhiều đơn giản)
    @ElementCollection
    @CollectionTable(name = "category_images", joinColumns = @JoinColumn(name = "category_id"))
    @Column(name = "image_url")
    private Set<String> images = new HashSet<>();

    // Quan hệ với Product
    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new HashSet<>();

    // Quan hệ với User (để phản chiếu user_category)
    @ManyToMany(mappedBy = "categories")
    private Set<User> users = new HashSet<>();
}
