package br.com.ferdbgg;

import java.util.List;

public class JavaSort<T extends Comparable<? super T>> extends Ordenador<T> {

    public JavaSort(List<T> lista) {
        super(lista);
    }

    public JavaSort(Temporizador temporizador, //
            Contador contadorTrocas, //
            Contador contadorComparacoes, //
            List<T> lista //
    ) {
        super(temporizador, contadorTrocas, contadorComparacoes, lista);
    }

    @Override
    protected void ordenar() {
        lista.sort(super::comparar);
    }

    @Override
    public String getNome() {
        return "List.sort()";
    }

    @Override
    public String getDescricao() {
        return """
                Funcionamento: TimSort otimizado
                Complexidade: O(n log n) no pior caso, O(n) no melhor caso
                Uso: método nativo do Java
                """;
    }

}
