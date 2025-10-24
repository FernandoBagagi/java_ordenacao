package br.com.ferdbgg;

import java.util.ArrayList;
import java.util.List;

public class MergeSort<T extends Comparable<? super T>> extends Ordenador<T> {

    public MergeSort(List<T> lista) {
        super(lista);
    }

    public MergeSort(Temporizador temporizador, //
            Contador contadorTrocas, //
            Contador contadorComparacoes, //
            List<T> lista //
    ) {
        super(temporizador, contadorTrocas, contadorComparacoes, lista);
    }

    @Override
    protected void ordenar() {
        mergeSort(0, super.lista.size() - 1);
    }

    private void mergeSort(int inicio, int fim) {
        if (inicio < fim) {
            final int meio = inicio + (fim - inicio) / 2;
            mergeSort(inicio, meio);
            mergeSort(meio + 1, fim);
            merge(inicio, meio, fim);
        }
    }

    private void merge(int inicio, int meio, int fim) {
        final List<T> temp = new ArrayList<>(fim - inicio + 1);
        int i = inicio;
        int j = meio + 1;

        while (i <= meio && j <= fim) {
            if (super.comparar(lista.get(i), lista.get(j)) <= 0) {
                temp.add(lista.get(i++));
            } else {
                temp.add(lista.get(j++));
            }
        }

        while (i <= meio) {
            temp.add(lista.get(i++));
        }
        while (j <= fim) {
            temp.add(lista.get(j++));
        }

        for (int k = 0; k < temp.size(); k++) {
            if (!lista.get(inicio + k).equals(temp.get(k))) {
                lista.set(inicio + k, temp.get(k));
                super.incrementarTrocas();
            }
        }
    }

    @Override
    public String getNome() {
        return "Merge Sort";
    }

    @Override
    public String getDescricao() {
        return """
                Funcionamento: Divide a lista e depois combina as partes ordenadas
                Complexidade: O(n log n) sempre
                Uso: Estável e consistente
                """;
    }

}
