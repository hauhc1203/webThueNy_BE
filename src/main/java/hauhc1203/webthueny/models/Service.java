package hauhc1203.webthueny.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String category;

}

