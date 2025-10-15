package br.com.ferdbgg;

import java.util.ArrayList;
import java.util.List;

public abstract class Relatorio {
    protected static final List<String> labels = List.of("Método", "Tempo (ns)", "Nº comparações", "Nº trocas");
    protected final List<Estatistica> estatisticas = new ArrayList<>();

    public void adicionarEstatistica(Estatistica estatistica) {
        this.estatisticas.add(estatistica);
    }

    public abstract void gerarRelatorio();

}
