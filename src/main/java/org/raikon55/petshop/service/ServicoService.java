package org.raikon55.petshop.service;

import java.util.List;
import java.util.Optional;

import org.raikon55.petshop.domain.Servico;
import org.raikon55.petshop.repositories.ServicoRepository;
import org.raikon55.petshop.service.exceptions.DataIntegrityException;
import org.raikon55.petshop.service.exceptions.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repository;

    public Servico find(Integer id) {
        Optional<Servico> obj = this.repository.findById(id);
        return obj.orElseThrow(() -> new ObjetoNaoEncontradoException(""));
    }

    public Servico insert(Servico obj) {
        obj.setId(null);
        return this.repository.save(obj);
    }

    public Servico update(Servico obj) {
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

    public List<Servico> findAll() {
        return this.repository.findAll();
    }
}
