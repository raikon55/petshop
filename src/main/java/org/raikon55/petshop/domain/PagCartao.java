package org.raikon55.petshop.domain;

import javax.persistence.Entity;

import org.raikon55.petshop.domain.enums.SituacaoPagamento;

@Entity
public class PagCartao extends Pagamento {

    private static final long serialVersionUID = -1143211403604898892L;

    private Integer parcelas;

    public PagCartao() {

    }

    public PagCartao(Integer id, Double valor, SituacaoPagamento situacao, Servico servico, Integer parcelas) {
        super(id, valor, situacao, servico);
        this.parcelas = parcelas;
    }

    public Integer getParcelas() {
        return parcelas;
    }

    public void setParcelas(Integer parcelas) {
        this.parcelas = parcelas;
    }
}
