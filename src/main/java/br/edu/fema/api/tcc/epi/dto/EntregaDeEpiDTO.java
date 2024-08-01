package br.edu.fema.api.tcc.epi.dto;

import jakarta.validation.constraints.NotNull;

public class EntregaDeEpiDTO {
    @NotNull
    private Long codigoEpi;
    private int qtdEstoque;

    public EntregaDeEpiDTO(Long codigoEpi, int qtdEstoque) {
        this.codigoEpi = codigoEpi;
        this.qtdEstoque = qtdEstoque;
    }

    public Long getCodigoEpi() {
        return codigoEpi;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
}
