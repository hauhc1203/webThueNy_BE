package hauhc1203.webthueny.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class RelationShip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Account myAcc;
    @ManyToOne
    private Account yourAcc;
    private String relationName;
}
