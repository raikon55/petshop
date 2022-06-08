package org.raikon55.petshop.resources;

import org.raikon55.petshop.domain.Pessoa;
import org.raikon55.petshop.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

    @Autowired
    private PessoaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pessoa> find(@PathVariable(value = "id") Integer id) {
        Pessoa obj = this.service.find(id);
        return ResponseEntity.ok().body(obj);
    }
}
