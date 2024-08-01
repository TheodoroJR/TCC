package br.edu.fema.api.tcc.risco.dto;

public class AtualizacaoRiscoDTO {

    private Long codigoRisco;
    private String nomeRisco;
    private String descricaoRisco;

    public AtualizacaoRiscoDTO(Long codigoRisco, String nomeRisco, String descricaoRisco) {
        this.codigoRisco = codigoRisco;
        this.nomeRisco = nomeRisco;
        this.descricaoRisco = descricaoRisco;
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
}
