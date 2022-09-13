package hauhc1203.webthueny.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import hauhc1203.webthueny.config.constant.ProfileConst;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String fullName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDay;

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

    private boolean gender;

    private int status;

    private String requirementsForHirer;

    private Date createDate;

    private int isConfirm= ProfileConst.INIT_STATE;

    private String messFromAdmin;

    @ManyToMany(fetch = FetchType.EAGER )

    private Set<ProvideService> serviceList;

    @OneToOne
    private AppUser appUser;


    private long views;

    private int hireTimes;


}
