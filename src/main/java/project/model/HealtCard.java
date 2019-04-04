package project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "health_cards")
public class HealtCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date examinationDate;
    private String notes;

    @OneToOne(mappedBy = "healtCard")
    private Player player;

    @ElementCollection
    @CollectionTable(
            name = "injuries",
            joinColumns = @JoinColumn(name = "health_card_id", referencedColumnName = "id")
    )
    @Column(name = "injury")
    private List<Injury> injuries;


}
