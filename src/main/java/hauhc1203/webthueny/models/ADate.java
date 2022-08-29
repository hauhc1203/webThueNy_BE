package hauhc1203.webthueny.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class ADate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int time;
    private Date startTime;
    @ManyToOne
    private Lover lover;
    @ManyToOne
    private Account account;
    private boolean status;
}
