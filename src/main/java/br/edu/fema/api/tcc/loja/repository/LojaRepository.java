package br.edu.fema.api.tcc.loja.repository;

import aj.org.objectweb.asm.commons.Remapper;
import br.edu.fema.api.tcc.epi.model.EpiModel;
import br.edu.fema.api.tcc.loja.model.LojaModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LojaRepository extends JpaRepository<LojaModel, Long> {

    Page <LojaModel> findByAtivoTrue(Pageable paginacao);
}
