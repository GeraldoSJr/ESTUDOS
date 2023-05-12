import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TimeTeste {
    private Time controle1;
    private Time controle2;
    private Time controle3;
    private Time controle4;

    @BeforeEach
    void preparaTime(){
        this.controle1 = new Time("250_PB", "Nacional de Patos", "Canário");
        this.controle2 = new Time("252_PB", "Sport Lagoa Seca", "Carneiro");
        this.controle3 = new Time("255_PB", "Treze", "Noia");
        this.controle4 = new Time("002_RJ", "Clube de Regatas do Flamengo", "Urubu");
    }

    @Test
    void getCodigoTeste(){
        Assertions.assertEquals("250_PB", controle1.getCodigo());
        Assertions.assertEquals("252_PB", controle2.getCodigo());
        Assertions.assertEquals("255_PB", controle3.getCodigo());
        Assertions.assertEquals("002_RJ", controle4.getCodigo());
    }

    @Test
    void getNomeTeste(){
        Assertions.assertEquals("Nacional de Patos / Canário", controle1.nome());
        Assertions.assertEquals("Sport Lagoa Seca / Carneiro", controle2.nome());
        Assertions.assertEquals("Treze / Noia", controle3.nome());
        Assertions.assertEquals("Clube de Regatas do Flamengo / Urubu", controle4.nome());
    }

    @Test
    void getTimeTeste(){
        Assertions.assertEquals("[250_PB] Nacional de Patos / Canário", controle1.time());
        Assertions.assertEquals("[252_PB] Sport Lagoa Seca / Carneiro", controle2.time());
        Assertions.assertEquals("[255_PB] Treze / Noia", controle3.time());
        Assertions.assertEquals("[002_RJ] Clube de Regatas do Flamengo / Urubu", controle4.time());
    }
}
