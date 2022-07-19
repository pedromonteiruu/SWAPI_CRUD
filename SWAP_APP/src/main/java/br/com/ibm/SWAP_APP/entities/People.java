package br.com.ibm.SWAP_APP.entities;

//import entities.peopleUtilities.Gender;
import br.com.ibm.SWAP_APP.entities.peopleUtilities.Gender;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDate;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
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
//    @JsonManagedReference
    @JoinColumn(name= "GENDER_ID")
    private Gender gender;


    @ManyToMany
    @JsonManagedReference
    @JoinTable(name="hair_color", joinColumns = @JoinColumn(name="people_id"), inverseJoinColumns = @JoinColumn(name="color_id"))
    private List<Color> hairColor;

    @ManyToMany
    @JsonManagedReference
    @JoinTable(name="eye_color", joinColumns = @JoinColumn(name="people_id"), inverseJoinColumns = @JoinColumn(name="color_id"))
    private List<Color> eyeColor;

    @ManyToMany
    @JsonManagedReference
    @JoinTable(name="skin_color", joinColumns = @JoinColumn(name="people_id"), inverseJoinColumns = @JoinColumn(name="color_id"))
    private List<Color> skinColor;

//    @OneToOne
//    @JoinColumn(name="BIRTH_YEAR_ID", referencedColumnName = "ID")
//    private BirthYear birthYear;

//    @OneToOne(mappedBy = "people")
//    @JoinColumn(referencedColumnName = "id")
//    @JsonManagedReference
//    private BirthYear BirthAge;


    public People(String name, Float height, Float mass){
        this.namePeople = name;
        this.heightPeople = height;
        this.massPeople = mass;
    }
}
