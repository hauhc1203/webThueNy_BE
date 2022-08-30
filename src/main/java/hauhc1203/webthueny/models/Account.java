package hauhc1203.webthueny.models;

import hauhc1203.webthueny.configs.constant.AccountConst;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Account{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String passWord;
    @ManyToOne
    private Role role;
    private int status= AccountConst.OFFLINE;
    private boolean isConfirm=false;
}
