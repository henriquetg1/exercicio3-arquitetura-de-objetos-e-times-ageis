package br.insper.campeonato.campeonato;

import br.insper.campeonato.partida.Partida;
import br.insper.campeonato.partida.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CampeonatoController {

    @Autowired
    private CampeonatoService campeonatoService;

    @Autowired
    private PartidaService partidaService;

    @GetMapping("/partida/campeonato")
    public ArrayList<Partida> getPartidasCampeonatos(@RequestParam(required = false) String identificadorCampeonato) {
        return partidaService.listarPartidasCampeonato(identificadorCampeonato);
    }

    @PostMapping("/campeonato")
    public Campeonato salvarCampeonato(@RequestBody Campeonato campeonato) {
        return campeonatoService.cadastrarCampeonato(campeonato);
    }




}
