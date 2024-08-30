package bj.highfiveuniveristy.ecommerce.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bj.highfiveuniveristy.ecommerce.models.OrderItem;
import bj.highfiveuniveristy.ecommerce.models.OrderItemId;
import bj.highfiveuniveristy.ecommerce.repositories.OrderItemRepository;

@Service
public class OrderItemService {
     @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public OrderItem getOrderItemById( OrderItemId id) {
        OrderItem orderItem = orderItemRepository.findById(id).orElseThrow(() -> new RuntimeException("aucun utilisateur trouvé"));
        return orderItem;
    }

 
    public OrderItem createOrderItem(OrderItem orderItem) {
        OrderItem newOrderItem = orderItemRepository.save(orderItem);
        return newOrderItem;
    }

    public OrderItem updateOrderItem( OrderItemId id,  OrderItem orderItem) {
        OrderItem orderItemToUpdate = orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderItem avec l'id " + id + " non trouvé"));
        orderItemToUpdate.setOrder(orderItem.getOrder());
        orderItemToUpdate.setProduct(orderItem.getProduct());
        orderItemToUpdate.setQuantity(orderItem.getQuantity());
        return orderItemToUpdate;
    }

    public void deleteOrderItem( OrderItemId id) {
        orderItemRepository.deleteById(id);
    }
}
