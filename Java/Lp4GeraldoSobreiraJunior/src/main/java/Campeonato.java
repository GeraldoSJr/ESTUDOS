import java.util.ArrayList;

public class Campeonato {
    private String campeonato;
    private final int participantes;
    private int index = 0;
    private int participantesAtuais = 0;
    private Time[] times;

    public Campeonato(String campeonato, int participantes){
        this.campeonato = campeonato;
        this.participantes = participantes;
        this.times = new Time[participantes];
    }

    public int participantesDisponiveis() {
        return participantes - participantesAtuais;
    }

    public void addParticipantes(){
        if(participantesDisponiveis() != 0) {
            this.participantesAtuais += 1;
            this.index += 1;
        }
    }

    public Time[] getTimes(){
        return times;
    }

    public String getCampeonato() {
        return this.campeonato;
    }

    public int getIndex() {
        return index;
    }

    public int getParticipantes() {
        return participantes;
    }
}
