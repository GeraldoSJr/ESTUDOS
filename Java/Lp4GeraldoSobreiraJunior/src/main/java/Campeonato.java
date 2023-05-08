public class Campeonato {
    private String campeonato;
    private int participantes;

    public Campeonato(String campeonato, int participantes){
        this.campeonato = campeonato;
        this.participantes = participantes;
    }

    public int getParticipantes() {
        return participantes;
    }

    public String getCampeonato() {
        return this.campeonato;
    }
}
