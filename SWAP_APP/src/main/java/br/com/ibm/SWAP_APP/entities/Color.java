package br.com.ibm.SWAP_APP.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="COLOR")
@Entity
public class Color {

    @Id
    @Column(name="ID")
    private Integer Id;

    @Column(name="NAME")
    private String Name;

//    @ManyToMany(mappedBy = "hairColor")
//    @JsonBackReference
//    List<People> peopleHair;
//
//    @ManyToMany(mappedBy = "eyeColor")
//    @JsonBackReference
//    List<People> peopleEye;
//
//    @ManyToMany(mappedBy = "skinColor")
//    @JsonBackReference
//    List<People> peopleSkin;
}
