package org.raikon55.petshop.service;

import java.util.Optional;

import org.raikon55.petshop.domain.Categoria;
import org.raikon55.petshop.repositories.CategoriaRepository;
import org.raikon55.petshop.service.exceptions.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria find(Integer id) {
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjetoNaoEncontradoException(""));
    }
}
