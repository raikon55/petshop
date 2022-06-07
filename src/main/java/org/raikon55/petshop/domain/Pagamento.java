package org.raikon55.petshop.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import org.raikon55.petshop.domain.enums.SituacaoPagamento;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pagamento implements Serializable {

    private static final long serialVersionUID = 4098535502352253812L;

    @Id
    private Integer id;
    private Double valor;
    private SituacaoPagamento situacao;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id_servico")
    private Servico servico;

    public Pagamento() {
    }

    public Pagamento(Integer id, Double valor, SituacaoPagamento situacao, Servico servico) {
        this.id = id;
        this.valor = valor;
        this.situacao = situacao;
        this.servico = servico;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public SituacaoPagamento getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoPagamento situacao) {
        this.situacao = situacao;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pagamento other = (Pagamento) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
