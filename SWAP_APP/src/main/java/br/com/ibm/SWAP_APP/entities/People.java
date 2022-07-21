package br.com.ibm.SWAP_APP.entities;

//import entities.peopleUtilities.Gender;
import br.com.ibm.SWAP_APP.entities.peopleUtilities.BirthYear;
import br.com.ibm.SWAP_APP.entities.peopleUtilities.Gender;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Getter
@Setter

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="PEOPLE")
@Entity

public class People {


    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPeople;

    @Column(name="NAME")
    @Basic
    private String namePeople;

    @Column(name="HEIGHT")
    private Float heightPeople;

    @Column(name="MASS")
    private Float massPeople;

    @Column(name="CREATED")
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private Date CreatedPeople = Date.from(Instant.now());

    @Column(name="EDITED")
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private Date EditedPeople = Date.from(Instant.now());

    @ManyToOne
    @JoinColumn(name= "GENDER_ID")
    private Gender gender;

    @ManyToMany
    @JoinTable(name="hair_color", joinColumns = @JoinColumn(name="people_id"), inverseJoinColumns = @JoinColumn(name="color_id"))
    private List<Color> hairColor;

    @ManyToMany
    @JoinTable(name="eye_color", joinColumns = @JoinColumn(name="people_id"), inverseJoinColumns = @JoinColumn(name="color_id"))
    private List<Color> eyeColor;

    @ManyToMany
    @JoinTable(name="skin_color", joinColumns = @JoinColumn(name="people_id"), inverseJoinColumns = @JoinColumn(name="color_id"))
    private List<Color> skinColor;

    @OneToOne
    @JoinColumn(name="BIRTH_YEAR_ID")
    private BirthYear birthYear;

}
