package br.edu.fema.api.tcc.loja.dto;

import br.edu.fema.api.tcc.endereco.Estados;
import br.edu.fema.api.tcc.loja.model.LojaModel;
import br.edu.fema.api.tcc.loja.model.TipoLoja;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DadosListagemLojaDTO {

    private Long codigoLoja;
    private String nomeLoja;
    private TipoLoja tipoLoja;
    private String rua;
    private String bairro;
    private String cep;
    private String cidade;
    private Estados uf;
    private String complemento;
    private String numero;
    private Boolean ativo;

    public DadosListagemLojaDTO(LojaModel loja){
        this.codigoLoja = loja.getCodigoLoja();
        this.nomeLoja = loja.getNomeLoja();
        this.tipoLoja = loja.getTipoLoja();
        this.rua = loja.getRua();
        this.bairro = loja.getBairro();
        this.cep = loja.getCep();
        this.cidade = loja.getCidade();
        this.uf = loja.getUf();
        this.complemento = loja.getComplemento();
        this.numero = loja.getNumero();
        this.ativo = loja.getAtivo();
    }

    public Long getCodigoLoja() {
        return codigoLoja;
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public TipoLoja getTipoLoja() {
        return tipoLoja;
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public Estados getUf() {
        return uf;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getNumero() {
        return numero;
    }

    public Boolean getAtivo() {
        return ativo;
    }
}
