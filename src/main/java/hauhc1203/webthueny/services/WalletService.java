package hauhc1203.webthueny.services;

import hauhc1203.webthueny.models.AppUser;
import hauhc1203.webthueny.models.Wallet;
import hauhc1203.webthueny.models.dto.WalletUser;
import hauhc1203.webthueny.repository.WalletRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
    @Autowired
    WalletRepo walletRepo;
    public Wallet save(Wallet wallet){
      return   walletRepo.save(wallet);
    }

    public Wallet findByAppUserId(long id){
        return walletRepo.findByAppUser_Id(id);
    }

    public void setWalletByAppUserId(double number,long id){
       walletRepo.setMoneyVi(number,id);
    }

    public double getWallet(long id){
        return  walletRepo.getMoneyVi(id);
    }

    public Wallet chagre(WalletUser walletUser){
        Wallet wallet =walletRepo.findById(walletUser.getId()).get();
        wallet.setAmount(wallet.getAmount()+walletUser.getNumberMoney());
      return   save(wallet);
    }

}
