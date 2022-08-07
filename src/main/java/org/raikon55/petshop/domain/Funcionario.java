package org.raikon55.petshop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true, exclude = { "servicos" })
@EqualsAndHashCode(callSuper = true, exclude = { "servicos" })

@Entity
public class Funcionario extends Pessoa {

    private static final long serialVersionUID = 5104413135978670994L;

    private String funcao;

    @JsonIgnore
    @OneToMany(mappedBy = "funcionario")
    private List<Servico> servicos = new ArrayList<>();

    public Funcionario(Integer id, String nome, String email, String codNacional, String funcao) {
        super(id, nome, email, codNacional);
        this.funcao = funcao;
    }
}
