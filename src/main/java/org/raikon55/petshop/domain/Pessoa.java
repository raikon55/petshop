package org.raikon55.petshop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = { "enderecos", "telefones" })
@EqualsAndHashCode(exclude = { "enderecos", "telefones" })

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa implements Serializable {

    private static final long serialVersionUID = -7232725169783407081L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String codNacional;

    @OneToMany(mappedBy = "pessoa")
    private List<Endereco> enderecos = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "TELEFONE", joinColumns = @JoinColumn(name = "id_pessoa"))
    private Set<String> telefones = new HashSet<>();

    public Pessoa(Integer id, String nome, String email, String codNacional) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.codNacional = codNacional;
    }

}
