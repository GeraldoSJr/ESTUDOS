package lp2;

/**
 * Constrói uma estrutura que monitora os momentos de descanso ativo do aluno.
 * Monitora as horas por semana passadas em descanso.
 *
 * @param Semanas recebe as semanas passadas nessa atividade.
 * @param Horas recebe as horas passados nessa atividade.
 *
 */

public class Descanso {
    private int horasDescanso;
    private int numeroSemanas;
    private String statusGeral;
    private double media;

    public Descanso(){
        this.horasDescanso = horasDescanso;
        this.numeroSemanas = numeroSemanas;
    }

    public void defineHorasDescanso(int horasDescanso) {
        this.horasDescanso = horasDescanso;
    }

    public void defineNumeroSemanas(int numeroSemanas) {
        this.numeroSemanas = numeroSemanas;
    }

    public String getStatusGeral() {
        if(this.numeroSemanas > 0) {
            this.media = this.horasDescanso / this.numeroSemanas;
        }
        if (this.media < 15) {
            return this.statusGeral = "Cansado";
        } else {
            return this.statusGeral = "Descansado";
        }
    }
}
