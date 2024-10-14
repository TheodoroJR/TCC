package br.edu.fema.api.tcc.controller;


import br.edu.fema.api.tcc.infra.DadosTokenJWT;
import br.edu.fema.api.tcc.infra.TokenService;
import br.edu.fema.api.tcc.usuario.dto.DadosAutenticacaoRecord;
import br.edu.fema.api.tcc.usuario.model.UsuarioModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin("http://localhost:4200")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;


    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacaoRecord dados) {
        var authenticationsToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(authenticationsToken);

        var tokenJWT = tokenService.gerarToken((UsuarioModel) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT) );
    }

}
