package br.com.ferdbgg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Testes para GeradorLista
 */
class GeradorListaTest {

    // Gerador que sempre retorna o mesmo valor, para forçar colisões
    static class GeradorIntegerConstante extends GeradorObjeto<Integer> {
        private final Integer valor;

        public GeradorIntegerConstante(Integer valor) {
            this.valor = valor;
        }

        @Override
        public Integer gerarObjeto() {
            return valor;
        }
    }

    @Test
    void gerarListaComRepeticaoDeveFuncionar() {
        final GeradorObjeto<Integer> geradorObjeto = new GeradorIntegerAleatorio();
        final GeradorLista<Integer> geradorLista = new GeradorLista<>(geradorObjeto);

        geradorLista.gerarNovaLista(5, true, 10);
        final List<Integer> lista = geradorLista.getLista();

        assertEquals(5, lista.size());
    }

    @Test
    void gerarListaSemRepeticaoComGeradorAleatorio() {
        final GeradorObjeto<Integer> geradorObjeto = new GeradorIntegerAleatorio();
        final GeradorLista<Integer> geradorLista = new GeradorLista<>(geradorObjeto);

        geradorLista.gerarNovaLista(10, false, 1000);
        final List<Integer> lista = geradorLista.getLista();

        // Deve conter 10 elementos e todos distintos
        assertEquals(10, lista.size());
        assertEquals(10, lista.stream().distinct().count());
    }

    @Test
    void gerarListaSemRepeticaoQuandoImpossivelDeveLancarExcecao() {
        final GeradorObjeto<Integer> geradorObjeto = new GeradorIntegerConstante(42);
        final GeradorLista<Integer> geradorLista = new GeradorLista<>(geradorObjeto);

        // Como o gerador sempre retorna 42, ao pedir 2 elementos sem repeticao devemos falhar
        assertThrows(IllegalStateException.class, () -> geradorLista.gerarNovaLista(2, false, 5));
    }

    /**
     * Verifica que cada chamada retorna uma instância diferente (cópia),
     * mas com o mesmo conteúdo (equals) e que os elementos individuais
     * são as mesmas referências (==) — já que inteiros gerados são objetos Integer.
     */
    @Test
    void getListaDeveRetornarMesmosElementosMasListasDiferentes() {
        final GeradorObjeto<Integer> geradorObjeto = new GeradorIntegerAleatorio();
        final GeradorLista<Integer> geradorLista = new GeradorLista<>(geradorObjeto);

        geradorLista.gerarNovaLista(10, false, 2);
        
        final List<Integer> lista1 = geradorLista.getLista();
        final List<Integer> lista2 = geradorLista.getLista();

        // instâncias diferentes
        assertNotSame(lista1, lista2);

        // mesmo conteúdo
        assertEquals(lista1, lista2);
        assertEquals(lista1.size(), lista2.size());
        for (int i = 0; i < lista1.size(); i++) {
            assertSame(lista1.get(i), lista2.get(i));
        }
    }

}
