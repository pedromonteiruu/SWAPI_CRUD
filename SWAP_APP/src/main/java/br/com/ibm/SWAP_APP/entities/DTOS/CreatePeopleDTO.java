package br.com.ibm.SWAP_APP.entities.DTOS;


import br.com.ibm.SWAP_APP.entities.People;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePeopleDTO {
    private String peopleName;
    private Float peopleHeight;
    private float peopleMass;

    public People peopleDtoToPeople(CreatePeopleDTO peopleDTO){
        return new People(
                peopleDTO.getPeopleName(),
                peopleDTO.getPeopleHeight(),
                peopleDTO.getPeopleHeight()
        );
    }
}
