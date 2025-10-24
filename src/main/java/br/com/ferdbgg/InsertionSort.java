package br.com.ferdbgg;

import java.util.List;

public class InsertionSort<T extends Comparable<? super T>> extends Ordenador<T> {

    public InsertionSort(List<T> lista) {
        super(lista);
    }

    public InsertionSort(Temporizador temporizador, //
            Contador contadorTrocas, //
            Contador contadorComparacoes, //
            List<T> lista //
    ) {
        super(temporizador, contadorTrocas, contadorComparacoes, lista);
    }

    @Override
    protected void ordenar() {

        final int tamanhoLista = super.lista.size();

        for (int i = 1; i < tamanhoLista; i++) {

            T chave = lista.get(i);
            int j = i - 1;

            while (j >= 0 && super.comparar(lista.get(j), chave) > 0) {
                lista.set(j + 1, lista.get(j));
                super.incrementarTrocas();
                j--;
            }

            lista.set(j + 1, chave);
            super.incrementarTrocas();
        
        }

    }

    @Override
    public String getNome() {
        return "Insertion Sort";
    }

    @Override
    public String getDescricao() {
        return """
                Funcionamento: Constrói a lista ordenada um item de cada vez
                Complexidade: O(n²) no pior caso, O(n) no melhor caso
                Uso: Eficiente para listas pequenas ou quase ordenadas
                """;
    }

}
