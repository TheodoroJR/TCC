package br.edu.fema.api.tcc.cargos.dto;

import br.edu.fema.api.tcc.risco.model.RiscoModel;

import java.util.List;

public record DadosCargosRecord(String nomeCargo, List<RiscoModel> riscoModels) {

}
