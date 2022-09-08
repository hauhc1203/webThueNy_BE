package hauhc1203.webthueny.services;

import hauhc1203.webthueny.models.Order;
import hauhc1203.webthueny.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderService {
    @Autowired
    OrderRepo orderRepo;

    public List<Order> getAll(){
        return (List<Order>) orderRepo.findAll();
    }
}
