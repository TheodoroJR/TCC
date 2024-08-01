package br.edu.fema.api.tcc.risco.repository;

import br.edu.fema.api.tcc.loja.model.LojaModel;
import br.edu.fema.api.tcc.risco.model.RiscoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiscoRepository extends JpaRepository<RiscoModel, Long> {
    Page<RiscoModel> findByAtivoTrue(Pageable paginacao);
}
