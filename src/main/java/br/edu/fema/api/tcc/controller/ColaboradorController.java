package br.edu.fema.api.tcc.controller;

import br.edu.fema.api.tcc.cargos.model.CargosModel;
import br.edu.fema.api.tcc.cargos.repository.CargosRepository;
import br.edu.fema.api.tcc.colaborador.dto.AtualizarDadosColaboradores;
import br.edu.fema.api.tcc.colaborador.dto.DadosColaboradoresDTO;
import br.edu.fema.api.tcc.colaborador.dto.DadosListaColaboradoresDTO;
import br.edu.fema.api.tcc.colaborador.model.ColaboradorModel;
import br.edu.fema.api.tcc.colaborador.repository.ColaboradorRepository;
import jakarta.persistence.EntityNotFoundException;
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
    @Autowired
    private CargosRepository cargosRepository;

    public ColaboradorController(ColaboradorRepository colaboradorRepository,
                                 CargosRepository cargosRepository){
        this.colaboradorRepository = colaboradorRepository;
        this.cargosRepository = cargosRepository;
    }

    @PostMapping
    @Transactional
   public ColaboradorModel salvar(@RequestBody DadosColaboradoresDTO dadosColaboradoresDTO){
        CargosModel cargo = cargosRepository.findById(dadosColaboradoresDTO.getCargo().getCodigoCargo())
                .orElseThrow(() -> new EntityNotFoundException("Cargo não encontrado"));

       ColaboradorModel colaborador = new ColaboradorModel();
       colaborador.setNomeColaborador(dadosColaboradoresDTO.getNomeColaborador());
       colaborador.setCpf(dadosColaboradoresDTO.getCpf());
       colaborador.setTelefone(dadosColaboradoresDTO.getTelefone());
       colaborador.setDataAdmissao(dadosColaboradoresDTO.getDataAdmissao());
       colaborador.setCargo(cargo);
       colaborador.setAtivo(true);
       return colaboradorRepository.save(colaborador);
   }

   //@PostMapping
   //@Transactional
   //public void cadastroDeColaborador(@RequestBody DadosColaboradoresDTO colaboradoresDTO){
   //    colaboradorRepository.save(new ColaboradorModel(colaboradoresDTO));
   //    System.out.println(colaboradoresDTO.toString());
   //}

  // @GetMapping
  // public List<DadosListaColaboradoresDTO> listarColaboradores(){
  //     return colaboradorRepository.findByAtivoTrue().stream().map(DadosListaColaboradoresDTO::new).toList();
  // }

   // @GetMapping
    //public List<ColaboradorModel> listarColaboradores(){
      //  return colaboradorRepository.findByAtivoTrue();
    //}

    @GetMapping
    public List<DadosListaColaboradoresDTO> listarColaboradores(){
        return colaboradorRepository.findByAtivoTrue().stream().map(DadosListaColaboradoresDTO::new).toList();
    }

    @GetMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<ColaboradorModel> buscarPorId(@PathVariable Long id){
        return colaboradorRepository.findById(id);
    }

  //@PutMapping("{id}")
  //@Transactional
  //public void atualizarDadosColaborador(@RequestBody @Valid AtualizarDadosColaboradores atualizarColadoradores ){
  //    var colaborador = colaboradorRepository.getReferenceById(atualizarColadoradores.getCodigoColaborador());
  //    colaborador.atualizarDados(atualizarColadoradores);
  //}
  @PutMapping("{id}")
  @Transactional
  public ColaboradorModel atualizarDadosColaborador(@RequestBody AtualizarDadosColaboradores atualizarColaboradoresDTO){
      CargosModel cargo = cargosRepository.findById(atualizarColaboradoresDTO.getCargo().getCodigoCargo())
              .orElseThrow(() -> new EntityNotFoundException("Cargo não encontrado"));

      ColaboradorModel colaborador = colaboradorRepository.getReferenceById(atualizarColaboradoresDTO.getCodigoColaborador());
      colaborador.setNomeColaborador(atualizarColaboradoresDTO.getNomeColaborador());
      colaborador.setTelefone(atualizarColaboradoresDTO.getTelefone());
      colaborador.setCargo(cargo);
      colaborador.setAtivo(true);
      return colaboradorRepository.save(colaborador);
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
