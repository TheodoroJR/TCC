package br.edu.fema.api.tcc.histentrega.dto;

import br.edu.fema.api.tcc.colaborador.model.ColaboradorModel;
import br.edu.fema.api.tcc.epi.model.EpiModel;
import java.util.List;

public class DadosListHistEntregaDTO {

    private ColaboradorModel colaborador;
    private List<EpiModel> epis;

    public DadosListHistEntregaDTO(ColaboradorModel colaborador, List<EpiModel> epis) {
        this.colaborador = colaborador;
        this.epis = epis;
    }

    public ColaboradorModel getColaborador() {
        return colaborador;
    }

    public List<EpiModel> getEpis() {
        return epis;
    }

    public Long getColaboradorId() {
        return colaborador.getCodigoColaborador();
    }
}
