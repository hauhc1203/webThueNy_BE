package hauhc1203.webthueny.controller;

import hauhc1203.webthueny.models.AppUser;
import hauhc1203.webthueny.models.Wallet;
import hauhc1203.webthueny.models.dto.WalletUser;
import hauhc1203.webthueny.repository.WalletRepo;
import hauhc1203.webthueny.services.AppUserService;
import hauhc1203.webthueny.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("wallet")
@CrossOrigin("*")
public class WalletAPI {
    @Autowired
    WalletService walletService;

    @Autowired
    WalletRepo walletRepo;
    @Autowired
    AppUserService  appUserService;

    @GetMapping
    public ResponseEntity<Wallet> getWallet(){
        AppUser appUser=appUserService.getAppUserByUserDetail();
        return new ResponseEntity<>(walletService.findByAppUserId(appUser.getId()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Wallet> recharge(@RequestBody WalletUser walletUser) {
        return new ResponseEntity<>(walletService.chagre(walletUser),HttpStatus.OK);
    }




}
