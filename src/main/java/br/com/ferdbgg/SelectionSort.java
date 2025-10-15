package br.com.ferdbgg;

import java.util.List;

public class SelectionSort<T extends Comparable<? super T>> extends Ordenador<T> {

    public SelectionSort(List<T> lista) {
        super(lista);
    }

    public SelectionSort(Temporizador temporizador, //
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

            int indiceMinimo = i;

            for (int j = i + 1; j < tamanhoLista; j++) {
                if (super.comparar(lista.get(j), lista.get(indiceMinimo)) < 0) {
                    indiceMinimo = j;
                }
            }

            if (indiceMinimo != i) {

                final T aux = lista.get(i);
                lista.set(i, lista.get(indiceMinimo));
                lista.set(indiceMinimo, aux);

                super.incrementarTrocas();

            }

        }

    }

    @Override
    public String getNome() {
        return "SelectionSort";
    }

    @Override
    public String getDescricao() {
        return """
                Funcionamento: Encontra o menor elemento e coloca na posição correta
                Complexidade: O(n²) sempre
                Uso: Simples mas ineficiente
                """;
    }

}
