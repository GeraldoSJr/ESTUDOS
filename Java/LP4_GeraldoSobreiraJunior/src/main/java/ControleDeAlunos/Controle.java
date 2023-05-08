package ControleDeAlunos;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Controle {
    private Map<String, Aluno> alunos;
    private ArrayList matriculas;
    private Map<String, Grupo> grupos;

    /**
     * Instacio as coleções que seram usadas pelo controle
     */
    public Controle(){
        alunos = new HashMap<String, Aluno>();
        grupos = new HashMap<String, Grupo>();
    }

    /**
     * Crio o metodo responsavel por cadastrar aluno
     * @param matricula
     * @param nome
     * @param curso
     * @return
     */
    public String cadastraAluno(String matricula, String nome, String curso){
        String retornoCadastro = "MATRICULA JA CADASTRADA.";
        if(!alunos.containsKey(matricula)) {
            Aluno aluno = new Aluno(nome, matricula, curso);
            this.alunos.put(matricula, aluno);
            retornoCadastro = "CADASTRO REALIZADO!";
        }
        return retornoCadastro;
    }

    /**
     * Método responsável por pegar as informações de aluno.
     * @param matricula
     * @return
     */
    public String getAluno(String matricula){
        String alunoStr = "ALUNO NÃO CADASTRADO!";
        Aluno aluno = alunos.get(matricula);
        if(aluno != null) {
            alunoStr = aluno.toString();
        }
        return alunoStr;
    }

    /**
     * Cadastro os novos grupos.
     * @param nomeGrupo
     * @param tamanho
     * @return
     */
    public String cadastraGrupos(String nomeGrupo, int tamanho){
        String retornoCadastro = "GRUPO NÃO CADASTRADO";
        if(!grupos.containsKey(nomeGrupo)){
            Grupo grupo = new Grupo(nomeGrupo, tamanho);
            this.grupos.put(nomeGrupo, grupo);
            retornoCadastro = "CADASTRO REALIZADO";
        }
        return retornoCadastro;
    }

    /**
     * Adiciona os alunos dentro dos seus grupos, e trabalha com possíveis excessões.
     * @param matricula
     * @param nomeGrupo
     * @return
     */
    public String alocarAluno(String matricula, String nomeGrupo){
        String retornoAlocar = "";
        boolean valido = true;
        String vGrupo = verificaGrupo(nomeGrupo);
        String vAluno = verificaAluno(matricula);
        if(vAluno != null){
            retornoAlocar += vAluno;
            valido = false;
        }
        if(vGrupo != null){
            retornoAlocar += vGrupo;
            valido = false;
        }
        if(valido){
            Grupo grupo = this.grupos.get(nomeGrupo);
            Aluno aluno = this.alunos.get(matricula);
            if(grupo.estaCheio()){
                retornoAlocar = "GRUPO CHEIO!";
            }else{
                grupo.alocarAluno(aluno);
                retornoAlocar = "ALUNO ALOCADO!";
            }
        }
        return  retornoAlocar;
    }

    /**
     * Checo se o aluno ainda está dentro do grupo em questão, além de verificar possíveis excessões.
     * @param nomeGrupo
     * @param matricula
     * @return
     */
    public String pertinencia(String nomeGrupo, String matricula){
        String retorno = "";
        String vGrupo = verificaGrupo(nomeGrupo);

        if(vGrupo != null){
            retorno = vGrupo;
        }else{
            Grupo grupo = this.grupos.get(nomeGrupo);
            Aluno aluno = this.alunos.get(matricula);
            if(grupo.temAluno(aluno)){
                retorno = "ALUNO PERTENCE AO GRUPO.";
            }else{
                retorno = "ALUNO NÃO PERTENCE AO GRUPO!";
            }
        }
        return retorno;
    }
    private String verificaGrupo(String nomeGrupo){
        String retornoVerificar = null;
        if(!this.grupos.containsKey(nomeGrupo)){
            retornoVerificar = "GRUPO NÃO CADASTRADO";
        }
        return retornoVerificar;
    }
    private String verificaAluno(String matricula){
        String retornoVerificar = null;
        if(!this.alunos.containsKey(matricula)){
            retornoVerificar = "ALUNO NÃO CADASTRADO";
        }
        return retornoVerificar;
    }

    /**
     * Verifico a permanencia do aluno em grupos e exibo-os em formato de String
     * @param matricula
     * @return
     */
    public String checkagem(String matricula){
        String checkStr = "Grupos:\n";
        Aluno aluno = this.alunos.get(matricula);
        for(Grupo grupo : this.grupos.values()){
            if(grupo.temAluno(aluno)){
                checkStr += "- " + grupo.toString() + "\n";
            }
        }
        return checkStr.trim();
    }
}
