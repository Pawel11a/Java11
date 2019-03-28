package project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Integer id;

    private String name;
    private String capital;

    @OneToMany(mappedBy = "country")
    private Set<Manager> manager;

    @OneToMany(mappedBy = "country")
    private Set<Company> company;

    @OneToMany(mappedBy = "country")
    private Set<Stadium> stadiums;

    @OneToMany(mappedBy = "country")
    private Set<Team> teams;

    @OneToMany(mappedBy = "country")
    private Set<Player> players;


}
