package hauhc1203.webthueny.models;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class MessageRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private AppUser person1;
    @ManyToOne
    private AppUser person2;

    private String room;



}
