package br.edu.fema.api.tcc.controller;

import br.edu.fema.api.tcc.epi.dto.AtualizacaoEpisDTO;
import br.edu.fema.api.tcc.epi.dto.DadosEpisDTO;
import br.edu.fema.api.tcc.epi.dto.DadosListagemEpisDTO;
import br.edu.fema.api.tcc.epi.dto.EntregaDeEpiDTO;
import br.edu.fema.api.tcc.epi.model.EpiModel;
import br.edu.fema.api.tcc.epi.repository.EpiRepository;
import br.edu.fema.api.tcc.risco.dto.AtualizacaoRiscoDTO;
import br.edu.fema.api.tcc.risco.dto.DadosListagemRiscoDTO;
import br.edu.fema.api.tcc.risco.model.RiscoModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("epis")
@CrossOrigin("http://localhost:4200")
public class EpiController {

    @Autowired
    private EpiRepository epiRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastroEpi(@RequestBody @Valid DadosEpisDTO dadosEpisDTO,
                                      UriComponentsBuilder componentsBuilder){

        var epi = new EpiModel(dadosEpisDTO);
        epiRepository.save(epi);
        var uri = componentsBuilder.path("/epis/{id}").buildAndExpand(epi.getCodigoEpi()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemEpisDTO(epi));
    }

   @GetMapping
   public List<EpiModel> listarEpi(){
       return epiRepository.findByAtivoTrue();
   }

    @GetMapping("{id}")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<EpiModel> buscarPorId(@PathVariable Long id){
        return epiRepository.findById(id);
    }

   @PutMapping("{id}")
   @Transactional
   public ResponseEntity atualizarEpi(@PathVariable Long id , @RequestBody @Valid AtualizacaoEpisDTO atualizacaoEpisDTO){
        var epi = epiRepository.getReferenceById(atualizacaoEpisDTO.getCodigoEpi());
        epi.atualizarDados(atualizacaoEpisDTO);
        return ResponseEntity.ok(new DadosListagemEpisDTO(epi));
   }

   @DeleteMapping("/epi/{id}")
   @Transactional
    public void deletarEpi(@PathVariable Long id){
       var epi = epiRepository.getReferenceById(id);
       epi.excluir();
    }


    @PutMapping("/entregarEpi")
    @Transactional
    public void entregarEpi(@RequestBody @Valid EntregaDeEpiDTO entregaDeEpiDTO){
        var epiEntrega = epiRepository.getReferenceById(entregaDeEpiDTO.getCodigoEpi());
        int quantidadeAtual = epiEntrega.getQtdEstoque();
        epiEntrega.setQtdEstoque(quantidadeAtual-1);
        System.out.println("Estoque atualizado " + epiEntrega.getQtdEstoque());
    }
}
