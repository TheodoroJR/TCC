package br.edu.fema.api.tcc.cargos.model;

import br.edu.fema.api.tcc.cargos.dto.AtualizarDadosCargos;
import br.edu.fema.api.tcc.cargos.dto.DadosCargosDTO;
import br.edu.fema.api.tcc.cargos.dto.DadosCargosRecord;
import br.edu.fema.api.tcc.risco.model.RiscoModel;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "cargo")
@Table(name = "cargos")
public class CargosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoCargo;
    private String nomeCargo;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<RiscoModel> riscosCargos;
    private Boolean ativo;

    public CargosModel() {
    }

  //  public CargosModel(DadosCargosDTO dadosCargosRecord) {
  //     this.nomeCargo = dadosCargosRecord.getNomeCargo();
  //     this.riscosCargos = dadosCargosRecord.getRiscosCargos();
  //     this.ativo = true;
  // }

    public void setCodigoCargo(Long codigoCargo) {
        this.codigoCargo = codigoCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public void setRiscosCargos(List<RiscoModel> riscosCargos) {
        this.riscosCargos = riscosCargos;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<RiscoModel> getRiscosCargos() {
        return riscosCargos;
    }


    public Long getCodigoCargo() {
        return codigoCargo;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public List<RiscoModel> getRiscos() {
        return riscosCargos;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void atualizarDados(AtualizarDadosCargos atualizarDadosCargos) {
        if (atualizarDadosCargos.getNomeCargo() != null) {
            this.nomeCargo = atualizarDadosCargos.getNomeCargo();
        }
        if (atualizarDadosCargos.getRiscosCargos() != null) {
            this.riscosCargos = atualizarDadosCargos.getRiscosCargos();
        }
        if (atualizarDadosCargos.getAtivo() != null) {
            this.ativo = atualizarDadosCargos.getAtivo();
        }

    }

    public void excluirCargo() {
        this.ativo = false;
    }
}
