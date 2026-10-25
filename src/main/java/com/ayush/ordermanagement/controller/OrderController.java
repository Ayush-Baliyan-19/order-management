package com.ayush.ordermanagement.controller;

import com.ayush.ordermanagement.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    private void createOrder(){
        log.info("Adding an order");
        orderService.createOrder();
    }

    @GetMapping("/:orderId")
    private void getOrder(@RequestParam String orderId) {
        orderService.getOrder();
    }

    @PutMapping("/:orderId")
    private void updateOrder(@RequestParam String orderId) {
        orderService.getOrder();
    }
}
