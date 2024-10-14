package br.edu.fema.api.tcc.colaborador.dto;

import br.edu.fema.api.tcc.cargos.model.CargosModel;
import br.edu.fema.api.tcc.epi.model.EpiModel;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;

public class DadosColaboradoresDTO {

    private Long codigoColaborador;
    private String nomeColaborador;
    private String cpf;
    private String telefone;
    private String dataAdmissao;
    private CargosModel cargo;

    private Boolean ativo;

    public DadosColaboradoresDTO(String nomeColaborador, String cpf, String telefone, String dataAdmissao,
                                 CargosModel cargo) {
        this.nomeColaborador = nomeColaborador;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataAdmissao = dataAdmissao;
        this.cargo = cargo;
        this.ativo = true;
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



    @Override
    public String toString() {
        return "DadosColaboradoresDTO{" +
                "codigoColaborador=" + codigoColaborador +
                ", nomeColaborador='" + nomeColaborador + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataAdmissao='" + dataAdmissao + '\'' +
                ", cargo=" + cargo +
                '}';
    }
}
