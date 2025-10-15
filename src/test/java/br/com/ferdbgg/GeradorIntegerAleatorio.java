package br.com.ferdbgg;

import java.util.random.RandomGenerator;

/**
 * Classe concreta que gera Integer aleatórios
 */
public class GeradorIntegerAleatorio extends GeradorObjeto<Integer> {

    private final RandomGenerator randomGenerator = RandomGenerator.getDefault();

    @Override
    public Integer gerarObjeto() {
        return randomGenerator.nextInt(0, Integer.MAX_VALUE);
    }

}
