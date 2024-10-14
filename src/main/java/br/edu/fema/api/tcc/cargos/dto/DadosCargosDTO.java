package br.edu.fema.api.tcc.cargos.dto;

import br.edu.fema.api.tcc.cargos.model.CargosModel;
import br.edu.fema.api.tcc.risco.model.RiscoModel;

import java.util.List;

public class DadosCargosDTO {

    private String nomeCargo;
    private List<RiscoModel> riscosCargos;

    public DadosCargosDTO(String nomeCargo, List<RiscoModel> riscosCargos) {
        this.nomeCargo = nomeCargo;
        this.riscosCargos = riscosCargos;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public List<RiscoModel> getRiscosCargos() {
        return riscosCargos;
    }


}
