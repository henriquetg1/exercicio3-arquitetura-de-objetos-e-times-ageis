package br.insper.campeonato.partida;

public class Partida {
    private String timeMandante;
    private String timeVisitante;
    private Integer placarMandante;
    private Integer placarVisitante;
    private String identificadorCampeonato;

    public Partida(String timeMandante, String timeVisitante, Integer placarMandante, Integer placarVisitante, String identificadorCampeonato) {
        this.timeMandante = timeMandante;
        this.timeVisitante = timeVisitante;
        this.placarMandante = placarMandante;
        this.placarVisitante = placarVisitante;
        this.identificadorCampeonato = identificadorCampeonato;
    }

    public String getTimeMandante() {
        return timeMandante;
    }

    public void setTimeMandante(String timeMandante) {
        this.timeMandante = timeMandante;
    }

    public String getTimeVisitante() {
        return timeVisitante;
    }

    public void setTimeVisitante(String timeVisitante) {
        this.timeVisitante = timeVisitante;
    }

    public Integer getPlacarMandante() {
        return placarMandante;
    }

    public void setPlacarMandante(Integer placarMandante) {
        this.placarMandante = placarMandante;
    }

    public Integer getPlacarVisitante() {
        return placarVisitante;
    }

    public void setPlacarVisitante(Integer placarVisitante) {
        this.placarVisitante = placarVisitante;
    }

    public String getIdentificadorCampeonato() {
        return identificadorCampeonato;
    }

    public void setIdentificadorCampeonato(String identificadorCampeonato) {
        this.identificadorCampeonato = identificadorCampeonato;
    }
}
