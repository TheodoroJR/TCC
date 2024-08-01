package br.edu.fema.api.tcc.cargos.repository;

import aj.org.objectweb.asm.commons.Remapper;
import br.edu.fema.api.tcc.cargos.model.CargosModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargosRepository extends JpaRepository<CargosModel, Long> {
    Page<CargosModel> findByAtivoTrue(Pageable paginacao);
}
