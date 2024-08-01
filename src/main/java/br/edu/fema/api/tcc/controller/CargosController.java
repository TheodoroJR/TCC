package br.edu.fema.api.tcc.controller;

import br.edu.fema.api.tcc.cargos.dto.AtualizarDadosCargos;
import br.edu.fema.api.tcc.cargos.dto.DadosCargosRecord;
import br.edu.fema.api.tcc.cargos.dto.DadosListaCargoDTO;
import br.edu.fema.api.tcc.cargos.model.CargosModel;
import br.edu.fema.api.tcc.cargos.repository.CargosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargos")
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
        return cargosRepository.findAll().stream().map(DadosListaCargoDTO::new).toList();
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
