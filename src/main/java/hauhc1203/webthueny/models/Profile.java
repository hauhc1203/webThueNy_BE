package hauhc1203.webthueny.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String fullName;
    private String avatar;
    private  String email;
    private Date birthDay;
    private double walletBalance;
    private boolean gender;

    @OneToOne
    private Account account;




}
