package br.edu.fema.api.tcc.risco.model;

import br.edu.fema.api.tcc.risco.dto.AtualizacaoRiscoDTO;
import br.edu.fema.api.tcc.risco.dto.DadosRiscoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "riscos")
@Entity(name = "risco")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class RiscoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoRisco;
    private String nomeRisco;
    private String descricaoRisco;
    private Boolean ativo;

    public RiscoModel(DadosRiscoDTO dadosRisco) {
        this.nomeRisco = dadosRisco.getNomeRisco();
        this.descricaoRisco = dadosRisco.getDescricaoRisco();
        this.ativo = true;
    }

    public Long getCodigoRisco() {
        return codigoRisco;
    }

    public String getNomeRisco() {
        return nomeRisco;
    }

    public String getDescricaoRisco() {
        return descricaoRisco;
    }

    public Boolean getAtivo() {
        return ativo;
    }


    public void atualizarDados(AtualizacaoRiscoDTO atualizacaoRiscoDTO) {
        if (atualizacaoRiscoDTO.getNomeRisco() != null) {
            this.nomeRisco = atualizacaoRiscoDTO.getNomeRisco();
        }
        if(atualizacaoRiscoDTO.getDescricaoRisco() != null){
            this.descricaoRisco = atualizacaoRiscoDTO.getDescricaoRisco();
        }
    }


    public void excluirRisco(){
        this.ativo = false;
    }
}
