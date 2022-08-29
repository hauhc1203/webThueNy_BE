package hauhc1203.webthueny.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Post post;
    @ManyToOne
    private Comment comment;
    private String content;
    @ManyToOne
    private Account account;
    private Date commentDate;
}

