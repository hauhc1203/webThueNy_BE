package hauhc1203.webthueny.controller;

import hauhc1203.webthueny.models.Order;
import hauhc1203.webthueny.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
@CrossOrigin("*")
public class OrderAPI {
    @Autowired
    OrderService orderService;

    @PostMapping("/{sv}")
    public void create(@RequestBody Order order,@PathVariable String sv){
        orderService.create(order,sv);
    }
}
