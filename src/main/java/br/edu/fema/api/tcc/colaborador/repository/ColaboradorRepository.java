package br.edu.fema.api.tcc.colaborador.repository;

import br.edu.fema.api.tcc.colaborador.model.ColaboradorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColaboradorRepository extends JpaRepository<ColaboradorModel, Long> {

    //List<EpiModel> findByAtivoTrue();
    List<ColaboradorModel> findByAtivoTrue();
}
