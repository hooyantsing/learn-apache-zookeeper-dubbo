package xyz.hooy.order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.hooy.order.api.entity.FullOrder;
import xyz.hooy.order.service.OrderService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order-detail")
public class OrderDetailController {

    private final OrderService orderService;

    @GetMapping("/{orderId}")
    public FullOrder testThrough(@PathVariable("orderId") Long orderId) {
        return orderService.getOrder();
    }
}
