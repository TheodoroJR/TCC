package br.edu.fema.api.tcc.controller;

import br.edu.fema.api.tcc.epi.dto.AtualizacaoEpisDTO;
import br.edu.fema.api.tcc.epi.dto.DadosEpisDTO;
import br.edu.fema.api.tcc.epi.dto.EntregaDeEpiDTO;
import br.edu.fema.api.tcc.epi.model.EpiModel;
import br.edu.fema.api.tcc.epi.repository.EpiRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    public void cadastroEpi(@RequestBody @Valid DadosEpisDTO dadosEpisDTO){
        epiRepository.save(new EpiModel(dadosEpisDTO));
    }

   @GetMapping
   public List<EpiModel> listarEpi(){
       return epiRepository.findByAtivoTrue();
   }

    @GetMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<EpiModel> buscarPorId(@PathVariable Long id){
        return epiRepository.findById(id);
    }

   @PutMapping
   @Transactional
   public void atualizarEpi(@RequestBody @Valid AtualizacaoEpisDTO atualizacaoEpisDTO){
        var epi = epiRepository.getReferenceById(atualizacaoEpisDTO.getCodigoEpi());
        epi.atualizarDados(atualizacaoEpisDTO);
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
