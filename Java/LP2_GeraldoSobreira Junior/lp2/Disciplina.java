package lp2;

/**
 * Constrói uma estrutura de  que monitora a produtividade do aluno nas disciplinas.
 * Gerencia as disciplinas, assim como as horas, notas e provas, passadas nelas.
 *
 * @param Disciplinas controla quais disciplinas são estudadas pelo aluno.
 * @param Horas recebe horas passadas nessa atividade.
 * @param Notas monitora as notas do aluno na prova.
 * @param Provas recebe quantas provas foram feiras.
 * @param Media calcula se o aluno passou na disciplina em questão.
 *
 */

import java.util.Arrays;

public class Disciplina {
    private String nomeDisciplina;
    private int horasEstudo;
    private double nota;
    private int prova;
    private boolean status;
    double[] notas = new double[4];
    double media;
    double soma = 0;
    int i =0;

    public Disciplina(String nomeDisciplina){
        this.nomeDisciplina = nomeDisciplina;
    }

    public void cadastraHoras(int horasEstudo) {
        this.horasEstudo = horasEstudo;
    }

    public void cadastraNota(int prova, double nota) {
        this.nota = nota;
        this.prova = prova;
        notas[i] = nota;
        soma += nota;
        i += 1;
    }
    public boolean aprovado(){
        media = soma / notas.length;
        if(media >= 7.0){
            this.status = true;
        }
        return this.status;
    }
    public String toString(){
        return this.nomeDisciplina + " " + this.prova + " " + media + " " + Arrays.toString(notas);
    }
}
