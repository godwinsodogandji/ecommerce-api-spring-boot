package bj.highfiveuniveristy.ecommerce.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bj.highfiveuniveristy.ecommerce.models.Order;
import bj.highfiveuniveristy.ecommerce.repositories.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    public Order getOrderById( Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("aucun utilisateur trouvé"));
        return order;
    }

    public Order createOrder( Order order) {
        Order newOrder = orderRepository.save(order);
        return newOrder;
    }
    
    public Order updateOrder( Long id,  Order order) {
        Order orderToUpdate = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order avec l'id " + id + " non trouvé"));
        orderToUpdate.setOrderItems(order.getOrderItems());
        orderToUpdate.setStatus(order.getStatus());
        orderToUpdate.setTotalAmount(order.getTotalAmount());
        orderToUpdate.setUser(order.getUser());
        return orderToUpdate;
    }
    
    public void deleteOrder( Long id) {
        orderRepository.deleteById(id);
    }
}
