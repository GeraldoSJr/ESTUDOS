import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CampeonatoTeste {
    private Campeonato controle1;
    private Campeonato controle2;
    private Campeonato controle3;

    @BeforeEach
    void preparaCampeonato(){
        controle1 = new Campeonato("Campeonato Brasileirão Serie A 2023", 10);
        controle2 = new Campeonato("Campeonato Brasileirão Serie B 2023", 100);
        controle3 = new Campeonato("Campeonato Copa do Brasil 2023", 1);
    }

    @Test
    void getParticipantesTeste(){
        Assertions.assertEquals(10, controle1.getParticipantes());
        Assertions.assertEquals(100, controle2.getParticipantes());
        Assertions.assertEquals(1, controle3.getParticipantes());
    }
    @Test
    void getCampeonatoTeste(){
        Assertions.assertEquals("Campeonato Brasileirão Serie A 2023", controle1.getCampeonato());
        Assertions.assertEquals("Campeonato Brasileirão Serie B 2023", controle2.getCampeonato());
        Assertions.assertEquals("Campeonato Copa do Brasil 2023", controle3.getCampeonato());
    }

}
