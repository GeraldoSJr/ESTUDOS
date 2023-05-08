import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MrbetTeste {
    private String retorno;
    private String retorno2;
    private String retorno3;
    private String retorno4;
    private Mrbet controle;

    @BeforeEach
    void preparaTestes(){
        this.controle = new Mrbet();
        this.retorno = controle.cadastrarTime("250_PB", "Nacional de Patos", "Canário");
        this.retorno2 = controle.cadastrarTime("250_PB", "Nacional de Patos", "Canário");
        this.retorno3 = controle.cadastrarCampeonato("Campeonato Paraibano 2023", 20);
        this.retorno4 = controle.cadastrarCampeonato("Campeonato Paraibano 2023", 20);
    }

    @Test
    void testeCadastroTime() {
        Assertions.assertEquals(this.retorno, "INCLUSÃO REALIZADA!");
        Assertions.assertEquals(this.retorno2, "TIME JÁ EXISTE!");
    }

    @Test
    void testeStatusTime(){
        String str = "[250_PB] Nacional de Patos / Canário";
        Assertions.assertEquals(str, this.controle.recuperarTime("250_PB"));
    }

    @Test
    void testeCadastraCampeonato(){
        Assertions.assertEquals(this.retorno3, "CAMPEONATO ADICIONADO!");
        Assertions.assertEquals(this.retorno4, "CAMPEONATO JÁ EXISTE!");
    }
}
