package br.com.ferdbgg;

import java.util.ArrayList;
import java.util.List;

public class TimSort<T extends Comparable<? super T>> extends Ordenador<T> {

    public TimSort(List<T> lista) {
        super(lista);
    }

    public TimSort(Temporizador temporizador, //
            Contador contadorTrocas, //
            Contador contadorComparacoes, //
            List<T> lista //
    ) {
        super(temporizador, contadorTrocas, contadorComparacoes, lista);
    }

    private static final int MIN_MERGE = 32;

    @Override
    protected void ordenar() {

        final int tamanhoLista = super.lista.size();

        // Se o array é muito pequeno, usa Insertion Sort direto
        if (tamanhoLista < MIN_MERGE) {
            insertionSort(0, tamanhoLista);
            return;
        }

        final int minRun = calcularMinRun(tamanhoLista);
        for (int i = 0; i < tamanhoLista; i += minRun) {
            int fim = Math.min(i + minRun - 1, tamanhoLista - 1);
            insertionSort(i, fim);
        }

        for (int tamanho = minRun; tamanho < tamanhoLista; tamanho = 2 * tamanho) {
            for (int esquerda = 0; esquerda < tamanhoLista; esquerda += 2 * tamanho) {
                int meio = esquerda + tamanho - 1;
                int direita = Math.min(esquerda + 2 * tamanho - 1, tamanhoLista - 1);

                if (meio < direita) {
                    merge(esquerda, meio, direita);
                }
            }
        }
    }

    /**
     * Calcula o tamanho mínimo do run usando a fórmula do Tim Peters
     */
    private int calcularMinRun(int n) {
        int r = 0;
        while (n >= 64) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    /**
     * Insertion Sort otimizado para o Timsort
     */
    private void insertionSort(int esquerda, int direita) {
        for (int i = esquerda + 1; i <= direita; i++) {
            T chave = lista.get(i);
            int j = i - 1;

            // Mover elementos maiores que a chave para frente
            while (j >= esquerda && super.comparar(lista.get(j), chave) > 0) {
                lista.set(j + 1, lista.get(j));
                super.incrementarTrocas();
                j--;
            }
            lista.set(j + 1, chave);
            super.incrementarTrocas();
        }
    }

    /**
     * Merge otimizado para o Timsort
     */
    private void merge(int esquerda, int meio, int direita) {
        // Tamanho dos subarrays
        final int tamanhoListaEsquerda = meio - esquerda + 1;
        final int tamanhoListaDireita = direita - meio;

        // Arrays temporários
        List<T> listaEsquerda = new ArrayList<>(tamanhoListaEsquerda);
        List<T> listaDireita = new ArrayList<>(tamanhoListaDireita);

        // Copiar dados para arrays temporários
        for (int i = 0; i < tamanhoListaEsquerda; i++) {
            listaEsquerda.add(lista.get(esquerda + i));
        }
        for (int i = 0; i < tamanhoListaDireita; i++) {
            listaDireita.add(lista.get(meio + 1 + i));
        }

        // Merge dos arrays temporários
        int i = 0;
        int j = 0;
        int k = esquerda;

        while (i < tamanhoListaEsquerda && j < tamanhoListaDireita) {
            if (super.comparar(listaEsquerda.get(i), listaDireita.get(j)) <= 0) {
                lista.set(k, listaEsquerda.get(i));
                super.incrementarTrocas();
                i++;
            } else {
                lista.set(k, listaDireita.get(j));
                super.incrementarTrocas();
                j++;
            }
            k++;
        }

        // Copiar elementos restantes
        while (i < tamanhoListaEsquerda) {
            lista.set(k, listaEsquerda.get(i));
            super.incrementarTrocas();
            i++;
            k++;
        }

        while (j < tamanhoListaDireita) {
            lista.set(k, listaDireita.get(j));
            super.incrementarTrocas();
            j++;
            k++;
        }
    }

    @Override
    public String getNome() {
        return "Tim Sort";
    }

    @Override
    public String getDescricao() {
        return """
                Funcionamento: Divide o array em "runs" (sequências ordenadas) e os combina minimizar operações
                Complexidade: O(n log n) no pior caso, O(n) no melhor caso
                Uso: é o algoritmo de ordenação padrão do Python e do Java (para arrays de objetos).
                """;
    }

}
