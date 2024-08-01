package br.edu.fema.api.tcc.loja.dto;

import br.edu.fema.api.tcc.endereco.Estados;
import br.edu.fema.api.tcc.loja.model.TipoLoja;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public final class AtualizacaoLojaDTO {

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

    public AtualizacaoLojaDTO(Long codigoLoja, String nomeLoja, TipoLoja tipoLoja, String rua,
                              String bairro, String cep, String cidade, Estados uf, String complemento, String numero) {
        this.codigoLoja = codigoLoja;
        this.nomeLoja = nomeLoja;
        this.tipoLoja = tipoLoja;
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
        this.complemento = complemento;
        this.numero = numero;
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
}
