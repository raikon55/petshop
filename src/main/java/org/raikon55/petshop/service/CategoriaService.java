package org.raikon55.petshop.service;

import java.util.Optional;

import org.raikon55.petshop.domain.Categoria;
import org.raikon55.petshop.repositories.CategoriaRepository;
import org.raikon55.petshop.service.exceptions.DataIntegrityException;
import org.raikon55.petshop.service.exceptions.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria find(Integer id) {
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjetoNaoEncontradoException(""));
    }

    public Categoria insert(Categoria obj) {
        obj.setId(null);
        return this.repository.save(obj);
    }

    public Categoria update(Categoria obj) {
        this.find(obj.getId());
        return this.repository.save(obj);
    }

    public void delete(Integer id) {
        this.find(id);
        try {
            this.repository.deleteById(id);
        } catch (DataIntegrityViolationException exc) {
            throw new DataIntegrityException("Categoria possui produtos, não é possível deletar!");
        }
    }
}
