package hauhc1203.webthueny.services;

import hauhc1203.webthueny.models.Wallet;
import hauhc1203.webthueny.repository.WalletRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;

@Service
public class WalletService {
    @Autowired
    WalletRepo walletRepo;

    public void save(Wallet wallet){
        walletRepo.save(wallet);
    }

    public Wallet findByAppUserId(long id){
        return walletRepo.findByAppUser_Id(id);
    }


}
