package hauhc1203.webthueny.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class RoomChat {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long idRoom;
@ManyToOne
private AppUser sender;
@ManyToOne
private AppUser  receiver;

}
