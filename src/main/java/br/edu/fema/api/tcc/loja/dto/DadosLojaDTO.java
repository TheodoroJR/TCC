package br.edu.fema.api.tcc.loja.dto;

import br.edu.fema.api.tcc.endereco.Estados;
import br.edu.fema.api.tcc.loja.model.TipoLoja;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DadosLojaDTO{

    @NotBlank
    private String nomeLoja;
    @NotNull
    private TipoLoja tipoLoja;
    @NotBlank
    private String rua;
    @NotBlank
    private String bairro;
    @NotBlank
    private String cep;
    @NotBlank
    private String cidade;
    @NotNull
    @Embedded
    private Estados uf;
    private String complemento;
    @NotBlank
    private String numero;


    public DadosLojaDTO (String nomeLoja, TipoLoja tipoLoja, String rua,
                        String bairro, String cep, String cidade, Estados uf,
                        String complemento, String numero) {

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

    @Override
    public String toString() {
        return "DadosLojaDTO{" +
                "nomeLoja='" + nomeLoja + '\'' +
                ", tipoLoja=" + tipoLoja +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cep='" + cep + '\'' +
                ", cidade='" + cidade + '\'' +
                ", uf=" + uf +
                ", complemento='" + complemento + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
