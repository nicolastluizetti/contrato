package com.contratos.demo.Enums;

public enum ContratoStatus {
    ATIVO("Contrato em andamento"),
    FINALIZADO("Contrato concluído"),
    CANCELADO("Contrato cancelado");

    private final String descricao;

    ContratoStatus(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }


}
