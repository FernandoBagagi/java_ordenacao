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
        quickSort(0, super.lista.size() - 1);
    }

    private void quickSort(int inicio, int fim) {
        if (inicio < fim) {
            int indicePivo = particionar(inicio, fim);
            quickSort(inicio, indicePivo - 1);
            quickSort(indicePivo + 1, fim);
        }
    }

    private int particionar(int inicio, int fim) {
        T pivo = lista.get(fim);
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            if (super.comparar(lista.get(j), pivo) <= 0) {
                i++;
                T aux = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, aux);
                super.incrementarTrocas();
            }
        }

        T aux = lista.get(i + 1);
        lista.set(i + 1, lista.get(fim));
        lista.set(fim, aux);
        super.incrementarTrocas();

        return i + 1;
    }

    @Override
    public String getNome() {
        return "QuickSort";
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