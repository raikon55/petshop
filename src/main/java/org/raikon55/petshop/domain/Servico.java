package org.raikon55.petshop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = { "produtos" })
@EqualsAndHashCode(exclude = { "produtos" })

@Entity
public class Servico implements Serializable {

    private static final long serialVersionUID = 2285256622496244197L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date dataEntrada;
    private Date dataSaida;
    private String descricao;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "servico")
    private Pagamento pagamento;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_pet")
    private Pet pet;

    @ManyToMany
    @JoinTable(name = "SERVICO_PRODUTO", joinColumns = @JoinColumn(name = "id_servico"), inverseJoinColumns = @JoinColumn(name = "id_produto"))
    private List<Produto> produtos = new ArrayList<>();

    public Servico(Integer id, Date dataEntrada, Date dataSaida, String descricao, Cliente cliente,
            Funcionario funcionario, Pet pet) {
        this.id = id;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.descricao = descricao;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.pet = pet;
    }
}
