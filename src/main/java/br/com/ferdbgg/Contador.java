package br.com.ferdbgg;

public class Contador {

    private Long valor = Long.valueOf(0L);

    public void incrementar() {
        valor++;
    }

    public long getValor() {
        return this.valor.longValue();
    } 

}
