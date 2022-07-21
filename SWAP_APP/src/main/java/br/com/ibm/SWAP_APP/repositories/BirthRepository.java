package br.com.ibm.SWAP_APP.repositories;

import br.com.ibm.SWAP_APP.entities.peopleUtilities.BirthYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirthRepository extends JpaRepository<BirthYear, Integer> {
}
