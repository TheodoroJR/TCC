package br.edu.fema.api.tcc.cargos.dto;

import br.edu.fema.api.tcc.cargos.model.CargosModel;
import br.edu.fema.api.tcc.risco.model.RiscoModel;

import java.util.List;

public class DadosListaCargoDTO {

   private Long codigoCargo;
   private String nomeCargo;
   private List<RiscoModel> riscosCargos;
   private Boolean ativo;

   public DadosListaCargoDTO(CargosModel listaCargos){
       this.codigoCargo = listaCargos.getCodigoCargo();
       this.nomeCargo = listaCargos.getNomeCargo();
       this.riscosCargos = listaCargos.getRiscos();
       this.ativo = listaCargos.getAtivo();
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
