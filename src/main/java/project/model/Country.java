package project.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String capital;

    @OneToMany(mappedBy = "country")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Manager> managers;

    @OneToMany(mappedBy = "country")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Company> companies;

    @OneToMany(mappedBy = "country")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Stadium> stadiums;

    @OneToMany(mappedBy = "country")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Team> teams;

    @OneToMany(mappedBy = "country")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Player> players;


}
