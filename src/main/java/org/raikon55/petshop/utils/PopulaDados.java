package org.raikon55.petshop.utils;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.raikon55.petshop.domain.Categoria;
import org.raikon55.petshop.domain.Cidade;
import org.raikon55.petshop.domain.Especie;
import org.raikon55.petshop.domain.Estado;
import org.raikon55.petshop.domain.Pet;
import org.raikon55.petshop.domain.Produto;
import org.raikon55.petshop.domain.Raca;
import org.raikon55.petshop.repositories.CategoriaRepository;
import org.raikon55.petshop.repositories.CidadeRepository;
import org.raikon55.petshop.repositories.EspecieRepository;
import org.raikon55.petshop.repositories.EstadoRepository;
import org.raikon55.petshop.repositories.PetRepository;
import org.raikon55.petshop.repositories.ProdutoRepository;
import org.raikon55.petshop.repositories.RacaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PopulaDados {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EspecieRepository especieRepository;

    @Autowired
    private RacaRepository racaRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @PostConstruct
    public void cadastrar() {
        Categoria cat1 = new Categoria(null, "Alimento");
        Categoria cat2 = new Categoria(null, "Remédio");
        Categoria cat3 = new Categoria(null, "Cosmético");

        Produto p1 = new Produto(null, "Ração", 100.0);
        Produto p2 = new Produto(null, "Sache", 80.0);
        Produto p3 = new Produto(null, "Vermifugo", 20.0);
        Produto p4 = new Produto(null, "Shampoo", 50.0);

        Especie esp1 = new Especie(null, "Cachorro");
        Especie esp2 = new Especie(null, "Gato");

        Raca rac1 = new Raca(null, "Shitzu");
        Raca rac2 = new Raca(null, "Akita");
        Raca rac3 = new Raca(null, "Persa");

        Pet pet1 = new Pet(null, "John", 6, esp1, rac1);
        Pet pet2 = new Pet(null, "Hana", 5, esp1, rac2);
        Pet pet3 = new Pet(null, "Mewth", 0, esp2, rac3);

        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "São Paulo");

        Cidade cid1 = new Cidade(null, "Belo Horizonte", est1);
        Cidade cid2 = new Cidade(null, "Capelinha", est1);
        Cidade cid3 = new Cidade(null, "São Paulo", est2);

        est1.getCidades().addAll(Arrays.asList(cid1, cid2));
        est2.getCidades().addAll(Arrays.asList(cid3));

        cat1.getProdutos().addAll(Arrays.asList(p1, p2));
        cat2.getProdutos().addAll(Arrays.asList(p3, p4));
        cat3.getProdutos().addAll(Arrays.asList(p4));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1));
        p3.getCategorias().addAll(Arrays.asList(cat2));
        p4.getCategorias().addAll(Arrays.asList(cat2, cat3));

        this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        this.produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
        this.especieRepository.saveAll(Arrays.asList(esp1, esp2));
        this.racaRepository.saveAll(Arrays.asList(rac1, rac2, rac3));
        this.petRepository.saveAll(Arrays.asList(pet1, pet2, pet3));
        this.estadoRepository.saveAll(Arrays.asList(est1, est2));
        this.cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
    }

}
