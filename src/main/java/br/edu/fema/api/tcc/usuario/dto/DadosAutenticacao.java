package br.edu.fema.api.tcc.usuario.dto;

import jakarta.validation.constraints.NotBlank;

public class DadosAutenticacao {

    @NotBlank(message ="não deve estar em branco")
    private String login;
    @NotBlank(message ="não deve estar em branco")
    private String senha;

   public DadosAutenticacao(String usuario, String senha) {
       this.login = usuario;
       this.senha = senha;
   }

   public String getUsuario() {
       return login;
   }

   public String getSenha() {
       return senha;
   }
}
