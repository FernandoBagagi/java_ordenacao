package br.com.ferdbgg;

import java.util.List;

public abstract class Ordenador<T extends Comparable<? super T>> {

    private Temporizador temporizador;
    private Contador contadorTrocas;
    private Contador contadorComparacoes;
    protected final List<T> lista;

    protected Ordenador(List<T> lista) {
        this.temporizador = new Temporizador();
        this.contadorTrocas = new Contador();
        this.contadorComparacoes = new Contador();
        this.lista = lista;
    }

    protected Ordenador(Temporizador temporizador, Contador contadorTrocas, Contador contadorComparacoes,
            List<T> lista) {
        this.temporizador = temporizador;
        this.contadorTrocas = contadorTrocas;
        this.contadorComparacoes = contadorComparacoes;
        this.lista = lista;
    }

    protected abstract void ordenar();

    public Ordenador<T> testar() {

        this.temporizador.iniciar();
        this.ordenar();
        this.temporizador.parar();

        return this;
    }

    protected int comparar(T valor1, T valor2) {
        this.contadorComparacoes.incrementar();
        return valor1.compareTo(valor2);
    }

    protected void incrementarTrocas() {
        this.contadorTrocas.incrementar();
    }

    public Estatistica gerarEstatisticas() {
        return new Estatistica( //
                this.getNome(), //
                temporizador.getTempoNanosegundos(), //
                contadorTrocas.getValor(), //
                contadorComparacoes.getValor() //
        );
    }

    public abstract String getNome();

    public abstract String getDescricao();

    public List<T> getLista() {
        return this.lista;
    }

}
