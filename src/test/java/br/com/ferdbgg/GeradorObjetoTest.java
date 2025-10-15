
package br.com.ferdbgg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GeradorObjetoTest {

    @Test
    void testaSeGeradorObjetoEhAbstrato() {
        assertTrue(java.lang.reflect.Modifier.isAbstract(GeradorObjeto.class.getModifiers()));
    }

    /**
     * Classe concreta que gera String constante "Teste"
     */
    private static class GeradorStringTeste extends GeradorObjeto<String> {
        @Override
        public String gerarObjeto() {
            return "Teste";
        }
    }

    @Test
    void testaSeClassesConcretasExtendemDeGeradorObjeto() {
        assertTrue(GeradorObjeto.class.isAssignableFrom(GeradorStringTeste.class));
        assertTrue(GeradorObjeto.class.isAssignableFrom(GeradorIntegerAleatorio.class));
    }

    @Test
    void testaSeRetornaAStringTeste() {
        final GeradorObjeto<String> gerador = new GeradorStringTeste();
        final var resultado = gerador.gerarObjeto();
        assertEquals("Teste", resultado);
    }

    @Test
    void testaSeRetornaInteiro() {
        final GeradorObjeto<Integer> gerador = new GeradorIntegerAleatorio();
        final var tipo = gerador.gerarObjeto().getClass();
        assertEquals(tipo, Integer.class);
    }

}