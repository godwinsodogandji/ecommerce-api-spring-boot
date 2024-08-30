package bj.highfiveuniveristy.ecommerce.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bj.highfiveuniveristy.ecommerce.models.OrderItem;
import bj.highfiveuniveristy.ecommerce.models.OrderItemId;
import bj.highfiveuniveristy.ecommerce.services.OrderItemService;

@RestController
@RequestMapping("/api/orderitems")
public class OrderItemController {
   
    @Autowired
    private OrderItemService orderItemService;
    @GetMapping
    public List<OrderItem> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable OrderItemId id) {
        OrderItem OrderItem = orderItemService.getOrderItemById(id);
        return ResponseEntity.ok(OrderItem);
    }

    @PostMapping()
    public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem OrderItem) {
        OrderItem newOrderItem = orderItemService.createOrderItem(OrderItem);
        return ResponseEntity.ok(newOrderItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItem> updateOrderItem(@PathVariable OrderItemId id, @RequestBody OrderItem orderItem) {
        OrderItem OrderItemToUpdate = orderItemService.updateOrderItem(id, orderItem);
        return ResponseEntity.ok(OrderItemToUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable OrderItemId id) {
        orderItemService.deleteOrderItem(id);
        return ResponseEntity.noContent().build();
    }
}
