package br.edu.fema.api.tcc.histentrega.model;

import br.edu.fema.api.tcc.colaborador.model.ColaboradorModel;
import br.edu.fema.api.tcc.epi.model.EpiModel;
import br.edu.fema.api.tcc.histentrega.dto.DadosListHistEntregaDTO;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "histentregaepis")
@Table(name = "histentregaepis")
@NoArgsConstructor
public class HistoricoEntregaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private ColaboradorModel colaborador;
    @ManyToMany
    private List<EpiModel> epis = new ArrayList<>();
    private LocalDateTime dataEntrega;

    @PrePersist
    private void create() {
        this.dataEntrega = LocalDateTime.now();
    }

    public HistoricoEntregaModel(DadosListHistEntregaDTO dadosListHistEntregaDTO) {
        this.colaborador = dadosListHistEntregaDTO.getColaborador();
        this.epis = dadosListHistEntregaDTO.getEpis();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ColaboradorModel getColaborador() {
        return colaborador;
    }

    public void setColaborador(ColaboradorModel colaborador) {
        this.colaborador = colaborador;
    }

    public List<EpiModel> getEpis() {
        return epis;
    }

    public void setEpis(List<EpiModel> epis) {
        this.epis = epis;
    }

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }
}


