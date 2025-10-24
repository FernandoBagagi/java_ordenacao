package br.com.ferdbgg;

import java.util.List;

public class BubbleSort<T extends Comparable<? super T>> extends Ordenador<T> {

    public BubbleSort(List<T> lista) {
        super(lista);
    }

    public BubbleSort(Temporizador temporizador, //
            Contador contadorTrocas, //
            Contador contadorComparacoes, //
            List<T> lista //
    ) {
        super(temporizador, contadorTrocas, contadorComparacoes, lista);
    }

    @Override
    protected void ordenar() {

        final int tamanhoLista = super.lista.size();

        for (int i = 0; i < tamanhoLista - 1; i++) {

            for (int j = 0; j < tamanhoLista - 1; j++) {

                if (super.comparar(lista.get(j), lista.get(j + 1)) > 0) {

                    T aux = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, aux);
                    super.incrementarTrocas();

                }
            }
        }
    }

    @Override
    public String getNome() {
        return "Bubble Sort";
    }

    @Override
    public String getDescricao() {
        return """
                Funcionamento: Compara elementos adjacentes e os troca se estiverem na ordem errada
                Complexidade: O(n²) no pior caso, O(n) no melhor caso
                Uso: Educacional, não recomendado para produção
                """;
    }

}
