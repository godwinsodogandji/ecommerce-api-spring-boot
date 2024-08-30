package bj.highfiveuniveristy.ecommerce.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;


@Embeddable
public class OrderItemId implements Serializable {
    private Long orderId;
    private Long productId;
    

    /**
     * @return Long return the orderId
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * @return Long return the productId
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

}
