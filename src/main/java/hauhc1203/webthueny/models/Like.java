package hauhc1203.webthueny.models;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "Likesss")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Post post;
    @ManyToOne
    private Account account;


}

