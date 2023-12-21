package com.demirr.eticaret.controller;

import com.demirr.eticaret.dto.response.OrderResponse;
import com.demirr.eticaret.entities.Order;
import com.demirr.eticaret.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/siparis")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/aktif/{customerId}")
    public List<OrderResponse> getActiveOrdersByCustomerId(@RequestParam Long customerId){
        return orderService.getActiveOrdersByCustomerId(customerId);
    }

    @GetMapping("/tamamlanan/{customerId}")
    public List<Order> getCompletedOrdersByCustomerId(@RequestParam Long customerId){
        return orderService.getCompletedOrdersByCustomerId(customerId);
    }
}
