package br.com.ferdbgg;

public class Temporizador {

    private long inicio = 0L;
    private long fim = 0L;
    
    public void iniciar() {
        inicio = System.nanoTime();
    }
    
    public void parar() {
        fim = System.nanoTime();
    }
    
    public long getTempoNanosegundos() {
        return fim - inicio;
    }

}
