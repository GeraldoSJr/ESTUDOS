package lp2;

/**
 * Constroi uma estrutura que monitora o tempo passado na internet .
 * Monitora as horas passadas online por disciplina e verifica a relação com a meta.
 *
 * @param Disciplinas controla quais disciplinas são estudadas pelo aluno.
 * @param Horas recebe horas passadas nessa atividade.
 * @param Meta recebe  quantas horas dveriam ser passadas nessa atividade.
 *
 */

public class RegistroTempoOnline {
    private String nomeDisciplina;
    private int tempoEsperado;
    private int tempoOnline;
    private boolean metaOnline;

    public RegistroTempoOnline(String nomeDisciplina){
        this.nomeDisciplina = nomeDisciplina;
        this.tempoEsperado = 120;
    }
    public RegistroTempoOnline(String nomeDisciplina, int tempoEsperado){
        this.nomeDisciplina = nomeDisciplina;
        this.tempoEsperado = tempoEsperado;
        this.tempoOnline = tempoOnline;
    }

    public void adicionaTempoOnline(int tempoOnline) {
        this.tempoOnline += tempoOnline;
    }

    public boolean atingiuMetaTempoOnline() {
        if(this.tempoOnline >= this.tempoEsperado){
            this.metaOnline = true;
        }
        return metaOnline;
    }
    public String toString(){
        return nomeDisciplina + " " + tempoOnline + "/" + tempoEsperado;
    }
}
