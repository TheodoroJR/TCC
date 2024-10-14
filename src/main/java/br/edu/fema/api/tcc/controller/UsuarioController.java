//package br.edu.fema.api.tcc.controller;
//
//
//import br.edu.fema.api.tcc.usuario.model.UsuarioModel;
//import br.edu.fema.api.tcc.usuario.repository.UsuarioRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/usuarios")
//public class UsuarioController {
//
//    @Autowired
//    private final UsuarioRepository usuarioRepository;
//
//    public UsuarioController(UsuarioRepository usuarioRepository) {
//        this.usuarioRepository = usuarioRepository;
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public void salvar(@RequestBody UsuarioModel usuarioModel){
//        usuarioRepository.save(usuarioModel);
//
//    }
//}
