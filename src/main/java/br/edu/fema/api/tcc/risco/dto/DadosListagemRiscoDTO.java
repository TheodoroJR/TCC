package br.edu.fema.api.tcc.risco.dto;

import br.edu.fema.api.tcc.risco.model.RiscoModel;

public class DadosListagemRiscoDTO {

    private Long codigoRisco;
    private String nomeRisco;
    private String descricaoRisco;
    private Boolean ativo;

    public DadosListagemRiscoDTO(RiscoModel risco) {
        this.codigoRisco = risco.getCodigoRisco();
        this.nomeRisco = risco.getNomeRisco();
        this.descricaoRisco = risco.getDescricaoRisco();
        this.ativo = risco.getAtivo();
    }

    public Long getCodigoRisco() {
        return codigoRisco;
    }

    public String getNomeRisco() {
        return nomeRisco;
    }

    public String getDescricaoRisco() {
        return descricaoRisco;
    }

    public Boolean getAtivo() {
        return ativo;
    }
}
