package hauhc1203.webthueny.repository;

import hauhc1203.webthueny.models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepo extends JpaRepository<Wallet,Long> {
    Wallet findByAppUser_Id(long idAppUser);
}
