package org.raikon55.petshop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = { "pets" })
@EqualsAndHashCode(exclude = { "pets" })

@Entity
public class Raca implements Serializable {

    private static final long serialVersionUID = 4422419100696828333L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;

    @OneToMany(mappedBy = "raca")
    private List<Pet> pets = new ArrayList<>();

    public Raca(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
}
