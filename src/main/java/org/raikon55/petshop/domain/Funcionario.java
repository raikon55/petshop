package org.raikon55.petshop.domain;

import javax.persistence.Entity;

@Entity
public class Funcionario extends Pessoa {

    private static final long serialVersionUID = 5104413135978670994L;

    private String funcao;

    public Funcionario() {
    }

    public Funcionario(Integer id, String nome, String email, String codNacional, String funcao) {
        super(id, nome, email, codNacional);
        this.funcao = funcao;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}