package hauhc1203.webthueny.services;

import hauhc1203.webthueny.config.constant.OrderConst;
import hauhc1203.webthueny.models.*;
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
    ProfileService profileService;
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

    public Order save(Order order){
       return orderRepo.save(order);
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

    public List<Order> orderSuccess(){
        return orderRepo.OrderSuccess();
    }


    public Page<Order> getbyu(Pageable pageable){
        AppUser appUser=appUserService.getAppUserByUserDetail();
      return   orderRepo.getAllByAppUserIdOrderByStatusAsc(appUser.getId(),pageable);
    }
    public Page<Order> getbyp(Pageable pageable){
        AppUser appUser=appUserService.getAppUserByUserDetail();
        Profile profile=profileService.findByAppUserID(appUser.getId());
        return   orderRepo.getAllByProfileIdOrderByStatusAsc(profile.getId(),pageable);
    }
    public Order acceptOrder(Order order){
        Order order1=orderRepo.findOrderById(order.getId());
        order1.setMessFromCCDV(order.getMessFromCCDV());
        order1.setStatus(OrderConst.ACCEPTED);
        return save(order1);
    }
    public Order dOrder(Order order){
        Order order1=orderRepo.findOrderById(order.getId());
        order1.setMessFromCCDV(order.getMessFromCCDV());
        order1.setStatus(OrderConst.REFUSED);
        return save(order1);
    }
    public Order cOrder(long id){
        Order order=orderRepo.findOrderById(id);
        order.setStatus(OrderConst.CANCEL);
        return save(order);
    }
    public Order dfu(long id){
        Order order=orderRepo.findOrderById(id);
        order.setDoneFromUser(true);
        if (order.isDoneFromCCDV()){
            order.setStatus(OrderConst.DONE);
            payment(order);
        }else {
            order.setStatus(OrderConst.WAIT_DONE);
        }
        return save(order);
    }
    public Order dfc(long id){
        Order order=orderRepo.findOrderById(id);
        order.setDoneFromCCDV(true);
        if (order.isDoneFromUser()){
            order.setStatus(OrderConst.DONE);
            payment(order);
        }else {
            order.setStatus(OrderConst.WAIT_DONE);
        }
        return save(order);
    }
    public void payment( Order order){
        Wallet wallet=walletService.findByAppUserId(order.getProfile().getAppUser().getId());
        wallet.setAmount(wallet.getAmount()+order.getTotal());
        walletService.save(wallet);
    }

}


