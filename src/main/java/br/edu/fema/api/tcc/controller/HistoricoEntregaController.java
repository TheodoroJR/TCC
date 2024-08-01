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
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entregas-epi")
public class HistoricoEntregaController {

    private final EpiRepository epiRepository;
    private final ColaboradorRepository colaboradorRepository;
    private final HistoricoEntregaRepository historicoEntregaRepository;

    public HistoricoEntregaController(EpiRepository epiRepository, ColaboradorRepository colaboradorRepository, HistoricoEntregaRepository historicoEntregaRepository){
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
        return ResponseEntity.ok(historicoEntregaModel);
    }

    //IMPLEMENTAR A CLASSE DTO PARA MONTAR A REQUISIÇÃO NO SWAGGER
    //IMPLEMENTAR A CLASSE DTO PARA MONTAR A REQUISIÇÃO NO SWAGGER

}
