package com.devsuperior.rubens.spring.services;

import com.devsuperior.rubens.spring.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final ShippingService shippingService;

    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public double total(Order order) {
        double shipment = shippingService.shipment(order);
        double discountValue = (order.getDiscount() / 100) * order.getBasic();
        return order.getBasic() - discountValue + shipment;
    }
}
