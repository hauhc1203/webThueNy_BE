package hauhc1203.webthueny.controller;

import hauhc1203.webthueny.models.Order;
import hauhc1203.webthueny.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderAPI {
    @Autowired
    OrderService orderService;

    @PostMapping("/{sv}")
    public void create(@RequestBody Order order,@PathVariable String sv){
        orderService.create(order,sv);
    }
    @GetMapping("/showBadOrder")
    public ResponseEntity<List<Order>>showBadOrder(){
        return new ResponseEntity<>(orderService.showBadOrder(), HttpStatus.OK);
    }
}
