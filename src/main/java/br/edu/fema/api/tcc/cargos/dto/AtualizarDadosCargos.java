package br.edu.fema.api.tcc.cargos.dto;

import br.edu.fema.api.tcc.risco.model.RiscoModel;

import java.util.List;

public class AtualizarDadosCargos {

    private Long codigoCargo;
    private String nomeCargo;
    private List<RiscoModel> riscosCargos;
    private Boolean ativo;

    public AtualizarDadosCargos(Long codigoCargo, String nomeCargo, List<RiscoModel> riscosCargos, Boolean ativo) {
        this.codigoCargo = codigoCargo;
        this.nomeCargo = nomeCargo;
        this.riscosCargos = riscosCargos;
        this.ativo = ativo;
    }

    public Long getCodigoCargo() {
        return codigoCargo;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public List<RiscoModel> getRiscosCargos() {
        return riscosCargos;
    }

    public Boolean getAtivo() {
        return ativo;
    }
}
