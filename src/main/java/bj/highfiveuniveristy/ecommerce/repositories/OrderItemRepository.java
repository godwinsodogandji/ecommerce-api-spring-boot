package bj.highfiveuniveristy.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import bj.highfiveuniveristy.ecommerce.models.OrderItem;
import bj.highfiveuniveristy.ecommerce.models.OrderItemId;

public interface OrderItemRepository  extends JpaRepository<OrderItem, OrderItemId>{

}
