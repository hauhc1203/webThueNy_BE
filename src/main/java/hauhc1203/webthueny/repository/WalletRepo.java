package hauhc1203.webthueny.repository;

import hauhc1203.webthueny.models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface WalletRepo extends JpaRepository<Wallet,Long> {
    Wallet findByAppUser_Id(long idAppUser);
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "UPDATE wallet SET amount =:number WHERE (id =:id);")
    void setMoneyVi(@Param("number") double number,@Param("id")long id);

    @Query(nativeQuery = true,value = "Select amount from wallet where id=:id")
    double getMoneyVi(@Param("id")long id);

    Wallet findByAppUserId(long id);
}
