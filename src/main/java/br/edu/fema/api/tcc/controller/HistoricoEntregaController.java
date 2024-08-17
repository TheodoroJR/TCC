package br.edu.fema.api.tcc.controller;

import br.edu.fema.api.tcc.cargos.dto.DadosListaCargoDTO;
import br.edu.fema.api.tcc.colaborador.dto.DadosListaColaboradoresDTO;
import br.edu.fema.api.tcc.colaborador.model.ColaboradorModel;
import br.edu.fema.api.tcc.colaborador.repository.ColaboradorRepository;
import br.edu.fema.api.tcc.epi.model.EpiModel;
import br.edu.fema.api.tcc.epi.repository.EpiRepository;
import br.edu.fema.api.tcc.histentrega.dto.DadosListHistEntregaDTO;
import br.edu.fema.api.tcc.histentrega.model.HistoricoEntregaModel;
import br.edu.fema.api.tcc.histentrega.model.repository.HistoricoEntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/entregas-epi")
@CrossOrigin("http://localhost:4200")
public class HistoricoEntregaController {

    @Autowired
    private final EpiRepository epiRepository;
    @Autowired
    private final ColaboradorRepository colaboradorRepository;
    @Autowired
    private final HistoricoEntregaRepository historicoEntregaRepository;

    public HistoricoEntregaController(EpiRepository epiRepository, ColaboradorRepository colaboradorRepository,
                                      HistoricoEntregaRepository historicoEntregaRepository){
        this.epiRepository = epiRepository;
        this.colaboradorRepository = colaboradorRepository;
        this.historicoEntregaRepository = historicoEntregaRepository;
    }

    @GetMapping
    @Transactional
    public List<HistoricoEntregaModel> listar(){
        return historicoEntregaRepository.findAll();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<HistoricoEntregaModel> entregaDeEpi(@RequestBody DadosListHistEntregaDTO dadosListHistEntregaDTO){
        System.out.println("Entrou no metodo.");
        // EpiModel epiModel = epiRepository.findById(codigoEpi).orElseThrow(()-> new RuntimeException("EPI NÃO ENCONTRADO"));
        // ColaboradorModel colaboradorModel = colaboradorRepository.findById(codigoColaborador).orElseThrow(()-> new RuntimeException("COLABORADOR NÃO ENCONTRADO"));
        // colaboradorModel.getEpis().add(epiModel);
        System.out.println("Entrega Realizada!");

        HistoricoEntregaModel historicoEntregaModel = new HistoricoEntregaModel(dadosListHistEntregaDTO);
        historicoEntregaRepository.save(historicoEntregaModel);
        Optional<ColaboradorModel> colaboradorOptional = colaboradorRepository.findById(dadosListHistEntregaDTO.getColaboradorId());
        if(colaboradorOptional.isPresent()){
            ColaboradorModel colaborador = colaboradorOptional.get();
            if (colaborador.getEpis() == null) {
                colaborador.setListaEpis(new ArrayList<>());
            }
            for (EpiModel epi : dadosListHistEntregaDTO.getEpis()) {
                colaborador.getEpis().add(epi);}
           // colaborador.getListaEpis().add((EpiModel) dadosListHistEntregaDTO.getEpis());
            colaboradorRepository.save(colaborador);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(historicoEntregaModel);
        //recuperar o colaborador - adicionar o epi novo na lista e salvar o colaborador
    }

    //IMPLEMENTAR A CLASSE DTO PARA MONTAR A REQUISIÇÃO NO SWAGGER
    //IMPLEMENTAR A CLASSE DTO PARA MONTAR A REQUISIÇÃO NO SWAGGER

}
