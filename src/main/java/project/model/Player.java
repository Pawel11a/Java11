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
    private Integer id;

    private String name;
    private String goals;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private Set<PlayersCards> PlayersCards;

    @ManyToOne(cascade = CascadeType.ALL) //wiele graczy może mieć jedną pozycję?
    private Position positionId;
    private Integer healthCardId;
    private Integer teamId;
    private Integer countryId;

}
