package br.edu.fema.api.tcc.colaborador.model;

import br.edu.fema.api.tcc.cargos.dto.AtualizarDadosCargos;
import br.edu.fema.api.tcc.cargos.model.CargosModel;
import br.edu.fema.api.tcc.colaborador.dto.AtualizarDadosColaboradores;
import br.edu.fema.api.tcc.colaborador.dto.DadosColaboradoresDTO;
import br.edu.fema.api.tcc.epi.model.EpiModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity(name="colaborador")
@Table(name = "colaboradores")
//@AllArgsConstructor
//@NoArgsConstructor
//@EqualsAndHashCode(of = "id")
public class ColaboradorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoColaborador;
    private String nomeColaborador;
    private String cpf;
    private String telefone;
    private String dataAdmissao;
    @ManyToOne
    private CargosModel cargo;
    @ManyToMany
    private List<EpiModel> epis;
    private Boolean ativo;

    public ColaboradorModel() {
    }

  // public ColaboradorModel(DadosColaboradoresDTO dadosColaboradoresDTO) {
  //     this.nomeColaborador = dadosColaboradoresDTO.getNomeColaborador();
  //     this.cpf = dadosColaboradoresDTO.getCpf();
  //     this.telefone = dadosColaboradoresDTO.getTelefone();
  //     this.dataAdmissao = dadosColaboradoresDTO.getDataAdmissao();
  //     this.cargo = dadosColaboradoresDTO.getCargo();
  //     this.ativo = true;
  // }

    public void setCodigoColaborador(Long codigoColaborador) {
        this.codigoColaborador = codigoColaborador;
    }

    public void setNomeColaborador(String nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public void setCargo(CargosModel cargo) {
        this.cargo = cargo;
    }

    public void setEpis(List<EpiModel> epis) {
        this.epis = epis;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
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

   // public List<EpiModel> getEpis() {
   //     return epis;
   // }


    public Boolean getAtivo() {
        return ativo;
    }

    public void atualizarDados(AtualizarDadosColaboradores atualizarDadosColaboradores) {
        if (atualizarDadosColaboradores.getNomeColaborador() != null) {
            this.nomeColaborador = atualizarDadosColaboradores.getNomeColaborador();
        }
        if (atualizarDadosColaboradores.getTelefone() != null) {
            this.telefone = atualizarDadosColaboradores.getTelefone();
        }
        if (atualizarDadosColaboradores.getCargo() != null) {
            this.cargo = atualizarDadosColaboradores.getCargo();
        }
        if (atualizarDadosColaboradores.getEpis() != null) {
            this.epis = atualizarDadosColaboradores.getEpis();
        }
    }

    public void excluirColaborador() {

        this.ativo = false;
    }

    public void ativarColaborador() {
        this.ativo = true;
    }

    public List<EpiModel> setListaEpis( ArrayList<EpiModel> es){
        return this.epis = epis;
    }

    public List<EpiModel> getEpis() {
        return epis;
    }
}



