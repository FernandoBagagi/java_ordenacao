package br.com.ferdbgg;

import java.util.ArrayList;
import java.util.List;

public class RelatorioTerminal extends Relatorio {

    private final int[] larguras = { 30, 15, 15, 15 };
    private final List<String[]> dados = new ArrayList<>();

    @Override
    public void gerarRelatorio() {

        super.estatisticas.forEach( //
                (Estatistica estatistica) -> {
                    adicionarLinha(
                            estatistica.metodo(), //
                            String.valueOf(estatistica.tempoNano()), //
                            String.valueOf(estatistica.comparacoes()), //
                            String.valueOf(estatistica.trocas()) //
                    );
                } //
        );

        imprimir();
    }

    public void adicionarLinha(String... linha) {
        if (linha.length != Relatorio.labels.size()) {
            throw new IllegalArgumentException("Número de colunas não corresponde ao cabeçalho");
        }
        dados.add(linha);
    }

    public void imprimir() {
        imprimirLinhaSuperior();
        imprimirCabecalho();
        imprimirLinhaSeparadora();
        imprimirDados();
        imprimirLinhaInferior();
    }

    private void imprimirLinhaSuperior() {
        System.out.print("┌");
        for (int i = 0; i < larguras.length; i++) {
            System.out.print("─".repeat(larguras[i] + 2));
            if (i < larguras.length - 1)
                System.out.print("┬");
        }
        System.out.println("┐");
    }

    private void imprimirCabecalho() {
        System.out.print("│");
        for (int i = 0; i < Relatorio.labels.size(); i++) {
            String texto = centralizarTexto(Relatorio.labels.get(i), larguras[i]);
            System.out.print(" " + texto + " │");
        }
        System.out.println();
    }

    private void imprimirLinhaSeparadora() {
        System.out.print("├");
        for (int i = 0; i < larguras.length; i++) {
            System.out.print("─".repeat(larguras[i] + 2));
            if (i < larguras.length - 1)
                System.out.print("┼");
        }
        System.out.println("┤");
    }

    private void imprimirDados() {
        for (String[] linha : dados) {
            System.out.print("│");
            for (int i = 0; i < linha.length; i++) {
                // Primeira coluna alinhada à esquerda, demais à direita
                String texto = formatarTexto(linha[i], larguras[i], i == 0);
                System.out.print(" " + texto + " │");
            }
            System.out.println();
        }
    }

    private void imprimirLinhaInferior() {
        System.out.print("└");
        for (int i = 0; i < larguras.length; i++) {
            System.out.print("─".repeat(larguras[i] + 2));
            if (i < larguras.length - 1)
                System.out.print("┴");
        }
        System.out.println("┘");
    }

    private String formatarTexto(String texto, int largura, boolean alinharEsquerda) {
        if (texto.length() > largura) {
            return texto.substring(0, largura - 3) + "...";
        }

        if (alinharEsquerda) {
            // Alinhar à esquerda (para nomes)
            return String.format("%-" + largura + "s", texto);
        } else {
            // Alinhar à direita (para números)
            return String.format("%" + largura + "s", texto);
        }
    }

    private String centralizarTexto(String texto, int largura) {
        if (texto.length() >= largura) {
            return texto.substring(0, largura);
        }

        int espacos = largura - texto.length();
        int esquerda = espacos / 2;
        int direita = espacos - esquerda;

        return " ".repeat(esquerda) + texto + " ".repeat(direita);
    }
}
