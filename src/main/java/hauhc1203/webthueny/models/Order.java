package hauhc1203.webthueny.models;

import hauhc1203.webthueny.config.constant.OrderConst;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

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

    private boolean doneFromUser;
    private String messFromUser;
    private boolean doneFromCCDV;
    private String messFromCCDV;

    private double total;

    private int status = OrderConst.AWAITING;

}
