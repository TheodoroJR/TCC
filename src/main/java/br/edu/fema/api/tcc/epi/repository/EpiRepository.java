package br.edu.fema.api.tcc.epi.repository;


import aj.org.objectweb.asm.commons.Remapper;
import br.edu.fema.api.tcc.epi.model.EpiModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface EpiRepository extends JpaRepository<EpiModel,Long>{

    List<EpiModel> findByAtivoTrue();

}
