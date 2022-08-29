package hauhc1203.webthueny.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Lover {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Sector sector ;
    private String nickName;
    private String avatar;
    private double  cost;
    private String introduction;
    private boolean status;
    @Lob
    private byte[] voice;
    private Date createDate;
    @ManyToOne
    private Account account;


}
