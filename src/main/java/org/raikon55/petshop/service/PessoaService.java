package org.raikon55.petshop.service;

import java.util.Optional;

import org.raikon55.petshop.domain.Pessoa;
import org.raikon55.petshop.repositories.PessoaRepository;
import org.raikon55.petshop.service.exceptions.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public Pessoa find(Integer id) {
        Optional<Pessoa> obj = this.repository.findById(id);
        return obj.orElseThrow(() -> new ObjetoNaoEncontradoException(""));
    }
}
