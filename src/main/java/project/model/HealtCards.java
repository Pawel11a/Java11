package project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "healt_cards")
public class HealtCards {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Date examinationDate;
    private String notes;

    @OneToOne(mappedBy = "healtCard")
    private Player player;

//    @ElementCollection
//    @CollectionTable(
//            name = "injuries",
//            joinColumns = @JoinColumn(name = "injury_id", referencedColumnName = "id")
//    )
//    @Column(name = "injury")
//    @C
//    private Set<Injuries> injuries;

}
/*
  @ElementCollection
    @CollectionTable(
            name = "skills",
            joinColumns = @JoinColumn(name = "programmer_id", referencedColumnName = "id")
    )
    @Column(name = "skill")
    @Enumerated(EnumType.STRING)
    private Set<Skill> skills;
 */