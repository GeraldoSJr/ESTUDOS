package ControleDeAlunosTests;

import ControleDeAlunos.Aluno;
import ControleDeAlunos.Controle;
import ControleDeAlunos.Grupo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControleMainTest {
    private Aluno aluno;
    private Controle controle;
    private Grupo grupo;

    @BeforeEach
    void preparo(){
        aluno = new Aluno("Geraldo", "250", "CC");
        controle = new Controle();
        grupo = new Grupo("Listas", 10);
        controle.cadastraAluno("250", "Geraldo", "CC");
        controle.cadastraAluno("320", "Pedro", "CC");
        controle.cadastraGrupos("LP2", 10);
        controle.alocarAluno("250", "LP2");
    }
    @Test
    void cadastroAlunoTest(){
        String msg1 = "CADASTRO REALIZADO!";
        assertEquals(msg1, controle.cadastraAluno("260", "Joao", "CC"));
    }
    @Test
    void consultarAlunoTest(){
        String msg = "250 - Geraldo - CC";
        String msg2 = "ALUNO NÃO CADASTRADO!";
        assertEquals(msg, controle.getAluno("250"));
        assertEquals(msg2, controle.getAluno("2500"));
    }
    @Test
    void cadastraGruposTest(){
        String msg = "CADASTRO REALIZADO";
        assertEquals(msg, controle.cadastraGrupos("Listas", 10));
    }
    @Test
    void alocarAlunosTest(){
        String msg = "ALUNO ALOCADO!";
        String msg2 = "GRUPO NÃO CADASTRADO";
        String msg3 = "ALUNO NÃO CADASTRADO";
        assertEquals(msg, controle.alocarAluno("250", "LP2"));
        assertEquals(msg2, controle.alocarAluno("250", "EDA"));
        assertEquals(msg3, controle.alocarAluno("25000", "LP2"));
    }
    @Test
    void verificarPertinenciaTest(){
        String msg = "ALUNO PERTENCE AO GRUPO.";
        String msg2 = "ALUNO NÃO PERTENCE AO GRUPO!";
        assertEquals(msg, controle.pertinencia("LP2", "250"));
        assertEquals(msg2, controle.pertinencia("LP2", "320"));
    }
    @Test
    void checkagemTest(){
        String msg = "Grupos:\n- LP2 1/10";
        assertEquals(msg, controle.checkagem("250"));
    }
}