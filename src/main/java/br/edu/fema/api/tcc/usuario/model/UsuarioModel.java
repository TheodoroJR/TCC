package br.edu.fema.api.tcc.usuario.model;

import br.edu.fema.api.tcc.colaborador.dto.DadosColaboradoresDTO;
import br.edu.fema.api.tcc.colaborador.model.ColaboradorModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

//@Entity(name = "usuario")
//@Table(name = "usuarios")
public class UsuarioModel  {


   // @Email
    private String email;
    private String login;
    private String senha;

    public UsuarioModel( String email, String login, String senha) {
        this.email = email;
        this.login = login;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
}
