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
        this.retorno2 = controle.cadastrarTime("300_PB", "Treze", "Noia");
        this.retorno3 = controle.cadastrarCampeonato("Campeonato Paraibano 2023", 1);
        this.retorno4 = controle.cadastrarCampeonato("Campeonato Paraibano 2023", 1);
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

    @Test
    void testeIncluirTimeEmCampeonato(){
        String str1 = "TIME INCLUÍDO NO CAMPEONATO!";
        String str2 = "TIME NÃO EXISTE!";
        String str3 = "CAMPEONATO NÃO EXISTE!";
        String str4 = "TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!";

        Assertions.assertEquals(str1, this.controle.incluiTimeEmCampeonato("250_PB", "Campeonato Paraibano 2023"));
        Assertions.assertEquals(str2, this.controle.incluiTimeEmCampeonato("500_PB", "Campeonato Paraibano 2023"));
        Assertions.assertEquals(str3, this.controle.incluiTimeEmCampeonato("300_PB", "Campeonato Paulista 2023"));
        Assertions.assertEquals(str4, this.controle.incluiTimeEmCampeonato("300_PB", "Campeonato Paraibano 2023"));
    }

    @Test
    void testeVerificarTimeEmCampeonato(){
        String str1 = "O TIME ESTÁ NO CAMPEONATO!";
        String str2 = "TIME NÃO EXISTE!";
        String str3 = "CAMPEONATO NÃO EXISTE!";
        String str4 = "O TIME NÃO ESTÁ NO CAMPEONATO!";

        Assertions.assertEquals(str1, this.controle.incluiTimeEmCampeonato("250_PB", "Campeonato Paraibano 2023"));
        Assertions.assertEquals(str2, this.controle.incluiTimeEmCampeonato("500_PB", "Campeonato Paraibano 2023"));
        Assertions.assertEquals(str3, this.controle.incluiTimeEmCampeonato("300_PB", "Campeonato Paulista 2023"));
        Assertions.assertEquals(str4, this.controle.incluiTimeEmCampeonato("300_PB", "Campeonato Paraibano 2023"));
    }
}
