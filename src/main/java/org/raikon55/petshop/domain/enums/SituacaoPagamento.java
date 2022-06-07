package org.raikon55.petshop.domain.enums;

import java.util.Objects;

public enum SituacaoPagamento {

    QUITADO(1, "Quitado"),
    CANCELADO(2, "Cancelado"),
    PENDENTE(3, "Pendente");

    private int cod;

    private String descricao;

    private SituacaoPagamento(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public static SituacaoPagamento toEnum(Integer cod) {
        if (Objects.nonNull(cod)) {
            for (SituacaoPagamento situacao : SituacaoPagamento.values()) {
                if (cod.equals(situacao.getCod())) {
                    return situacao;
                }
            }
        }
        return null;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
