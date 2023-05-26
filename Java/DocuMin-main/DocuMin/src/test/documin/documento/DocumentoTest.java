package test.documin.documento;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import documin.documento.Documento;
import documin.elementos.Elemento;

public class DocumentoTest {

    private Documento documento;

    @BeforeEach
    public void setup() {
        documento = new Documento("Documento 1");
    }

    @Test
    public void testGetTitulo() {
        assertEquals("Documento 1", documento.getTitulo());
    }

    @Test
    public void testContaElementos() {
        assertEquals(0, documento.contaElementos());

        // Adicionar elementos ao documento
        Elemento elemento1 = new Elemento();
        documento.criaElemento(elemento1);
        assertEquals(1, documento.contaElementos());

        Elemento elemento2 = new Elemento();
        documento.criaElemento(elemento2);
        assertEquals(2, documento.contaElementos());
    }

    @Test
    public void testGetElementos() {
        Elemento elemento1 = new Elemento();
        Elemento elemento2 = new Elemento();

        documento.criaElemento(elemento1);
        documento.criaElemento(elemento2);

        assertEquals(2, documento.getElementos().size());
        assertTrue(documento.getElementos().contains(elemento1));
        assertTrue(documento.getElementos().contains(elemento2));
    }

    @Test
    public void testMoveElementoAcima() {
        Elemento elemento1 = new Elemento();
        Elemento elemento2 = new Elemento();
        Elemento elemento3 = new Elemento();

        documento.criaElemento(elemento1);
        documento.criaElemento(elemento2);
        documento.criaElemento(elemento3);

        documento.moveElementoAcima(2);
        assertEquals(elemento3, documento.getElemento(1));
        assertEquals(elemento2, documento.getElemento(2));
    }

    @Test
    public void testMoveElementoAbaixo() {
        Elemento elemento1 = new Elemento();
        Elemento elemento2 = new Elemento();
        Elemento elemento3 = new Elemento();

        documento.criaElemento(elemento1);
        documento.criaElemento(elemento2);
        documento.criaElemento(elemento3);

        documento.moveElementoAbaixo(0);
        assertEquals(elemento2, documento.getElemento(0));
        assertEquals(elemento1, documento.getElemento(1));
    }

    @Test
    public void testRemoveElemento() {
        Elemento elemento1 = new Elemento();
        Elemento elemento2 = new Elemento();
        Elemento elemento3 = new Elemento();

        documento.criaElemento(elemento1);
        documento.criaElemento(elemento2);
        documento.criaElemento(elemento3);

        assertTrue(documento.removeElemento(1));
        assertEquals(2, documento.contaElementos());
        assertFalse(documento.getElementos().contains(elemento2));
    }

    @Test
    public void testCriaElemento() {
        Elemento elemento = new Elemento();
        int posicao = documento.criaElemento(elemento);

        assertEquals(0, posicao);
        assertEquals(1, documento.contaElementos());
        assertTrue(documento.getElementos().contains(elemento));
    }

    @Test
    public void testEstaCheio() {
        assertFalse(documento.estaCheio());

        // Preencher o documento com elementos até o tamanho máximo
        int tamanhoMaximo = 3;
        Documento documentoCheio = new Documento("Documento 2", tamanhoMaximo);
        Elemento elemento1 = new Elemento();
        Elemento elemento2 = new Elemento();
        Elemento elemento3 = new Elemento();

        documentoCheio.criaElemento(elemento1);
        documentoCheio.criaElemento(elemento2);
        documentoCheio.criaElemento(elemento3);

        assertTrue(documentoCheio.estaCheio());
    }

    @Test
    public void testExibirDocumento() {
        Elemento elemento1 = new Elemento();
        Elemento elemento2 = new Elemento();

        documento.criaElemento(elemento1);
        documento.criaElemento(elemento2);

        String[] exibicao = documento.exibirDocumento();
        assertEquals(2, exibicao.length);
        assertEquals(elemento1.representacaoCompleta(), exibicao[0]);
        assertEquals(elemento2.representacaoCompleta(), exibicao[1]);
    }

    @Test
    public void testSetAtalho() {
        documento.setAtalho();
        assertTrue(documento.ehAtalho());
    }

    @Test
    public void testTemAtalho() {
        assertFalse(documento.temAtalho());

        // Adicionar um atalho ao documento
        Atalho atalho = new Atalho();
        documento.criaElemento(atalho);

        assertTrue(documento.temAtalho());
    }

    @Test
    public void testGetElemento() {
        Elemento elemento1 = new Elemento();
        Elemento elemento2 = new Elemento();

        documento.criaElemento(elemento1);
        documento.criaElemento(elemento2);

        assertEquals(elemento1, documento.getElemento(0));
        assertEquals(elemento2, documento.getElemento(1));
    }

    @Test
    public void testGetTamanhoMaximo() {
        Documento documentoCheio = new Documento("Documento 2", 5);
        assertEquals(5, documentoCheio.getTamanhoMaximo());
    }

    @Test
    public void testMediaPrioridadeElementos() {
        Elemento elemento1 = new Elemento();
        elemento1.setPrioridade(2);
        Elemento elemento2 = new Elemento();
        elemento2.setPrioridade(4);
        Elemento elemento3 = new Elemento();
        elemento3.setPrioridade(3);

        documento.criaElemento(elemento1);
        documento.criaElemento(elemento2);
        documento.criaElemento(elemento3);

        assertEquals(3, documento.mediaPrioridadeElementos());
    }
}
