import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MrbetTeste {
    private String retorno;
    private String retorno2;
    private String retorno3;
    private String retorno4;
    private String retorno5;
    private String retorno6;
    private Mrbet controle;

    @BeforeEach
    void preparaTestes(){
        this.controle = new Mrbet();
        this.retorno = controle.cadastrarTime("250_PB", "Nacional de Patos", "Canário");
        this.retorno2 = controle.cadastrarTime("252_PB", "Sport Lagoa Seca", "Carneiro");
        this.retorno3 = controle.cadastrarTime("255_PB", "Treze", "Noia");
        this.retorno4 = controle.cadastrarTime("002_RJ", "Clube de Regatas do Flamengo", "Urubu");
        this.retorno5 = controle.cadastrarCampeonato("Campeonato Brasileirão Serie A 2023", 1);
        this.retorno6 = controle.cadastrarCampeonato("Campeonato Brasileirão Serie A 2023", 1);
    }

    @Test
    void testeCadastraCampeonato1(){
        Assertions.assertEquals(this.retorno3, "CAMPEONATO ADICIONADO!");
    }

    @Test
    void testeCadastraCampeonato2(){
        Assertions.assertEquals(this.retorno4, "CAMPEONATO JÁ EXISTE!");
    }

    @Test
    void testeIncluirTimeEmCampeonato(){
        String str1 = "TIME INCLUÍDO NO CAMPEONATO!";

        Assertions.assertEquals(str1, this.controle.incluiTimeEmCampeonato("250_PB", "Campeonato Brasileirão Serie A 2023"));
        Assertions.assertEquals(str1, this.controle.incluiTimeEmCampeonato("252_PB", "Campeonato Brasileirão Serie A 2023"));
        Assertions.assertEquals(str1, this.controle.incluiTimeEmCampeonato("252_PB", "Campeonato Brasileirão Serie A 2023"));
    }

    @Test
    void testeIncluirTimeEmCampeonato2(){
        String str1 = "TIME NÃO EXISTE!";

        Assertions.assertEquals(str1, this.controle.incluiTimeEmCampeonato("500_PB", "Campeonato Brasileirão Serie A 2023"));
        Assertions.assertEquals(str1, this.controle.incluiTimeEmCampeonato("252_PB", "Campeonato Brasileirão Serie A 2023"));
    }

    @Test
    void testeIncluirTimeEmCampeonato3(){
        String str1 = "CAMPEONATO NÃO EXISTE!";

        Assertions.assertEquals(str1, this.controle.incluiTimeEmCampeonato("250_PB", "Campeonato Paraibano 2023"));
        Assertions.assertEquals(str1, this.controle.incluiTimeEmCampeonato("252_PB", "Campeonato Paraibano 2023"));
    }

    @Test
    void testeIncluirTimeEmCampeonato4(){
        String str1 = "TIME INCLUÍDO NO CAMPEONATO!";
        String str2 = "TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!";

        Assertions.assertEquals(str1, this.controle.incluiTimeEmCampeonato("250_PB", "Campeonato Brasileirão Serie A 2023"));
        Assertions.assertEquals(str2, this.controle.incluiTimeEmCampeonato("252_PB", "Campeonato Brasileirão Serie A 2023"));
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

    @Test
    void testeVerificarTimeEmCampeonato2(){
        String str1 = "TIME NÃO EXISTE!";

        Assertions.assertEquals(str1, this.controle.incluiTimeEmCampeonato("500_PB", "Campeonato Brasileirão Serie A 2023"));
        Assertions.assertEquals(str1, this.controle.incluiTimeEmCampeonato("252_PB", "Campeonato Brasileirão Serie A 2023"));
    }

    @Test
    void testeVerificarTimeEmCampeonato3(){
        String str1 = "CAMPEONATO NÃO EXISTE!";

        Assertions.assertEquals(str1, this.controle.verificaTimeEmCampeonato("250_PB", "Campeonato Paraibano 2023"));
        Assertions.assertEquals(str1, this.controle.verificaTimeEmCampeonato("252_PB", "Campeonato Paraibano 2023"));
    }
}
