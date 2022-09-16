package hauhc1203.webthueny.controller;

import hauhc1203.webthueny.models.Feedback;
import hauhc1203.webthueny.models.Order;
import hauhc1203.webthueny.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @GetMapping("find/{id}")
    public ResponseEntity<Order> findByID(@PathVariable int id){
        return  new ResponseEntity<>(orderService.findById(id), HttpStatus.OK);
    }

    @GetMapping("getbyu")
    public ResponseEntity<Page<Order>> getbyu(@RequestParam int page){
            return  new ResponseEntity<>(orderService.getbyu( PageRequest.of(page,8)), HttpStatus.OK);
    }
    @GetMapping("getbyp")
    public ResponseEntity<Page<Order>> getbyp(@RequestParam int page){
        return  new ResponseEntity<>(orderService.getbyp( PageRequest.of(page,8)), HttpStatus.OK);
    }

    @GetMapping("dfu/{id}")
    public ResponseEntity<Order> dfu(@PathVariable long id){
        return  new ResponseEntity<>(orderService.dfu(id), HttpStatus.OK);
    }

    @GetMapping("dfc/{id}")
    public ResponseEntity<Order> dfc(@PathVariable long id){
        return  new ResponseEntity<>(orderService.dfc(id), HttpStatus.OK);
    }

    @PostMapping("accept")
    public ResponseEntity<Order> accept(@RequestBody Order  order){
        return  new ResponseEntity(orderService.acceptOrder(order),HttpStatus.OK);
    }
    @PostMapping("decline")
    public ResponseEntity<Order> declineO(@RequestBody Order  order){
        return  new ResponseEntity(orderService.dOrder(order),HttpStatus.OK);
    }
    @GetMapping("cancel/{id}")
    public ResponseEntity<Order> cancelO(@PathVariable long   id){
        return  new ResponseEntity(orderService.cOrder(id ),HttpStatus.OK);
    }


}
