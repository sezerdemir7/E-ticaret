package com.demirr.eticaret.controller;

import com.demirr.eticaret.dto.response.OrderDetailResponse;
import com.demirr.eticaret.entities.OrderDetail;
import com.demirr.eticaret.service.OrderDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orderdetail")
public class OrderDetailController {
    private final OrderDetailService orderDetailService;

    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<List<OrderDetailResponse>> getOrderDetail(@RequestParam Long orderId){
        return new ResponseEntity<>(orderDetailService.getOrderDetailByOrderId(orderId), HttpStatus.OK);
    }
}
