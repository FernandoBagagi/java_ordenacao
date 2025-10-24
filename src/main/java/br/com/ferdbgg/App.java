package br.com.ferdbgg;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        final GeradorObjeto<Integer> geradorObjeto = new GeradorIntegerAleatorio();
        final GeradorLista<Integer> geradorLista = new GeradorLista<>(geradorObjeto);
        geradorLista.gerarNovaLista(1000, false, 5);

        //System.out.println(geradorLista.getLista());

        List<Ordenador<Integer>> ordenadores = new ArrayList<>();

        // Cria ordenadores que serão testados
        ordenadores.add(new BubbleSort<>(geradorLista.getLista()));
        ordenadores.add(new SelectionSort<>(geradorLista.getLista()));
        ordenadores.add(new InsertionSort<>(geradorLista.getLista()));
        ordenadores.add(new QuickSort<>(geradorLista.getLista()));
        ordenadores.add(new MergeSort<>(geradorLista.getLista()));
        ordenadores.add(new HeapSort<>(geradorLista.getLista()));
        ordenadores.add(new TimSort<>(geradorLista.getLista()));
        ordenadores.add(new JavaSort<>(geradorLista.getLista()));

        // Executa os testes e gera relatótio
        final Relatorio relatorio = new RelatorioTerminal();

        ordenadores.stream()
                .map(Ordenador::testar)
                //.map(Ordenador::getLista).forEach(System.out::println);
                .map(Ordenador::gerarEstatisticas)
                .sorted()
                .forEach(relatorio::adicionarEstatistica);

        relatorio.gerarRelatorio();

    }
}
