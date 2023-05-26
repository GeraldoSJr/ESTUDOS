package test.documin; 


/** 
* Facade Tester. 
* 
* @author <Authors name> 
* @since <pre>mai 23, 2023</pre> 
* @version 1.0 
*/
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import documin.Facade;

public class FacadeTest {

    private Facade facade;

    @Before
    public void setup() {
        facade = new Facade();
    }

    @Test
    public void testCriarDocumento() {
        assertTrue(facade.criarDocumento("Documento 1"));
    }

    @Test
    public void testCriarDocumentoComTamanhoMaximo() {
        assertTrue(facade.criarDocumento("Documento 2", 1000));
    }

    @Test
    public void testRemoverDocumento() {
        facade.criarDocumento("Documento 3");
        facade.removerDocumento("Documento 3");
        assertEquals(0, facade.contarElementos("Documento 3"));
    }

    @Test
    public void testContarElementos() {
        facade.criarDocumento("Documento 4");
        facade.criarTexto("Documento 4", "Texto 1", 1);
        facade.criarTexto("Documento 4", "Texto 2", 2);
        assertEquals(2, facade.contarElementos("Documento 4"));
    }

    @Test
    public void testExibirDocumento() {
        facade.criarDocumento("Documento 5");
        facade.criarTexto("Documento 5", "Texto 1", 1);
        facade.criarTexto("Documento 5", "Texto 2", 2);
        String[] documento = facade.exibirDocumento("Documento 5");
        assertEquals(2, documento.length);
        assertEquals("Texto 1", documento[0]);
        assertEquals("Texto 2", documento[1]);
    }

    @Test
    public void testCriarTexto() {
        facade.criarDocumento("Documento 6");
        int elementoPosicao = facade.criarTexto("Documento 6", "Texto 3", 3);
        assertEquals(0, elementoPosicao);
    }

    @Test
    public void testCriarTitulo() {
        facade.criarDocumento("Documento 7");
        int elementoPosicao = facade.criarTitulo("Documento 7", "Titulo 1", 1, 1, true);
        assertEquals(0, elementoPosicao);
    }

    @Test
    public void testCriarLista() {
        facade.criarDocumento("Documento 8");
        int elementoPosicao = facade.criarLista("Documento 8", "Item1,Item2,Item3", 1, ",", "-");
        assertEquals(0, elementoPosicao);
    }

    @Test
    public void testCriarTermos() {
        facade.criarDocumento("Documento 9");
        int elementoPosicao = facade.criarTermos("Documento 9", "Termo1:Definição1;Termo2:Definição2", 1, ":", ";");
        assertEquals(0, elementoPosicao);
    }

    @Test
    public void testPegarRepresentacaoCompleta() {
        facade.criarDocumento("Documento 10");
        facade.criarTexto("Documento 10", "Texto 4", 4);
        String representacaoCompleta = facade.pegarRepresentacaoCompleta("Documento 10", 0);
        assertEquals("Texto 4", representacaoCompleta);
    }

    @Test
    public void testPegarRepresentacaoResumida() {
        facade.criarDocumento("Documento 11");
        facade.criarTexto("Documento 11", "Texto 5", 5);
        String representacaoResumida = facade.pegarRepresentacaoResumida("Documento 11", 0);
        assertEquals("Texto 5", representacaoResumida);
    }

    @Test
    public void testApagarElemento() {
        facade.criarDocumento("Documento 12");
        facade.criarTexto("Documento 12", "Texto 6", 6);
        assertTrue(facade.apagarElemento("Documento 12", 0));
        assertEquals(0, facade.contarElementos("Documento 12"));
    }

    @Test
    public void testMoverParaCima() {
        facade.criarDocumento("Documento 13");
        facade.criarTexto("Documento 13", "Texto 7", 7);
        facade.criarTexto("Documento 13", "Texto 8", 8);
        facade.moverParaCima("Documento 13", 1);
        String[] documento = facade.exibirDocumento("Documento 13");
        assertEquals("Texto 8", documento[0]);
        assertEquals("Texto 7", documento[1]);
    }

    @Test
    public void testMoverParaBaixo() {
        facade.criarDocumento("Documento 14");
        facade.criarTexto("Documento 14", "Texto 9", 9);
        facade.criarTexto("Documento 14", "Texto 10", 10);
        facade.moverParaBaixo("Documento 14", 0);
        String[] documento = facade.exibirDocumento("Documento 14");
        assertEquals("Texto 10", documento[0]);
        assertEquals("Texto 9", documento[1]);
    }

    @Test
    public void testCriarAtalho() {
        facade.criarDocumento("Documento 15");
        facade.criarDocumento("Documento 16");
        int elementoPosicao = facade.criarAtalho("Documento 15", "Documento 16");
        assertEquals(0, elementoPosicao);
    }

    @Test
    public void testCriarVisaoCompleta() {
        facade.criarDocumento("Documento 17");
        int visaoId = facade.criarVisaoCompleta("Documento 17");
        assertEquals(0, visaoId);
    }

    @Test
    public void testCriarVisaoResumida() {
        facade.criarDocumento("Documento 18");
        int visaoId = facade.criarVisaoResumida("Documento 18");
        assertEquals(0, visaoId);
    }

    @Test
    public void testCriarVisaoPrioritaria() {
        facade.criarDocumento("Documento 19");
        int visaoId = facade.criarVisaoPrioritaria("Documento 19", 3);
        assertEquals(0, visaoId);
    }

    @Test
    public void testCriarVisaoTitulo() {
        facade.criarDocumento("Documento 20");
        int visaoId = facade.criarVisaoTitulo("Documento 20");
        assertEquals(0, visaoId);
    }

    @Test
    public void testExibirVisao() {
        facade.criarDocumento("Documento 21");
        facade.criarTexto("Documento 21", "Texto 11", 11);
        facade.criarTexto("Documento 21", "Texto 12", 12);
        int visaoId = facade.criarVisaoCompleta("Documento 21");
        String[] visao = facade.exibirVisao(visaoId);
        assertEquals("Texto 11", visao[0]);
        assertEquals("Texto 12", visao[1]);
    }
}

