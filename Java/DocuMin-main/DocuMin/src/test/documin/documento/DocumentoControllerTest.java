package test.documin.documento;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.documento.Documento;
import documin.documento.DocumentoController;

import java.util.NoSuchElementException;

public class DocumentoControllerTest {

    private DocumentoController controller;

    @BeforeEach
    public void setup() {
        controller = new DocumentoController();
    }

    @Test
    public void testCriarDocumento() {
        assertTrue(controller.criarDocumento("Documento 1"));
        assertTrue(controller.criarDocumento("Documento 2", 5));
    }

    @Test
    public void testCriarDocumentoExistente() {
        assertTrue(controller.criarDocumento("Documento 1"));
        assertFalse(controller.criarDocumento("Documento 1"));
    }

    @Test
    public void testCriarDocumentoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            controller.criarDocumento("");
        });
    }

    @Test
    public void testCriarDocumentoComTamanhoMaximo() {
        assertTrue(controller.criarDocumento("Documento 1", 5));
        Documento documento = controller.getDocumento("Documento 1");
        assertEquals(5, documento.getTamanhoMaximo());
    }

    @Test
    public void testRemoverDocumento() {
        boolean doc1 =controller.criarDocumento("Documento 1");
        assertEquals(doc1, controller.getDocumento("Documento 1"));

        controller.removerDocumento("Documento 1");
        assertNull(controller.getDocumento("Documento 1"));
    }

    @Test
    public void testRemoverDocumentoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            controller.removerDocumento("");
        });
    }

    @Test
    public void testRemoverDocumentoInexistente() {
        assertThrows(NoSuchElementException.class, () -> {
            controller.removerDocumento("Documento 1");
        });
    }

    @Test
    public void testContarElementos() {
        controller.criarDocumento("Documento 1");
        Documento documento = controller.getDocumento("Documento 1");
        documento.criaElemento(new Elemento());
        documento.criaElemento(new Elemento());

        assertEquals(2, controller.contarElementos("Documento 1"));
    }

    @Test
    public void testContarElementosInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            controller.contarElementos("");
        });
    }

    @Test
    public void testContarElementosInexistente() {
        assertThrows(NoSuchElementException.class, () -> {
            controller.contarElementos("Documento 1");
        });
    }

    @Test
    public void testExibirDocumento() {
        controller.criarDocumento("Documento 1");
        Documento documento = controller.getDocumento("Documento 1");
        Elemento elemento1 = new Elemento();
        Elemento elemento2 = new Elemento();
        documento.criaElemento(elemento1);
        documento.criaElemento(elemento2);

        String[] exibicao = controller.exibirDocumento("Documento 1");
        assertEquals(2, exibicao.length);
        assertEquals(elemento1.representacaoCompleta(), exibicao[0]);
        assertEquals(elemento2.representacaoCompleta(), exibicao[1]);
    }

    @Test
    public void testExibirDocumentoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            controller.exibirDocumento("");
        });
    }

    @Test
    public void testExibirDocumentoInexistente() {
        assertThrows(NoSuchElementException.class, () -> {
            controller.exibirDocumento("Documento 1");
        });
    }

    @Test
    public void testGetDocumento() {
        controller.criarDocumento("Documento 1");
        Documento documento = controller.getDocumento("Documento 1");
        assertNotNull(documento);
        assertEquals("Documento 1", documento.getTitulo());
    }

    @Test
    public void testGetDocumentoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            controller.getDocumento("");
        });
    }

    @Test
    public void testGetDocumentoInexistente() {
        assertThrows(NoSuchElementException.class, () -> {
            controller.getDocumento("Documento 1");
        });
    }
}
