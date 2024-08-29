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
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    // TODO: Add user_id 
    @Column(nullable = false)
    private Double totalAmount;

    @Column(nullable = false)
    private String status;

    @Column(updatable = false)
    private LocalDateTime created_at;
    
    private LocalDateTime updated_at;
}
