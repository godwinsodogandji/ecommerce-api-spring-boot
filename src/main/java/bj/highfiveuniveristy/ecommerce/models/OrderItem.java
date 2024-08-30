package bj.highfiveuniveristy.ecommerce.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="order_items")
public class OrderItem {
    @EmbeddedId
    private OrderItemId id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn (name= "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn (name= "product_id", nullable = false)
    private Product product;
    @Column(nullable = false)
    private Integer quantity;

    @Column(updatable = false ,nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

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
