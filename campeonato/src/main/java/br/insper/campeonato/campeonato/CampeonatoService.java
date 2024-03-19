package br.insper.campeonato.campeonato;

import br.insper.campeonato.partida.Partida;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CampeonatoService {
    private ArrayList<Campeonato> campeonatos = new ArrayList<>();

    public Campeonato cadastrarCampeonato(Campeonato campeonato) {

        if (campeonato.getIdentificador().equals("")
                || campeonato.getNome().equals("")) {
            throw new RuntimeException("Dados inválidos.");
        } else {
            campeonatos.add(campeonato);
            return campeonato;
        }

    }

    public String buscarCampeonato(String identificador) {
        for (Campeonato campeonato : campeonatos) {
            if (campeonato.getIdentificador().equals(identificador)) {
                return campeonato.getNome();
            }
        }
        return null;
    }

}
