package org.raikon55.petshop.repositories;

import org.raikon55.petshop.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
