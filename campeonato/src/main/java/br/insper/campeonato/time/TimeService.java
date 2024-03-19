package br.insper.campeonato.time;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TimeService {

    private ArrayList<Time> times = new ArrayList<>();

    public Time cadastrarTime(Time time) {

        if (time.getIdentificador().equals("")
                || time.getNome().equals("")
                || time.getEstadio().equals("")
                || time.getEstado().equals("")) {
            throw new RuntimeException("Dados inválidos.");
        } else {
            times.add(time);
            return time;
        }

    }

    // Estamos criando uma lista para listar os times, mostrá-la na tela e permitir a busca por nome
    public ArrayList<Time> listarTimes(String estado) { // Listar times com opção de filtragem por estado

        if (estado != null) {
            ArrayList<Time> lista = new ArrayList<>();
            for (Time time : times) {
                if (time.getEstado().startsWith(estado)) {
                    lista.add(time);
                }
            }
            return lista;
        }

        return times;
    }

    public void excluirTimes(String identificador) {
        Time timeRemover = null;

        for (Time time : times) {
            if (identificador.equalsIgnoreCase(time.getIdentificador())) {
                timeRemover = time;
            }
        }
        if (timeRemover != null) {
            times.remove(timeRemover);
        } else {
            throw new RuntimeException("Time não encontrado.");
        }

    }

    public Time getTime(String identificador) { // Rota de busca por identificador
        for (Time time : times) {
            if (time.getIdentificador().equals(identificador)) {
                return time;
            }
        }
        return null;
    }

    public Time buscarTime(String nome) {
        for (Time time : times) {
            if (time.getNome().equals(nome)) {
                return time;
            }
        }
        return null;
    }

}
