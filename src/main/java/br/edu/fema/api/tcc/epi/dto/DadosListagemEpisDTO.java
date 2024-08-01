package br.edu.fema.api.tcc.epi.dto;

import br.edu.fema.api.tcc.epi.model.EpiModel;


public class DadosListagemEpisDTO {

    private Long codigoEpi;
    private String nomeEpi;
    private String descricaoEpi;
    private Integer numeroCa;
    private String validadeCa;
    private String fabricanteEpi;
    private String dataDeCadastro;
    private int qtdEstoque;
    private Boolean ativo;


    public DadosListagemEpisDTO(EpiModel epiModel) {
        this.codigoEpi= epiModel.getCodigoEpi();
        this.nomeEpi = epiModel.getNomeEpi();
        this.descricaoEpi = epiModel.getDescricaoEpi();
        this.numeroCa = epiModel.getNumeroCa();
        this.validadeCa = epiModel.getValidadeCa();
        this.fabricanteEpi = epiModel.getFabricanteEpi();
        this.dataDeCadastro = epiModel.getDataDeCadastro();
        this.qtdEstoque = epiModel.getQtdEstoque();
        this.ativo=epiModel.getAtivo();
    }

    public Long getCodigoEpi() {
        return codigoEpi;
    }

    public void setCodigoEpi(Long codigoEpi) {
        this.codigoEpi = codigoEpi;
    }

    public String getNomeEpi() {
        return nomeEpi;
    }

    public void setNomeEpi(String nomeEpi) {
        this.nomeEpi = nomeEpi;
    }

    public String getDescricaoEpi() {
        return descricaoEpi;
    }

    public void setDescricaoEpi(String descricaoEpi) {
        this.descricaoEpi = descricaoEpi;
    }

    public Integer getNumeroCa() {
        return numeroCa;
    }

    public void setNumeroCa(Integer numeroCa) {
        this.numeroCa = numeroCa;
    }

    public String getValidadeCa() {
        return validadeCa;
    }

    public void setValidadeCa(String validadeCa) {
        this.validadeCa = validadeCa;
    }

    public String getFabricanteEpi() {
        return fabricanteEpi;
    }

    public void setFabricanteEpi(String fabricanteEpi) {
        this.fabricanteEpi = fabricanteEpi;
    }

    public String getDataDeCadastro() {
        return dataDeCadastro;
    }

    public Boolean getAtivo() {
        return ativo;
    }
}