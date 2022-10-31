import java.util.ArrayList;
import java.util.List;

import ordenacao.BubbleSort;
import ordenacao.Ordenador;

public class App {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(10);
        numeros.add(65);
        numeros.add(47);
        numeros.add(35);
        numeros.add(7412);
        numeros.add(0);
        numeros.add(98);
        numeros.add(73);
        numeros.add(24);
        numeros.add(302);

        System.out.println("Antes da ordenação: " + numeros);
        Ordenador ordenador = new BubbleSort<>();
        System.out.println("Após a ordenação: " + ordenador.ordena(numeros));
    }
}
