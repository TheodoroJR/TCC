package br.edu.fema.api.tcc.epi.model;

import br.edu.fema.api.tcc.epi.dto.AtualizacaoEpisDTO;
import br.edu.fema.api.tcc.epi.dto.DadosEpisDTO;
import br.edu.fema.api.tcc.epi.dto.EntregaDeEpiDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "epis")
@Entity(name = "epi")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class EpiModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoEpi;
    private String nomeEpi;
    private String descricaoEpi;
    private Integer numeroCa;
    private String validadeCa;
    private String fabricanteEpi;
    private String dataDeCadastro;
    private int qtdEstoque;
    private Boolean ativo;

        public EpiModel(DadosEpisDTO dadosEpisDTO) {
        this.nomeEpi = dadosEpisDTO.getNomeEpi();
        this.descricaoEpi = dadosEpisDTO.getDescricaoEpi();
        this.numeroCa = dadosEpisDTO.getNumeroCa();
        this.validadeCa = dadosEpisDTO.getValidadeCa();
        this.fabricanteEpi = dadosEpisDTO.getFabricanteEpi();
        this.dataDeCadastro = dadosEpisDTO.getDataDeCadastro();
        this.qtdEstoque = dadosEpisDTO.getQtdEstoque();
        this.ativo = true;
    }

    public Long getCodigoEpi() {
        return codigoEpi;
    }

    public String getNomeEpi() {
        return nomeEpi;
    }

    public String getDescricaoEpi() {
        return descricaoEpi;
    }

    public Integer getNumeroCa() {
        return numeroCa;
    }

    public String getValidadeCa() {
        return validadeCa;
    }

    public String getFabricanteEpi() {
        return fabricanteEpi;
    }

    public String getDataDeCadastro() {
        return dataDeCadastro;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public void atualizarDados(AtualizacaoEpisDTO atualizacaoEpisDTO) {
        if (atualizacaoEpisDTO.getNomeEpi() != null) {
            this.nomeEpi = atualizacaoEpisDTO.getNomeEpi();
        }
        if (atualizacaoEpisDTO.getDescricaoEpi() != null) {
            this.descricaoEpi = atualizacaoEpisDTO.getDescricaoEpi();
        }
        if (atualizacaoEpisDTO.getNumeroCa() != null) {
            this.numeroCa = atualizacaoEpisDTO.getNumeroCa();
        }
        if (atualizacaoEpisDTO.getValidadeCa() != null) {
            this.validadeCa = atualizacaoEpisDTO.getValidadeCa();
        }
        if (atualizacaoEpisDTO.getFabricanteEpi() != null) {
            this.fabricanteEpi = atualizacaoEpisDTO.getFabricanteEpi();
        }

    }

    public void excluir() {
            this.ativo = false;
    }
}
