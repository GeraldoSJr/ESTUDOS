package LulaTestes;

import Lula.Comitivas;
import Lula.Local;
import Lula.LulaController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalTest {
    Local local;
    Comitivas comitivas;
    LulaController main = new LulaController();
    @BeforeEach
    void defineDados(){
        main.CAD_LOCAL("CN", "Departamento de Sistemas e Computação", "1120");
        main.CAD_COMITIVA(0, "Alunos Concluintes do IFPB", 10, "99565678");
    }

    @Test
    void cadastraLocal(){
        local = new Local("CN", "Departamento de Sistemas e Computação", "1120");
        assertNotNull(local);
    }
    @Test
    void cadastraComitiva(){
        comitivas = new Comitivas(0, "Alunos Concluintes do IFPB", 10, "99565678");
        assertNotNull(comitivas);
    }
    @Test
    void testExibeLocal(){
        String exibe = "CN - Departamento de Sistemas e Computação - 1120";
        assertEquals(exibe, main.EXIBE_LOCAL("CN"));
    }
    @Test
    void testExibeComitiva(){
        String exibe = "ID: 0\nComitiva: Alunos Concluintes do IFPB\nIntegrantes: 10\nContato: 99565678";
        assertEquals(exibe, main.EXIBE_COMITIVA(0));
    }
}