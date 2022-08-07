package org.raikon55.petshop.domain;

import java.util.Date;

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
public class PagDinheiro extends Pagamento {

    private static final long serialVersionUID = -8569449730281946675L;

    private Date dataVencimento;
    private Double desconto;

    public PagDinheiro(Integer id, Double valor, SituacaoPagamento situacao, Servico servico, Date dataVencimento,
            Double desconto) {
        super(id, valor, situacao, servico);
        this.dataVencimento = dataVencimento;
        this.desconto = desconto;
    }
}
