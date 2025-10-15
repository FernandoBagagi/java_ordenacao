package br.com.ferdbgg;

public record Estatistica(
        String metodo, //
        Long tempoNano, //
        Long trocas, //
        Long comparacoes //
) implements Comparable<Estatistica>{
    @Override
    public int compareTo(Estatistica arg0) {
        return this.tempoNano.compareTo(arg0.tempoNano);
    }
}
