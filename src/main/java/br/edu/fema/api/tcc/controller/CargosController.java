package br.edu.fema.api.tcc.controller;

import br.edu.fema.api.tcc.cargos.dto.AtualizarDadosCargos;
import br.edu.fema.api.tcc.cargos.dto.DadosCargosRecord;
import br.edu.fema.api.tcc.cargos.dto.DadosListaCargoDTO;
import br.edu.fema.api.tcc.cargos.model.CargosModel;
import br.edu.fema.api.tcc.cargos.repository.CargosRepository;
import br.edu.fema.api.tcc.colaborador.model.ColaboradorModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cargos")
@CrossOrigin("http://localhost:4200")
public class CargosController {

    @Autowired
    private CargosRepository cargosRepository;

    @PostMapping
    @Transactional
    public void cadastroDeCargo(@RequestBody DadosCargosRecord cargoDTO){
        cargosRepository.save(new CargosModel(cargoDTO));
        System.out.println(cargoDTO.toString());
    }

    @GetMapping
    public List<DadosListaCargoDTO> listarCargos(){
        return cargosRepository.findByAtivoTrue().stream().map(DadosListaCargoDTO::new).toList();
    }

    //@GetMapping
    //public List<CargosModel> listarCargos(){
      //  return cargosRepository.findByAtivoTrue();
    //}

    @GetMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<CargosModel> buscarPorId(@PathVariable Long id){
        return cargosRepository.findById(id);
    }

    @PutMapping
    @Transactional
    public void atualizarDadosCargos(@RequestBody @Valid AtualizarDadosCargos atualizarDadosCargos){
        var cargo = cargosRepository.getReferenceById(atualizarDadosCargos.getCodigoCargo());
        cargo.atualizarDados(atualizarDadosCargos);
    }

    @DeleteMapping("/cargo/{id}")
    @Transactional
    public void deletarCargo(@PathVariable Long id){
        var cargo = cargosRepository.getReferenceById(id);
        cargo.excluirCargo();
    }
}
