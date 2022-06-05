package org.raikon55.petshop.utils;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.raikon55.petshop.domain.Categoria;
import org.raikon55.petshop.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PopulaDados {

    @Autowired
    private CategoriaRepository repository;

    @PostConstruct
    public void cadastrar() {
        Categoria cat1 = new Categoria(null, "Alimento");
        Categoria cat2 = new Categoria(null, "Cosmético");
        Categoria cat3 = new Categoria(null, "Remédio");

        this.repository.saveAll(Arrays.asList(cat1, cat2, cat3));
    }

}
