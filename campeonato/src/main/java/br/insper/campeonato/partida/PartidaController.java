package br.insper.campeonato.partida;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PartidaController {

    @Autowired
    private PartidaService partidaService;

    @GetMapping("/partida")
    public ArrayList<Partida> getPartidas(@RequestParam(required = false) String timeMandante) {
        return partidaService.listarPartidasMandante(timeMandante);
    }

    @PostMapping("/partida")
    public Partida salvarPartida(@RequestBody Partida partida) {
        return partidaService.cadastrarPartida(partida);
    }

    @GetMapping("/vitorias")
    public Integer getVitorias(@RequestParam(required = false) String time) {
        return partidaService.calcularVitoriasTime(time);
    }
}
