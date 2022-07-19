package br.com.ibm.SWAP_APP.controllers;

import br.com.ibm.SWAP_APP.entities.DTOS.PeopleDTO;
import br.com.ibm.SWAP_APP.entities.People;
import br.com.ibm.SWAP_APP.entities.peopleUtilities.Gender;
import br.com.ibm.SWAP_APP.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    PeopleService peopleService;


    @GetMapping()
    @ResponseBody
    public List<People> findAllPeople(){
        return peopleService.findAllPeople();
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
    public Optional<People> postNewUser(@RequestBody People desgraca){
        desgraca.setCreatedPeople(new Date());
        desgraca.setEditedPeople(new Date());
        peopleService.saveNewUser(desgraca);
        return Optional.of(desgraca);
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

//    @GetMapping("/{id}")
//    public ResponseEntity<People> getPeopleById(@PathVariable Integer id){
//        Optional<People> user = peopleService.findById(id);
//
//        if(user.isPresent()){
//            return ResponseEntity.ok(user.get());
//        }else{
//            return ResponseEntity.notFound().build();
//        }
//    }
}
