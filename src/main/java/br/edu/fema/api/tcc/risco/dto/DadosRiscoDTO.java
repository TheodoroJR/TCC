package br.edu.fema.api.tcc.risco.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

public class DadosRiscoDTO {

    @NotBlank
    private String nomeRisco;
    @NotBlank
    private String descricaoRisco;

    public DadosRiscoDTO(String nomeRisco, String descricaoRisco) {
        this.nomeRisco = nomeRisco;
        this.descricaoRisco = descricaoRisco;
    }

    public String getNomeRisco() {
        return nomeRisco;
    }

    public String getDescricaoRisco() {
        return descricaoRisco;
    }

    @Override
    public String toString() {
        return "DadosRiscoDTO{" +
                "nomeRisco='" + nomeRisco + '\'' +
                ", descricaoRisco='" + descricaoRisco + '\'' +
                '}';
    }
}
