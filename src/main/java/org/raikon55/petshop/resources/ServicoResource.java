package org.raikon55.petshop.resources;

import org.raikon55.petshop.domain.Servico;
import org.raikon55.petshop.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/servicos")
public class ServicoResource {

    @Autowired
    private ServicoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Servico> find(@PathVariable(value = "id") Integer id) {
        Servico obj = this.service.find(id);
        return ResponseEntity.ok().body(obj);
    }
}
