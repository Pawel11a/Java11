package project.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name ="players_cards")
public class PlayerCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "players_id")
    private Player player;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "card_id")
    private Card card;

//    @ManyToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "doctor_id")
//    private Doctor doctor;
}
