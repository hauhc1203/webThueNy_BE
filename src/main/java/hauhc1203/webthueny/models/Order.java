package hauhc1203.webthueny.models;

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
    private Date datingTime;
    @ManyToOne
    private Profile profile;
    @ManyToOne
    private Account account;
    private double total;
    private boolean status;

}
