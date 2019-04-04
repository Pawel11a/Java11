package project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String goals;

    @OneToMany(mappedBy = "player", cascade = CascadeType.PERSIST)
    private Set<PlayerCard> PlayerCards;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "position_id")
    private Position positionId;
    @OneToOne
    @JoinColumn(name = "healt_card_id")
    private HealtCard healtCard;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;


}
