package br.com.ibm.SWAP_APP.controllers;

import br.com.ibm.SWAP_APP.entities.DTOS.CreatePeopleDTO;
import br.com.ibm.SWAP_APP.entities.DTOS.PeopleDTO;
import br.com.ibm.SWAP_APP.entities.People;
import br.com.ibm.SWAP_APP.entities.peopleUtilities.BirthYear;
import br.com.ibm.SWAP_APP.entities.peopleUtilities.Gender;
import br.com.ibm.SWAP_APP.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    PeopleService peopleService;


    @GetMapping()
    @ResponseBody
    public Page<PeopleDTO> findAllPeople(
            @PageableDefault(
                    sort = "idPeople",
                    direction = Direction.ASC,
                    page = 0,
                    size = 2
            )Pageable pageable){
        Page<People> people = peopleService.findAllPeople(pageable);
        return PeopleDTO.pageToPeopleDTO(people);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<PeopleDTO> getPeopleById(@PathVariable Integer id){
        Optional<People> user = peopleService.findById(id);

        if(user.isPresent()){
            return ResponseEntity.ok(new PeopleDTO(user.get()));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<PeopleDTO> postNewUser(@RequestBody CreatePeopleDTO odio){
        People people = odio.peopleDtoToPeople(odio);
        Optional<Gender> genero = peopleService.findByIdGender(odio.getGender());
        Optional<BirthYear> birthYear = peopleService.findByIdBirth(odio.getBirthYear());
        if(genero.isPresent() && birthYear.isPresent()){
            people.setGender(genero.get());
            people.setBirthYear(birthYear.get());
            peopleService.saveNewUser(people);
            return ResponseEntity.ok(new PeopleDTO(people));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/gender")
    @ResponseBody
    public ResponseEntity<?> postNewUser(@RequestBody Gender gender){
        peopleService.saveNewGender(gender);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/gender")
    @ResponseBody
    public List<Gender> findAllGender(){
        return peopleService.findAllGender();
    }

    @GetMapping("/birthyear")
    @ResponseBody
    public List<BirthYear> findAllBirth(){
        return peopleService.findAllBirth();
    }

    @PostMapping("/birthyear")
    public ResponseEntity<BirthYear> createBirthYear(
            @RequestBody BirthYear birthYear
    ) {
        BirthYear createdBirthYear = peopleService.postBirth(birthYear);

        return ResponseEntity.ok().build();
    }


}
