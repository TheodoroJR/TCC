package br.edu.fema.api.tcc.controller;

import br.edu.fema.api.tcc.cargos.dto.AtualizarDadosCargos;
import br.edu.fema.api.tcc.cargos.dto.DadosCargosDTO;
import br.edu.fema.api.tcc.cargos.dto.DadosListaCargoDTO;
import br.edu.fema.api.tcc.cargos.model.CargosModel;
import br.edu.fema.api.tcc.cargos.repository.CargosRepository;
import br.edu.fema.api.tcc.risco.model.RiscoModel;
import br.edu.fema.api.tcc.risco.repository.RiscoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cargos")
@CrossOrigin("http://localhost:4200")
public class CargosController {

    @Autowired
    private final CargosRepository cargosRepository;
    @Autowired
    private final RiscoRepository riscoRepository;

    public CargosController(CargosRepository cargosRepository,
                            RiscoRepository riscoRepository) {
        this.cargosRepository = cargosRepository;
        this.riscoRepository = riscoRepository;
    }


//metodo final
    @PostMapping
    @Transactional
    public CargosModel salvar(@RequestBody DadosCargosDTO dadosCargosDTO){
        List<RiscoModel> riscosAssociados = new ArrayList<>();

        for (RiscoModel riscoDTO : dadosCargosDTO.getRiscosCargos()) {
            RiscoModel risco = riscoRepository.findById(riscoDTO.getCodigoRisco())
                    .orElseThrow(() -> new EntityNotFoundException("Risco não encontrado"));
            riscosAssociados.add(risco);
        }

        CargosModel cargo = new CargosModel();
        cargo.setNomeCargo(dadosCargosDTO.getNomeCargo());
        cargo.setRiscosCargos(riscosAssociados);
        cargo.setAtivo(true);
        return cargosRepository.save(cargo);
    }

  // @PostMapping metodo inicial verificar o erro de não associar o risco com o cargo no BD
  // @Transactional
  // public CargosModel salvar(@RequestBody DadosCargosDTO dadosCargosDTO){
  //     List<RiscoModel> codRisco = dadosCargosDTO.getRiscosCargos();

  //     CargosModel cargo = new CargosModel();
  //     cargo.setNomeCargo(dadosCargosDTO.getNomeCargo());
  //     cargo.setRiscosCargos(dadosCargosDTO.getRiscosCargos());
  //     cargo.setAtivo(true);
  //     return cargosRepository.save(cargo);
  // }

   //@PostMapping
   //@Transactional
   //public void cadastroDeCargo(@RequestBody DadosCargosRecord cargoDTO){
   //   Long codigosRiscos = cargoDTO.riscoModels().get();


   //    cargosRepository.save(new CargosModel(cargoDTO));
   //    System.out.println(cargoDTO.toString());
   //}

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

    @PutMapping("{id}")
    @Transactional
    public CargosModel atualizarDadosCargos(@RequestBody @Valid AtualizarDadosCargos atualizarDadosCargos){
        List<RiscoModel> riscosAssociados = new ArrayList<>();
        CargosModel cargo = cargosRepository.getReferenceById(atualizarDadosCargos.getCodigoCargo());
        cargo.setNomeCargo(atualizarDadosCargos.getNomeCargo());
        cargo.setRiscosCargos(riscosAssociados);
        cargo.atualizarDados(atualizarDadosCargos);
        return cargosRepository.save(cargo);
    }

    @DeleteMapping("/cargo/{id}")
    @Transactional
    public void deletarCargo(@PathVariable Long id){
        var cargo = cargosRepository.getReferenceById(id);
        cargo.excluirCargo();
    }
}
