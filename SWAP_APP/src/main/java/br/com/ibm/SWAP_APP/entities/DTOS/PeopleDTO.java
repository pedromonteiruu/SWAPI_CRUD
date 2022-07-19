package br.com.ibm.SWAP_APP.entities.DTOS;

import br.com.ibm.SWAP_APP.entities.Color;
import br.com.ibm.SWAP_APP.entities.People;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeopleDTO {
    private Integer peopleId;
    private String peopleName;
    private Float peopleHeight;
    private float peopleMass;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date created;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date updated;
    private String peopleGender;
    private List<Color> hairColor;
    public PeopleDTO(People people){
        this.peopleName = people.getNamePeople();
        this.peopleHeight = people.getHeightPeople();
        this.peopleMass = people.getMassPeople();
        this.peopleId = people.getIdPeople();
        this.created = people.getCreatedPeople();
        this.updated = people.getEditedPeople();
        this.peopleGender = people.getGender().getNameGender();
        this.hairColor = people.getHairColor();
    }

    public static PeopleDTO newPeopleDTO(People people) {
        PeopleDTO peopleUtilities = new PeopleDTO();
        peopleUtilities.setPeopleId(people.getIdPeople());
        peopleUtilities.setPeopleName(people.getNamePeople());
        peopleUtilities.setPeopleHeight(people.getHeightPeople());
        peopleUtilities.setPeopleMass(people.getMassPeople());
        peopleUtilities.setCreated(people.getCreatedPeople());
        peopleUtilities.setUpdated(people.getEditedPeople());

        return peopleUtilities;
    }
}
