package hauhc1203.webthueny.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "reportsss")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private AppUser from;
    @ManyToOne
    private Order about;
    private String problem;
    private String reason;
    private boolean isConfirm=false;



}
