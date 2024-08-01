package br.edu.fema.api.tcc.colaborador.dto;

import br.edu.fema.api.tcc.cargos.model.CargosModel;
import br.edu.fema.api.tcc.epi.model.EpiModel;

import java.util.List;

public class AtualizarDadosColaboradores {

    private Long codigoColaborador;
    private String nomeColaborador;
    private String telefone;
    private CargosModel cargo;
    private List<EpiModel> epis;
    private Boolean ativo;

    public AtualizarDadosColaboradores(Long codigoColaborador, String nomeColaborador, String telefone, CargosModel cargo, List<EpiModel> epis) {
        this.codigoColaborador = codigoColaborador;
        this.nomeColaborador = nomeColaborador;
        this.telefone = telefone;
        this.cargo = cargo;
        this.epis = epis;
    }

    public Long getCodigoColaborador() {
        return codigoColaborador;
    }

    public String getNomeColaborador() {
        return nomeColaborador;
    }

    public String getTelefone() {
        return telefone;
    }

    public CargosModel getCargo() {
        return cargo;
    }

    public List<EpiModel> getEpis() {
        return epis;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
