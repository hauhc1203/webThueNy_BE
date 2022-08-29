package hauhc1203.webthueny.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Evaluate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int rate;

    private String comment;

    private Date evalueteDate;

    @ManyToOne
    private Account account;


    @ManyToOne
    private Lover lover;


}
