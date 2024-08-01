package br.edu.fema.api.tcc.loja.model;

import br.edu.fema.api.tcc.endereco.Estados;
import br.edu.fema.api.tcc.epi.dto.AtualizacaoEpisDTO;
import br.edu.fema.api.tcc.loja.dto.AtualizacaoLojaDTO;
import br.edu.fema.api.tcc.loja.dto.DadosLojaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "lojas")
@Entity(name = "loja")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class LojaModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoLoja;
    private String nomeLoja;
    @Enumerated(EnumType.STRING)
    private TipoLoja tipoLoja;
    private String rua;
    private String bairro;
    private String cep;
    private String cidade;
    @Enumerated(EnumType.STRING)
    private Estados uf;
    private String complemento;
    private String numero;
    private Boolean ativo;

    public LojaModel(DadosLojaDTO dadosEndereco){
        this.nomeLoja = dadosEndereco.getNomeLoja();
        this.tipoLoja = dadosEndereco.getTipoLoja();
        this.rua = dadosEndereco.getRua();
        this.bairro = dadosEndereco.getBairro();
        this.cep = dadosEndereco.getCep();
        this.cidade = dadosEndereco.getCidade();
        this.uf = dadosEndereco.getUf();
        this.complemento = dadosEndereco.getComplemento();
        this.numero = dadosEndereco.getNumero();
        this.ativo = true;

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

    public void atualizarDados(AtualizacaoLojaDTO atualizacaoLojaDTO) {
        if (atualizacaoLojaDTO.getNomeLoja() != null) {
            this.nomeLoja = atualizacaoLojaDTO.getNomeLoja();
        }
        if (atualizacaoLojaDTO.getTipoLoja() != null) {
            this.tipoLoja = atualizacaoLojaDTO.getTipoLoja();
        }
       if(atualizacaoLojaDTO.getRua() != null){
           this.rua = atualizacaoLojaDTO.getRua();
       }
       if(atualizacaoLojaDTO.getBairro() != null){
           this.bairro = atualizacaoLojaDTO.getBairro();
       }
       if(atualizacaoLojaDTO.getCep() != null){
           this.cep = atualizacaoLojaDTO.getCep();
       }
       if(atualizacaoLojaDTO.getCidade() != null){
           this.cidade = atualizacaoLojaDTO.getCidade();
       }
       if(atualizacaoLojaDTO.getUf() != null){
           this.uf = atualizacaoLojaDTO.getUf();
       }
       if(atualizacaoLojaDTO.getComplemento() != null){
           this.complemento = atualizacaoLojaDTO.getComplemento();
       }
       if(atualizacaoLojaDTO.getNumero() != null){
           this.numero = atualizacaoLojaDTO.getNumero();
       }

    }

    public void excluirLoja(){
        this.ativo = false;
    }


}

