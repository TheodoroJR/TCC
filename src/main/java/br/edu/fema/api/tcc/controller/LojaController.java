package br.edu.fema.api.tcc.controller;

import br.edu.fema.api.tcc.epi.dto.AtualizacaoEpisDTO;
import br.edu.fema.api.tcc.epi.dto.DadosEpisDTO;
import br.edu.fema.api.tcc.epi.dto.DadosListagemEpisDTO;
import br.edu.fema.api.tcc.epi.model.EpiModel;
import br.edu.fema.api.tcc.loja.dto.AtualizacaoLojaDTO;
import br.edu.fema.api.tcc.loja.dto.DadosListagemLojaDTO;
import br.edu.fema.api.tcc.loja.dto.DadosLojaDTO;
import br.edu.fema.api.tcc.loja.model.LojaModel;
import br.edu.fema.api.tcc.loja.repository.LojaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lojas")
public class LojaController {


    @Autowired
    private LojaRepository lojaRepository;

    @PostMapping
    @Transactional
    public void cadastroDeLoja(@RequestBody @Valid DadosLojaDTO lojaDTO){
        lojaRepository.save(new LojaModel(lojaDTO));
        System.out.println(lojaDTO);
    }

    @GetMapping
    public Page<DadosListagemLojaDTO> listarLojas(@PageableDefault (size=5) Pageable paginacao){
        return lojaRepository.findByAtivoTrue(paginacao).map(DadosListagemLojaDTO::new);
    }

    @PutMapping
    @Transactional
    public void atualizarDadosLoja(@RequestBody @Valid AtualizacaoLojaDTO atualizacaoLojaDTO){
        var loja = lojaRepository.getReferenceById(atualizacaoLojaDTO.getCodigoLoja());
        loja.atualizarDados(atualizacaoLojaDTO);
    }

    @DeleteMapping("/loja/{id}")
    @Transactional
    public void deletarLoja(@PathVariable Long id){
        var loja = lojaRepository.getReferenceById(id);
        loja.excluirLoja();
    }

}