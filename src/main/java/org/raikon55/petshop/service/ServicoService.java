package org.raikon55.petshop.service;

import java.util.Optional;

import org.raikon55.petshop.domain.Servico;
import org.raikon55.petshop.repositories.ServicoRepository;
import org.raikon55.petshop.service.exceptions.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repository;

    public Servico find(Integer id) {
        Optional<Servico> obj = this.repository.findById(id);
        return obj.orElseThrow(() -> new ObjetoNaoEncontradoException(""));
    }
}
