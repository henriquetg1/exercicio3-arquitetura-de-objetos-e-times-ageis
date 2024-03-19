package br.insper.campeonato.partida;

import br.insper.campeonato.campeonato.CampeonatoService;
import br.insper.campeonato.time.Time;
import br.insper.campeonato.time.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PartidaService {


    @Autowired
    private TimeService timeService;

    @Autowired
    private CampeonatoService campeonatoService;

    private ArrayList<Partida> partidas = new ArrayList<>();

    public Partida cadastrarPartida(Partida partida) {
        // Cadastro de partida que verifica se os dados são válidos e se os times existem.
        if (partida.getIdentificadorCampeonato().equals("")
                || partida.getTimeMandante().equals("")
                || partida.getTimeVisitante().equals("")
                || partida.getPlacarMandante() == null
                || partida.getPlacarVisitante() == null) {
            throw new RuntimeException("Dados inválidos.");
        }
        else if (timeService.buscarTime(partida.getTimeMandante()) == null || timeService.buscarTime(partida.getTimeVisitante()) == null) {
            throw new RuntimeException("Time não encontrado.");
        }
        else if (campeonatoService.buscarCampeonato(partida.getIdentificadorCampeonato()) == null) {
            throw new RuntimeException("Campeonato não encontrado.");
        } else if (partida.getPlacarMandante() < 0 || partida.getPlacarVisitante() < 0) {
            throw new RuntimeException("Placar inválido.");
        } else if (partida.getTimeMandante().equals(partida.getTimeVisitante())) {
            throw new RuntimeException("Times iguais.");
        }
        else {
            partidas.add(partida);
            return partida;
        }
    }



    // Listar partidas com opção de filtragem por campeonato ou por time mandante
    public ArrayList<Partida> listarPartidasMandante(String timeMandante) {
        if (timeMandante != null) {
            ArrayList<Partida> lista = new ArrayList<>();
            for (Partida partida : partidas) {
                if (partida.getTimeMandante().equalsIgnoreCase(timeMandante)) {
                    lista.add(partida);
                }
            }
            return lista;
        }
        return partidas;
    }

    public ArrayList<Partida> listarPartidasCampeonato(String identificadorCampeonato) {
        if (identificadorCampeonato != null) {
            ArrayList<Partida> lista = new ArrayList<>();
            for (Partida partida : partidas) {
                if (partida.getIdentificadorCampeonato().equalsIgnoreCase(identificadorCampeonato)) {
                    lista.add(partida);
                }
            }
            return lista;
        }
        return partidas;
    }

    public Integer calcularVitoriasTime(String time) {
        Integer vitorias = 0;
        for (Partida partida : partidas) {
            // Time ser mandante e ter vencido
            if (partida.getTimeMandante().equals(time) && partida.getPlacarMandante() > partida.getPlacarVisitante()) {
                vitorias++;
            }
            // Time ser visitante e ter vencido
            else if (partida.getTimeVisitante().equals(time) && partida.getPlacarVisitante() > partida.getPlacarMandante()) {
                vitorias++;
            }
        }
        return vitorias;
    }

}
