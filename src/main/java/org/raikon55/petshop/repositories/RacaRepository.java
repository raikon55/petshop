package org.raikon55.petshop.repositories;

import org.raikon55.petshop.domain.Raca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RacaRepository extends JpaRepository<Raca, Integer> {

}
