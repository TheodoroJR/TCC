package br.edu.fema.api.tcc.cargos.model;

import br.edu.fema.api.tcc.cargos.dto.AtualizarDadosCargos;
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
    @ManyToMany
    private List<RiscoModel> riscosCargos;
    private Boolean ativo;

    public CargosModel(DadosCargosRecord dadosCargosRecord) {
        this.nomeCargo = dadosCargosRecord.nomeCargo();
        this.riscosCargos = dadosCargosRecord.riscoModels();
        this.ativo = true;
    }

    public CargosModel() {
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
