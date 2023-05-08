package ControleDeAlunos;

import java.sql.Array;
import java.util.HashSet;
import java.util.Set;

public class Grupo {
    private String grupo;
    private int tamanho;
    private Set<Aluno> alunos;

    /**
     * Instancio pela primeira vez as informações a serem usadas pela classe.
     * @param grupo
     * @param tamanho
     */
    public Grupo(String grupo, int tamanho){
        this.grupo = grupo;
        this.tamanho = tamanho;
        this.alunos = new HashSet<Aluno>();
    }

    /**
     * Crio o metodo de alocação de alunos dentro de grupos.
     * @param aluno
     */
    public void alocarAluno(Aluno aluno){
            this.alunos.add(aluno);
    }

    /**
     * Verifico o estado dos grupos.
     * @return
     */
    public boolean estaCheio(){
        boolean retorno = false;
        if(this.tamanho != -1 && this.alunos.size() == this.tamanho) {
            retorno = true;
        }
        return retorno;
    }

    /**
     * Verifico se um aluno está contido no objeto.
     * @param aluno
     * @return
     */
    public boolean temAluno(Aluno aluno){
        return this.alunos.contains(aluno);
    }

    /**
     * Crio uma exibição dos objetos "Grupo"
     * @return
     */
    public String toString(){
        String tamanho = this.tamanho == -1 ? "ilimitado" : Integer.toString(this.tamanho);
        return this.grupo + " " + this.alunos.size() + "/" + tamanho;
    }
}
