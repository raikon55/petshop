package org.raikon55.petshop.repositories;

import org.raikon55.petshop.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
    
}
