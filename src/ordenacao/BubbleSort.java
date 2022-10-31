package ordenacao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BubbleSort<T> implements Ordenador {

    @Override
    public List<Integer> ordena(List<Integer> lista) {
        lista = new LinkedList<Integer>(lista);
        for (int i = 0; i < lista.size(); i++) {
            for (int j = 0; j < lista.size() - 1; j++) {
                if (lista.get(i) > lista.get(i + 1)) {
                    Integer aux = lista.get(i);
                    lista.set(i, lista.get(i + 1));
                    lista.set(i + 1, aux);
                }
            }
        }
        return new ArrayList<Integer>(lista);
    }

}
