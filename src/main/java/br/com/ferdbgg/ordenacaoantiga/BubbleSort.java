package br.com.ferdbgg.ordenacaoantiga;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BubbleSort<T> implements Ordenador {

    @Override
    public List<Integer> ordena(List<Integer> lista) {
        lista = new LinkedList<>(lista);
        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = 0; j < lista.size() - 1; j++) {
                if (lista.get(j) > lista.get(j + 1)) {
                    Integer aux = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, aux);
                    //System.out.println(lista);
                }
            }
        }
        return new ArrayList<>(lista);
    }

}
