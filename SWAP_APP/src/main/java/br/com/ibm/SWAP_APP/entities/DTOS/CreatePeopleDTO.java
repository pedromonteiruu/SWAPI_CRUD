package br.com.ibm.SWAP_APP.entities.DTOS;


import br.com.ibm.SWAP_APP.entities.People;
import br.com.ibm.SWAP_APP.entities.peopleUtilities.BirthYear;
import br.com.ibm.SWAP_APP.entities.peopleUtilities.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePeopleDTO {
    private String peopleName;
    private Float peopleHeight;
    private Float peopleMass;
    private Integer gender;
    private Integer birthYear;

    public People peopleDtoToPeople(CreatePeopleDTO peopleDTO){
        People people = new People();
        people.setNamePeople(peopleDTO.getPeopleName());
        people.setMassPeople(peopleDTO.getPeopleMass());
        people.setHeightPeople(peopleDTO.getPeopleHeight());
        return people;
    }
}
