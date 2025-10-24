package br.com.ferdbgg;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        final GeradorObjeto<Integer> geradorObjeto = new GeradorIntegerAleatorio();
        final var geradorLista = new GeradorLista<>(geradorObjeto);
        geradorLista.gerarNovaLista(1000, false, 5);

        final var ordenadores = Arrays.asList(
                new BubbleSort<>(geradorLista.getLista()),
                new SelectionSort<>(geradorLista.getLista()),
                new InsertionSort<>(geradorLista.getLista()),
                new QuickSort<>(geradorLista.getLista()),
                new MergeSort<>(geradorLista.getLista()),
                new HeapSort<>(geradorLista.getLista()),
                new TimSort<>(geradorLista.getLista()),
                new JavaSort<>(geradorLista.getLista()));

        final Relatorio relatorio = new RelatorioTerminal();

        ordenadores.stream()
                .map(Ordenador::testar)
                .map(Ordenador::gerarEstatisticas)
                .sorted()
                .forEach(relatorio::adicionarEstatistica);

        relatorio.gerarRelatorio();

    }
}
