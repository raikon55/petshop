package org.raikon55.petshop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = { "servicos" })
@EqualsAndHashCode(exclude = { "servicos" })

@Entity
public class Pet implements Serializable {

    private static final long serialVersionUID = -6093053040663539626L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Integer idade;

    @ManyToOne
    @JoinColumn(name = "id_especie")
    private Especie especie;

    @ManyToOne
    @JoinColumn(name = "id_raca")
    private Raca raca;

    @OneToMany(mappedBy = "pet")
    private List<Servico> servicos = new ArrayList<>();

    public Pet(Integer id, String nome, Integer idade, Especie especie, Raca raca) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.especie = especie;
        this.raca = raca;
    }
}
