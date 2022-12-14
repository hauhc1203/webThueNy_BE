package hauhc1203.webthueny.models;

import hauhc1203.webthueny.config.constant.AccountConst;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String userName;
    private String passWord;
    private String email;
    private String phoneNumber;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;
    private int status = AccountConst.OFFLINE;
    private String confirmCode;
    private boolean isConfirm = false;
    private boolean vip = false;


}
