package br.com.ibm.SWAP_APP.entities.DTOS;

import br.com.ibm.SWAP_APP.entities.Color;
import br.com.ibm.SWAP_APP.entities.People;
import br.com.ibm.SWAP_APP.entities.peopleUtilities.BirthYear;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

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
    private String hairColor;

    private String skinColor;
    private String eyeColor;
    private String birthYear;




    public PeopleDTO(People people){
        this.peopleName = people.getNamePeople();
        this.peopleHeight = people.getHeightPeople();
        this.peopleMass = people.getMassPeople();
        this.peopleId = people.getIdPeople();
        this.created = people.getCreatedPeople();
        this.updated = people.getEditedPeople();
//        this.peopleGender = people.getGender().getNameGender();

//        this.hairColor = people.getHairColor().get(0).getName();
        if(people.getHairColor() != null){
            StringBuffer colorsHair = new StringBuffer();
            String var = ", ";
            for(int i=0;i <people.getHairColor().size();i++){
                if(i+1 == people.getHairColor().size()) var = " ";
                if(people.getHairColor() != null) colorsHair.append(people.getHairColor().get(i).getName()+ var);
            }
            this.hairColor = colorsHair.toString();
        }else{this.hairColor = "unknow";}

        if(people.getEyeColor() != null){
            StringBuffer colorsEyes = new StringBuffer();
            String var = ", ";
            for(int i=0;i <people.getEyeColor().size();i++){
                if(i+1 == people.getEyeColor().size()) var = " ";
                if(people.getEyeColor() != null) colorsEyes.append(people.getEyeColor().get(i).getName()+ var);
            }
            this.eyeColor = colorsEyes.toString();
        }else{this.eyeColor = "unknow";}

        if(people.getSkinColor() != null){
            StringBuffer colorSkin = new StringBuffer();
            String var = ", ";
            for(int i=0;i <people.getSkinColor().size();i++){
                if(i+1 == people.getSkinColor().size()) var = " ";
                if(people.getSkinColor() != null) colorSkin.append(people.getSkinColor().get(i).getName()+ var);
            }
            this.skinColor = colorSkin.toString();
        }else{this.skinColor = "unknow";}

        this.peopleGender = people.getGender().getNameGender();

        this.birthYear = people.getBirthYear().getYearBirth()+"-"+ people.getBirthYear().getAgeBirth();
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

    public static Page<PeopleDTO> pageToPeopleDTO(Page<People> people){
        return people.map(PeopleDTO::new);
        //Converte uma pagina de People pra uma pagina de People DTO
    }
}
