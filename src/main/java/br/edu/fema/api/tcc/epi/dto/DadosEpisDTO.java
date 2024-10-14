package br.edu.fema.api.tcc.epi.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalTime;


public class DadosEpisDTO {

    private String nomeEpi;
    private String descricaoEpi;
    private Integer numeroCa;
    private String validadeCa;
    private String fabricanteEpi;
    private String dataDeCadastro;
    private int qtdEstoque;

    public DadosEpisDTO(String nomeEpi, String descricaoEpi, Integer numeroCa, String validadeCa,
                        String fabricanteEpi, int qtdEstoque) {
        this.nomeEpi = nomeEpi;
        this.descricaoEpi = descricaoEpi;
        this.numeroCa = numeroCa;
        this.validadeCa = validadeCa;
        this.fabricanteEpi = fabricanteEpi;
        this.qtdEstoque = qtdEstoque;
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

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    @Override
    public String toString() {
        return "DadosEpisDTO{" +
                "nomeEpi='" + nomeEpi + '\'' +
                ", descricaoEpi='" + descricaoEpi + '\'' +
                ", numeroCa=" + numeroCa +
                ", validadeCa='" + validadeCa + '\'' +
                ", fabricanteEpi='" + fabricanteEpi + '\'' +
                ", dataDeCadastro='" + dataDeCadastro + '\'' +
                ", qtdEstoque=" + qtdEstoque +
                '}';
    }
}
