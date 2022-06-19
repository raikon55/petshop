package org.raikon55.petshop.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.raikon55.petshop.domain.Categoria;
import org.raikon55.petshop.domain.Cidade;
import org.raikon55.petshop.domain.Cliente;
import org.raikon55.petshop.domain.Endereco;
import org.raikon55.petshop.domain.Especie;
import org.raikon55.petshop.domain.Estado;
import org.raikon55.petshop.domain.Funcionario;
import org.raikon55.petshop.domain.PagCartao;
import org.raikon55.petshop.domain.PagDinheiro;
import org.raikon55.petshop.domain.Pagamento;
import org.raikon55.petshop.domain.Pet;
import org.raikon55.petshop.domain.Produto;
import org.raikon55.petshop.domain.Raca;
import org.raikon55.petshop.domain.Servico;
import org.raikon55.petshop.domain.enums.SituacaoPagamento;
import org.raikon55.petshop.repositories.CategoriaRepository;
import org.raikon55.petshop.repositories.CidadeRepository;
import org.raikon55.petshop.repositories.EnderecoRepository;
import org.raikon55.petshop.repositories.EspecieRepository;
import org.raikon55.petshop.repositories.EstadoRepository;
import org.raikon55.petshop.repositories.PagamentoRepository;
import org.raikon55.petshop.repositories.PessoaRepository;
import org.raikon55.petshop.repositories.PetRepository;
import org.raikon55.petshop.repositories.ProdutoRepository;
import org.raikon55.petshop.repositories.RacaRepository;
import org.raikon55.petshop.repositories.ServicoRepository;
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

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @PostConstruct
    public void cadastrar() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

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

        Cliente clt1 = new Cliente(null, "Jose Maria", "jose@mail.com", "335.194.320-21", "FISICA");

        Funcionario fnc1 = new Funcionario(null, "Maria Jose", "maria@mail.com", "551.872.200.12", "ATENDENTE");

        Endereco end1 = new Endereco(null, "Rua Tupis", "500", "Apto 101", "Pindorama", "30111222", clt1, cid1);
        Endereco end2 = new Endereco(null, "Av. Tamoios", "100", "Casa", "Oca", "3968000", fnc1, cid2);
        Endereco end3 = new Endereco(null, "Rua Aranãs", "10", "Apto 201", "Centro", "01153000", fnc1, cid3);

        Servico srv1 = new Servico(null, sdf.parse("02/09/2021 09:00"), sdf.parse("02/09/2021 12:00"), "Tosa", clt1,
                fnc1);
        Servico srv2 = new Servico(null, sdf.parse("03/09/2021 12:00"), sdf.parse("04/09/2021 12:00"), "Hotel", clt1,
                fnc1);

        Pagamento pgt1 = new PagCartao(null, 60.0, SituacaoPagamento.QUITADO, srv2, 6);
        Pagamento pgt2 = new PagDinheiro(null, 100.0, SituacaoPagamento.PENDENTE, srv1, sdf.parse("02/09/2021 00:00"),
                null);

        est1.getCidades().addAll(Arrays.asList(cid1, cid2));
        est2.getCidades().addAll(Arrays.asList(cid3));

        cat1.getProdutos().addAll(Arrays.asList(p1, p2));
        cat2.getProdutos().addAll(Arrays.asList(p3, p4));
        cat3.getProdutos().addAll(Arrays.asList(p4));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1));
        p3.getCategorias().addAll(Arrays.asList(cat2));
        p4.getCategorias().addAll(Arrays.asList(cat2, cat3));

        srv1.setPagamento(pgt2);
        srv2.setPagamento(pgt1);

        clt1.getTelefones().addAll(Arrays.asList("3516-2000", "9191-0000"));
        clt1.getServicos().addAll(Arrays.asList(srv1, srv2));

        fnc1.getTelefones().addAll(Arrays.asList("3279-0001", "9090-0002"));
        fnc1.getServicos().addAll(Arrays.asList(srv1, srv2));

        this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        this.produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
        this.especieRepository.saveAll(Arrays.asList(esp1, esp2));
        this.racaRepository.saveAll(Arrays.asList(rac1, rac2, rac3));
        this.petRepository.saveAll(Arrays.asList(pet1, pet2, pet3));
        this.estadoRepository.saveAll(Arrays.asList(est1, est2));
        this.cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
        this.pessoaRepository.saveAll(Arrays.asList(clt1, fnc1));
        this.enderecoRepository.saveAll(Arrays.asList(end1, end2, end3));
        this.servicoRepository.saveAll(Arrays.asList(srv1, srv2));
        this.pagamentoRepository.saveAll(Arrays.asList(pgt1, pgt2));
    }

}
