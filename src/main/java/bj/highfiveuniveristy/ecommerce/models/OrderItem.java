package bj.highfiveuniveristy.ecommerce.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    @Id
    @GeneratedValue
    private Long id;
    //TODO: Add order_id 
    //TODO: Add product_id
    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Double price;

    @Column(updatable = false)
    private LocalDateTime created_at;

    private LocalDateTime updated_at;
}
