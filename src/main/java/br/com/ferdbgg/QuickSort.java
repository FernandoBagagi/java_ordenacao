package br.com.ferdbgg;

import java.util.List;

public class QuickSort<T extends Comparable<? super T>> extends Ordenador<T> {

    public QuickSort(List<T> lista) {
        super(lista);
    }

    public QuickSort(Temporizador temporizador, //
            Contador contadorTrocas, //
            Contador contadorComparacoes, //
            List<T> lista //
    ) {
        super(temporizador, contadorTrocas, contadorComparacoes, lista);
    }

    @Override
    protected void ordenar() {
        quickSort2(0, super.lista.size() - 1);
    }

    /*
     * private void quickSort(int inicio, int fim) {
     * if (inicio < fim) {
     * int indicePivo = particionar(inicio, fim);
     * quickSort(inicio, indicePivo - 1);
     * quickSort(indicePivo + 1, fim);
     * }
     * }
     * 
     * private int particionar(int inicio, int fim) {
     * T pivo = lista.get(fim);
     * int i = inicio - 1;
     * 
     * for (int j = inicio; j < fim; j++) {
     * if (super.comparar(lista.get(j), pivo) <= 0) {
     * i++;
     * T aux = lista.get(i);
     * lista.set(i, lista.get(j));
     * lista.set(j, aux);
     * super.incrementarTrocas();
     * }
     * }
     * 
     * T aux = lista.get(i + 1);
     * lista.set(i + 1, lista.get(fim));
     * lista.set(fim, aux);
     * super.incrementarTrocas();
     * 
     * return i + 1;
     * }
     */

    private void quickSort2(int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = separar(inicio, fim);
            quickSort2(inicio, posicaoPivo - 1);
            quickSort2(posicaoPivo + 1, fim);
        }
    }

    private int separar(int inicio, int fim) {
        
        T pivo = lista.get(inicio);
        int i = inicio + 1;
        int f = fim;

        while (i <= f) {
            if (super.comparar(lista.get(i), pivo) <= 0) {
                i++;
            } else if (super.comparar(pivo, lista.get(f)) < 0) {
                f--;
            } else {
                T aux = lista.get(i);
                lista.set(i, lista.get(f));
                lista.set(f, aux);
                super.incrementarTrocas();
                i++;
                f--;
            }
        }

        lista.set(inicio, lista.get(f));
        lista.set(f, pivo);
        super.incrementarTrocas();
        
        return f;

    }

    @Override
    public String getNome() {
        return "Quick Sort";
    }

    @Override
    public String getDescricao() {
        return """
                Funcionamento: Divide e conquista usando um pivô
                Complexidade: O(n²) no pior caso, O(n log n) no melhor caso
                Uso: Um dos mais rápidos na prática
                """;
    }

}