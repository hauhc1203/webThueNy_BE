package hauhc1203.webthueny.services;

import hauhc1203.webthueny.models.AppUser;
import hauhc1203.webthueny.models.Order;
import hauhc1203.webthueny.models.ProvideService;
import hauhc1203.webthueny.models.Wallet;
import hauhc1203.webthueny.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    AppUserService appUserService;
    @Autowired
    ProvideServiceS provideServiceS;
    @Autowired
    WalletService walletService;
    public List<Order> getAll(){
        return (List<Order>) orderRepo.findAll();
    }

    public Order findById(long id){
        return orderRepo.findOrderById(id);
    }

    public void save(Order order){
        orderRepo.save(order);
    }

    public void create(Order order,String s){
        String [] sv=s.split(",");
        int size=sv.length;
        Set<ProvideService> services=new HashSet<>();

        for (int i = 0; i <size ; i++) {
            ProvideService provideService=new ProvideService();
            provideService.setId(Integer.parseInt(sv[i]));
            services.add(provideService);
        }
        Date now=new Date();
        AppUser appUser=appUserService.getAppUserByUserDetail();
        Wallet wallet=walletService.findByAppUserId(appUser.getId());
        wallet.setAmount(wallet.getAmount()-order.getTotal());

        walletService.save(wallet);

        order.setServices(services);
        order.setCreateDate(now);
        order.setAppUser(appUser);
        save(order);

    }

}
