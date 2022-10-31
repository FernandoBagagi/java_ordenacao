import java.util.ArrayList;
import java.util.List;

import ordenacao.BubbleSort;
import ordenacao.Ordenador;

public class App {
    public static void main(String[] args) {

        /*
         int quantidade = 10000;
        int[] vetor = new int[quantidade];

        for (int i = 0; i < vetor.length; i++) {
         vetor[i] = (int) (Math.random()*quantidade);
        }
         */
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
        long tempoInicial = System.currentTimeMillis();
        Ordenador ordenador = new BubbleSort<>();
        long tempoFinal = System.currentTimeMillis();
        System.out.println("Após a ordenação:   " + ordenador.ordena(numeros) + "  " + (tempoFinal - tempoInicial) + " ms");

        /**
         * Sites:
         * -> https://www.freecodecamp.org/portuguese/news/algoritmos-de-ordenacao-explicados-com-exemplos-em-python-java-e-c/
         * -> https://www.devmedia.com.br/algoritmos-de-ordenacao-em-java/32693
         * 
         * Ordenações:
         * 
         * -> Bubble Sort
         * -> Insertion Sort
         * -> Selection Sort
         * -> Merge Sort
         * -> Quick Sort
         * -> Heap Sort
         * -> Counting Sort
         * -> Radix Sort
         * -> Bucket Sort
         */
    }
}
