package br.edu.fema.api.tcc.controller;

import br.edu.fema.api.tcc.risco.dto.AtualizacaoRiscoDTO;
import br.edu.fema.api.tcc.risco.dto.DadosListagemRiscoDTO;
import br.edu.fema.api.tcc.risco.dto.DadosRiscoDTO;
import br.edu.fema.api.tcc.risco.model.RiscoModel;
import br.edu.fema.api.tcc.risco.repository.RiscoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/riscos")
@CrossOrigin("http://localhost:4200")
public class RiscoController {

    @Autowired
    private RiscoRepository riscoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastroDeRisco(@RequestBody @Valid DadosRiscoDTO riscoDTO,
                                          UriComponentsBuilder componentsBuilder){
        var risco = new RiscoModel(riscoDTO);
        riscoRepository.save(risco);
        //System.out.println(riscoDTO);
        var uri = componentsBuilder.path("/riscos/{id}").buildAndExpand(risco.getCodigoRisco()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemRiscoDTO(risco));
    }

    //@GetMapping
    //public ResponseEntity<Page<DadosListagemRiscoDTO>> listarRiscos(@PageableDefault(size=5) Pageable paginacao){
    //    var page = riscoRepository.findByAtivoTrue(paginacao).map(DadosListagemRiscoDTO::new);
    //    return ResponseEntity.ok(page);
    //}

    @GetMapping
    public List<RiscoModel> listarRiscos(){
        return riscoRepository.findByAtivoTrue();
    }

    @GetMapping("{id}")
    public Optional<RiscoModel> listarRiscosPorId(@PathVariable Long id){
        return riscoRepository.findById(id);
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity atualizarDadosRisco(@PathVariable Long id, @RequestBody @Valid AtualizacaoRiscoDTO atualizacaoRiscoDTO){
        var risco = riscoRepository.getReferenceById(atualizacaoRiscoDTO.getCodigoRisco());
        risco.atualizarDados(atualizacaoRiscoDTO);
        return ResponseEntity.ok(new DadosListagemRiscoDTO(risco));
    }

    @DeleteMapping("/risco/{id}")
    @Transactional
    public ResponseEntity deletarRisco(@PathVariable Long id){
        var risco = riscoRepository.getReferenceById(id);
        risco.excluirRisco();

        return ResponseEntity.noContent().build();
    }

}
