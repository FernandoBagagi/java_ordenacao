package br.com.ferdbgg;

import java.util.List;

public class HeapSort<T extends Comparable<? super T>> extends Ordenador<T> {

    public HeapSort(List<T> lista) {
        super(lista);
    }

    public HeapSort(Temporizador temporizador, //
            Contador contadorTrocas, //
            Contador contadorComparacoes, //
            List<T> lista //
    ) {
        super(temporizador, contadorTrocas, contadorComparacoes, lista);
    }

    @Override
    protected void ordenar() {

        final int tamanhoLista = super.lista.size();

        for (int i = tamanhoLista / 2 - 1; i >= 0; i--) {
            heapify(tamanhoLista, i);
        }

        for (int i = tamanhoLista - 1; i > 0; i--) {
            T aux = lista.get(0);
            lista.set(0, lista.get(i));
            lista.set(i, aux);
            super.incrementarTrocas();

            heapify(i, 0);
        }
    }

    private void heapify(int tamanho, int indiceRaiz) {
        int maior = indiceRaiz;
        final int esquerda = 2 * indiceRaiz + 1;
        final int direita = 2 * indiceRaiz + 2;

        if (esquerda < tamanho && super.comparar(lista.get(esquerda), lista.get(maior)) > 0) {
            maior = esquerda;
        }

        if (direita < tamanho && super.comparar(lista.get(direita), lista.get(maior)) > 0) {
            maior = direita;
        }

        if (maior != indiceRaiz) {
            T aux = lista.get(indiceRaiz);
            lista.set(indiceRaiz, lista.get(maior));
            lista.set(maior, aux);
            super.incrementarTrocas();

            heapify(tamanho, maior);
        }
    }

    @Override
    public String getNome() {
        return "Heap Sort";
    }

    @Override
    public String getDescricao() {
        return """
                Funcionamento: Usa uma estrutura de heap para ordenação
                Complexidade: O(n log n) sempre
                Uso: Bom quando se precisa de O(1) espaço adicional
                """;
    }

}
