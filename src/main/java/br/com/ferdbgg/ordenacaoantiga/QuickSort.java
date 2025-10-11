package br.com.ferdbgg.ordenacaoantiga;

import java.util.List;

public class QuickSort implements Ordenador{

    private static int separar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
            if (vetor[i] <= pivo)
                i++;
            else if (pivo < vetor[f])
                f--;
                else {
                    int troca = vetor[i];
                    vetor[i] = vetor[f];
                    vetor[f] = troca;
                    i++;
                    f--;
                }
            }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        return f;
    }
    
    @Override
    public List<Integer> ordena(List<Integer> lista) {
        /*
         if (inicio < fim) {
            int posicaoPivo = separar(vetor, inicio, fim);
            quickSort(vetor, inicio, posicaoPivo - 1);
            quickSort(vetor, posicaoPivo + 1, fim);
        }
         */
        return null;
    }
    
}
