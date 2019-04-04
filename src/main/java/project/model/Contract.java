package project.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "contracts")
public class Contract {

    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal cost;
    private Date expirationDate;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;


}
