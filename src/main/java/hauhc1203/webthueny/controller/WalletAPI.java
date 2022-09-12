package hauhc1203.webthueny.controller;

import hauhc1203.webthueny.models.AppUser;
import hauhc1203.webthueny.models.Wallet;
import hauhc1203.webthueny.services.AppUserService;
import hauhc1203.webthueny.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wallet")
@CrossOrigin("*")
public class WalletAPI {
    @Autowired
    WalletService walletService;
    @Autowired
    AppUserService  appUserService;

    @GetMapping
    public ResponseEntity<Wallet> getWallet(){
        AppUser appUser=appUserService.getAppUserByUserDetail();
        return new ResponseEntity<>(walletService.findByAppUserId(appUser.getId()), HttpStatus.OK);
    }

}
