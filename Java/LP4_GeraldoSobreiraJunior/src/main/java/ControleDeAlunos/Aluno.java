package ControleDeAlunos;

public class Aluno {
    private String nome;
    private String matricula;
    private String curso;

    /**
     * Instancio pela primeira vez as informações a serem usadas pela classe.
     * @param nome
     * @param matricula
     * @param curso
     */
    public Aluno(String nome, String matricula, String curso){
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

    /**
     * Crio uma exibição dos objetos "Aluno".
     * @return
     */
    public String toString(){
       return matricula + " - " + nome + " - " + curso;
    }

}