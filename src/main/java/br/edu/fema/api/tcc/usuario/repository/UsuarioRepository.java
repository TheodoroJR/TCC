package br.edu.fema.api.tcc.usuario.repository;

import br.edu.fema.api.tcc.usuario.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<UsuarioModel,Long> {
    UserDetails findByLogin(String login);
}
