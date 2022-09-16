package hauhc1203.webthueny.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMessage;
    @ManyToOne
    private AppUser sender;

    @ManyToOne
    private AppUser receiver;

    private String content;

    private Date time;
    @OneToOne
    private RoomChat roomChat;

}

