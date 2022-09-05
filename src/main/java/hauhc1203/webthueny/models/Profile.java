package hauhc1203.webthueny.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String fullName;

    private java.sql.Date birthDay;

    @ManyToOne
    private City city ;
    @ManyToOne
    private Country country;

    private String avatar;

    private String img1;

    private String img2;

    private String img3;

    private float high;

    private float weight;

    private String hobby;

    private String introduction;

    private String facebookLink;

    private double  cost;

    private int status;
    private String requirementsForHirer;
    private Date createDate;
    private boolean fullFill;
    @ManyToMany(fetch = FetchType.EAGER )
    private Set<Service> serviceList;
    @OneToOne
    private AppUser appUser;


}
