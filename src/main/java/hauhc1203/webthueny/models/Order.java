package hauhc1203.webthueny.models;

import hauhc1203.webthueny.config.constant.OrderConst;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;


@Entity
@Data
@Table(name = "ordersss")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int time;
    private int startTime;
    private String address;
    private Date datingTime;
    @ManyToOne
    private Profile profile;
    @ManyToOne
    private AppUser appUser;

    private java.util.Date createDate;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<ProvideService> services;
//    @OneToOne
//    private Feedback feedBack;
//    @OneToOne
//    private Feedback feedBackFromCCDV;

    private boolean doneFromUser=false;
    private String messFromUser;
    private boolean doneFromCCDV=false;
    private String messFromCCDV;

    private double total;

    private int status= OrderConst.AWAITING;
    private int process;



}
