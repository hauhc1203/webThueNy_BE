package hauhc1203.webthueny.services;

import hauhc1203.webthueny.models.Order;
import hauhc1203.webthueny.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;

    public List<Order> getAll(){
        return (List<Order>) orderRepo.findAll();
    }


}
