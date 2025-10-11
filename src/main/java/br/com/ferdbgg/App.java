package br.com.ferdbgg;

import java.util.random.RandomGenerator;

public class App {
    public static void main(String[] args) {

        final GeradorObjeto<Integer> geradorInteirosAleatorios = new GeradorObjeto<Integer>() {
            
            final RandomGenerator randomGenerator = RandomGenerator.getDefault();
            
            @Override
            public Integer gerarObjeto() {
                return randomGenerator.nextInt(0, Integer.MAX_VALUE);
            }

        };

        final GeradorLista<Integer> geradorLista = new GeradorLista<>(geradorInteirosAleatorios);
        geradorLista.gerarNovaLista(10, false, 100);

        System.out.println(geradorLista.getLista());

        // TODO: Criar listas de testes
        // TODO: Criar ordenadores que serão testados
        // TODO: Executar os testes
        // TODO: Gerar relatótio
    }
}
