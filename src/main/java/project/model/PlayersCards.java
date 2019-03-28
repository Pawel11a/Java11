package project.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name ="players_cards")
public class PlayersCards {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "players_id")
    private Player player;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id")
    private Card card;

//    @ManyToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "doctor_id")
//    private Doctor doctor;
}
