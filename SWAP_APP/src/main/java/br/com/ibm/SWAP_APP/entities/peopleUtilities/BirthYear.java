package br.com.ibm.SWAP_APP.entities.peopleUtilities;

import br.com.ibm.SWAP_APP.entities.People;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.Year;
import java.util.List;

@Getter
@Setter

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="BIRTH_YEAR")
@Entity
public class BirthYear {

    @Id
    @Column(name="ID")
    private Integer ID;

    @Column(name="AGE")
    private String ageBirth;

    @Column(name="YEAR")
    private Year YearBirth;

    @OneToOne
    @JsonBackReference
    private People people;

}
