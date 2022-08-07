package org.raikon55.petshop.domain;

import javax.persistence.Entity;

import org.raikon55.petshop.domain.enums.SituacaoPagamento;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)

@Entity
public class PagCartao extends Pagamento {

    private static final long serialVersionUID = -1143211403604898892L;

    private Integer parcelas;

    public PagCartao(Integer id, Double valor, SituacaoPagamento situacao, Servico servico, Integer parcelas) {
        super(id, valor, situacao, servico);
        this.parcelas = parcelas;
    }
}
