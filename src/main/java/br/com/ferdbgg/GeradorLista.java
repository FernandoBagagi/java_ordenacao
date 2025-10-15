package br.com.ferdbgg;

import java.util.ArrayList;
import java.util.List;

public class GeradorLista<T> {

    private final GeradorObjeto<T> geradorObjeto;

    private final List<T> lista = new ArrayList<>();

    public GeradorLista(GeradorObjeto<T> geradorObjeto) {
        this.geradorObjeto = geradorObjeto;
    }

    public void gerarNovaLista(Integer tamanho, Boolean permiteRepeticao, Integer numeroMaximoDeTentativas) {

        lista.clear();

        if (tamanho == null || tamanho < 0) {
            return;
        }

        final boolean permiteRepeticaoTratado = Boolean.TRUE.equals(permiteRepeticao);
        final int numeroMaximoDeTentativasTratado = numeroMaximoDeTentativas != null && numeroMaximoDeTentativas > 0
                ? numeroMaximoDeTentativas
                : 100;

        for (int i = 0; i < tamanho; i++) {

            final T novoObjeto = gerarNovoObjeto(permiteRepeticaoTratado, numeroMaximoDeTentativasTratado);

            lista.add(novoObjeto);

        }

    }

    private T gerarNovoObjeto(final boolean permiteRepeticao, final int numeroMaximoDeTentativas)
            throws IllegalStateException {

        if (permiteRepeticao) {
            return geradorObjeto.gerarObjeto();
        }

        T novoObjeto;
        int tentativas = 0;

        do {
            novoObjeto = geradorObjeto.gerarObjeto();
            tentativas += 1;
        } while (lista.contains(novoObjeto) && tentativas < numeroMaximoDeTentativas);

        if (tentativas >= numeroMaximoDeTentativas) {
            throw new IllegalStateException(
                    "Não foi possível gerar um novo objeto único após " + numeroMaximoDeTentativas + " tentativas");
        }

        return novoObjeto;

    }

    public List<T> getLista() {
        return List.copyOf(this.lista);
    }

}
