package br.edu.fema.api.tcc.controller;

import br.edu.fema.api.tcc.cargos.dto.AtualizarDadosCargos;
import br.edu.fema.api.tcc.cargos.dto.DadosCargosRecord;
import br.edu.fema.api.tcc.cargos.dto.DadosListaCargoDTO;
import br.edu.fema.api.tcc.cargos.model.CargosModel;
import br.edu.fema.api.tcc.colaborador.dto.AtualizarDadosColaboradores;
import br.edu.fema.api.tcc.colaborador.dto.DadosColaboradoresDTO;
import br.edu.fema.api.tcc.colaborador.dto.DadosListaColaboradoresDTO;
import br.edu.fema.api.tcc.colaborador.model.ColaboradorModel;
import br.edu.fema.api.tcc.colaborador.repository.ColaboradorRepository;
import br.edu.fema.api.tcc.epi.model.EpiModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/colaboradores")
@CrossOrigin("http://localhost:4200")
public class ColaboradorController {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @PostMapping
    @Transactional
    public void cadastroDeColaborador(@RequestBody DadosColaboradoresDTO colaboradoresDTO){
        colaboradorRepository.save(new ColaboradorModel(colaboradoresDTO));
        System.out.println(colaboradoresDTO.toString());
    }

  // @GetMapping
  // public List<DadosListaColaboradoresDTO> listarColaboradores(){
  //     return colaboradorRepository.findByAtivoTrue().stream().map(DadosListaColaboradoresDTO::new).toList();
  // }

   // @GetMapping
    //public List<ColaboradorModel> listarColaboradores(){
      //  return colaboradorRepository.findByAtivoTrue();
    //}

    @GetMapping
    public List<DadosListaColaboradoresDTO> listarCargos(){
        return colaboradorRepository.findByAtivoTrue().stream().map(DadosListaColaboradoresDTO::new).toList();
    }

    @GetMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<ColaboradorModel> buscarPorId(@PathVariable Long id){
        return colaboradorRepository.findById(id);
    }

    @PutMapping
    @Transactional
    public void atualizarDadosColaborador(@RequestBody @Valid AtualizarDadosColaboradores atualizarColadoradores ){
        var colaborador = colaboradorRepository.getReferenceById(atualizarColadoradores.getCodigoColaborador());
        colaborador.atualizarDados(atualizarColadoradores);
    }

    @DeleteMapping("/colaborador/{id}")
    @Transactional
    public void deletarColaborador(@PathVariable Long id){
        var colaborador = colaboradorRepository.getReferenceById(id);
        colaborador.excluirColaborador();
    }

    @PutMapping ("/ativar/{id}")
    @Transactional
    public void ativarColaborador(@PathVariable Long id ){
        var colaborador = colaboradorRepository.getReferenceById(id);
        colaborador.ativarColaborador();
    }

}
