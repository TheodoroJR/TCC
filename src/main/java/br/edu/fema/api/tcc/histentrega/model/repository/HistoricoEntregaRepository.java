package br.edu.fema.api.tcc.histentrega.model.repository;

import br.edu.fema.api.tcc.histentrega.model.HistoricoEntregaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoEntregaRepository extends JpaRepository<HistoricoEntregaModel, Long>{
}
