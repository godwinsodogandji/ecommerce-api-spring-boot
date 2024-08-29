package bj.highfiveuniveristy.ecommerce.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderItem {
    @Id
    @GeneratedValue
    private Long id;
    //TODO: Add order_id 
    //TODO: Add product_id
    private Integer quantity;
    private Double price;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
