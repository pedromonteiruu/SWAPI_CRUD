package br.com.ibm.SWAP_APP.entities.peopleUtilities;

import br.com.ibm.SWAP_APP.entities.People;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="GENDER")
@Entity
public class Gender {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGender;

    @Column(name="NAME")
    private String nameGender;

    @OneToMany
    @JsonBackReference
    @JoinColumn(name="GENDER_ID")
    private List<People> people = new ArrayList<>();


}
