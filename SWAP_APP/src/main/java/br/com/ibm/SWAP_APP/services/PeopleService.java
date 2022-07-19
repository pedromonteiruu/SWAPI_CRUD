package br.com.ibm.SWAP_APP.services;

import br.com.ibm.SWAP_APP.entities.People;
//import br.com.ibm.SWAP_APP.repositories.GenderRepository;
import br.com.ibm.SWAP_APP.entities.peopleUtilities.Gender;
import br.com.ibm.SWAP_APP.repositories.GenderRepository;
import br.com.ibm.SWAP_APP.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    @Autowired
    PeopleRepository peopleRepository;

    @Autowired
    GenderRepository genderRepository;

//    @Autowired
//    GenderRepository genderRepository;

    public List<People> findAllPeople(){
        return peopleRepository.findAll();
    }

    public Optional<People> findById(Integer id){
        return peopleRepository.findById(id);
    }

    public People saveNewUser(People people){return peopleRepository.save(people);}

    public Gender saveNewGender(Gender gender){return genderRepository.save(gender);}

    public List<Gender> findAllGender(){
        return genderRepository.findAll();
    }
}

