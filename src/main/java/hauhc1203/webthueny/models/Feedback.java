package hauhc1203.webthueny.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private AppUser from;
    @ManyToOne
    private Order order;
    private String content;
    private int isGoodFeedBack;
    private boolean isConfirm=true;

}

