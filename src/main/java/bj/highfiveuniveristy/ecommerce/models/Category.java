package bj.highfiveuniveristy.ecommerce.models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    
    @Column(updatable = false , nullable = false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
  
    @ManyToMany(mappedBy = "categories")
    private List<Product> products;

    //s'exécute quand on insère une donnée
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    // s'exécute quand on modifie une donnée
    @PreUpdate
    protected void onUpdate() {
        updatedAt= LocalDateTime.now();
    }
}
