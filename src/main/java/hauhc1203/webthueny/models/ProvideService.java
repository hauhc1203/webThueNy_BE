package hauhc1203.webthueny.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ProvideService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String category;

}

