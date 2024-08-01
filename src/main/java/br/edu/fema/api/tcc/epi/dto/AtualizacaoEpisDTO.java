package br.edu.fema.api.tcc.epi.dto;

import br.edu.fema.api.tcc.epi.model.EpiModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public final class AtualizacaoEpisDTO {

    @NotNull
    private Long codigoEpi;
    private String nomeEpi;
    private String descricaoEpi;
    private Integer numeroCa;
    private String validadeCa;
    private String fabricanteEpi;
    private int qtdEstoque;

   public AtualizacaoEpisDTO(Long codigoEpi, String nomeEpi, String descricaoEpi, Integer numeroCa,
                             String validadeCa, String fabricanteEpi) {
       this.codigoEpi = codigoEpi;
       this.nomeEpi = nomeEpi;
       this.descricaoEpi = descricaoEpi;
       this.numeroCa = numeroCa;
       this.validadeCa = validadeCa;
       this.fabricanteEpi = fabricanteEpi;
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

    public int getQtdEstoque() {
        return qtdEstoque;
    }
}
