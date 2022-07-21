package br.com.ibm.SWAP_APP.services;

import br.com.ibm.SWAP_APP.entities.People;
//import br.com.ibm.SWAP_APP.repositories.GenderRepository;
import br.com.ibm.SWAP_APP.entities.peopleUtilities.BirthYear;
import br.com.ibm.SWAP_APP.entities.peopleUtilities.Gender;
import br.com.ibm.SWAP_APP.repositories.BirthRepository;
import br.com.ibm.SWAP_APP.repositories.GenderRepository;
import br.com.ibm.SWAP_APP.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    @Autowired
    PeopleRepository peopleRepository;

    @Autowired
    GenderRepository genderRepository;

    @Autowired
    BirthRepository birthRepository;

//    @Autowired
//    GenderRepository genderRepository;

    public Page<People> findAllPeople(Pageable pageable){
        return peopleRepository.findAll(pageable);
    }
    //passa como o findAll vai pegar os dados

    public Optional<People> findById(Integer id){
        return peopleRepository.findById(id);
    }

    public People saveNewUser(People people){return peopleRepository.save(people);}

    public Gender saveNewGender(Gender gender){return genderRepository.save(gender);}

    public List<Gender> findAllGender(){
        return genderRepository.findAll();
    }

    public Optional<Gender> findByIdGender(Integer id){
        return genderRepository.findById(id);
    }
    public List<BirthYear> findAllBirth(){
        return birthRepository.findAll();
    }

    public Optional<BirthYear> findByIdBirth(Integer id){
        return birthRepository.findById(id);
    }
    public BirthYear postBirth(BirthYear birthYear){
        return birthRepository.save(birthYear);
    }
}

