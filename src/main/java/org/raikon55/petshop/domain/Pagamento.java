package org.raikon55.petshop.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import org.raikon55.petshop.domain.enums.SituacaoPagamento;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento implements Serializable {

    private static final long serialVersionUID = 4098535502352253812L;

    @Id
    private Integer id;
    private Double valor;
    private Integer situacao;

    @JsonIgnore
    @MapsId
    @OneToOne
    @JoinColumn(name = "id_servico")
    private Servico servico;

    public Pagamento(Integer id, Double valor, SituacaoPagamento situacao, Servico servico) {
        this.id = id;
        this.valor = valor;
        this.situacao = situacao.getCod();
        this.servico = servico;
    }
}
