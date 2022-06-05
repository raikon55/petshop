package org.raikon55.petshop.resources;

import org.raikon55.petshop.domain.Categoria;
import org.raikon55.petshop.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> find(@PathVariable(value = "id") Integer id) {
        Categoria obj = this.service.find(id);
        return ResponseEntity.ok().body(obj);
    }
}
