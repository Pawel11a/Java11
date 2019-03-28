package project.model;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Injuries {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String injury;


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