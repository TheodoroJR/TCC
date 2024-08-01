package br.edu.fema.api.tcc.colaborador.dto;

import br.edu.fema.api.tcc.cargos.model.CargosModel;
import br.edu.fema.api.tcc.colaborador.model.ColaboradorModel;
import br.edu.fema.api.tcc.epi.model.EpiModel;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;

public class DadosListaColaboradoresDTO {

    private Long codigoColaborador;
    private String nomeColaborador;
    private String cpf;
    private String telefone;
    private String dataAdmissao;
    private CargosModel cargo;
    private List<EpiModel> epis;
    private Boolean ativo;

    public DadosListaColaboradoresDTO(ColaboradorModel colaboradorModel) {
        this.codigoColaborador = colaboradorModel.getCodigoColaborador();
        this.nomeColaborador = colaboradorModel.getNomeColaborador();
        this.cpf = colaboradorModel.getCpf();
        this.telefone = colaboradorModel.getTelefone();
        this.dataAdmissao = colaboradorModel.getDataAdmissao();
        this.cargo = colaboradorModel.getCargo();
        this.epis = colaboradorModel.getEpis();
        this.ativo = colaboradorModel.getAtivo();
    }

    public Long getCodigoColaborador() {
        return codigoColaborador;
    }

    public String getNomeColaborador() {
        return nomeColaborador;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
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
}
