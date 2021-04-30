package mc322.lab05;

import java.util.Scanner;

public class AppDama {
    
    /**
     * path: path para um arquivo CSV com uma série de comandos.
     * Retorna um vetor de strings com todos estados do tabuleiro de Jogo de
     * Damas durante um jogo com os dados comandos e imprime na tela esses
     * estados com suas descrições.
     */
    public static void executaJogo(String pathComandos, String pathEstadoFinal) {
        Tabuleiro tabuleiro = new Tabuleiro();
        CSVHandling csv = new CSVHandling();
        String comandos[];
        csv.setDataSource(pathComandos);
        comandos = csv.requestCommands();
        System.out.println("Tabuleiro inicial:");
        tabuleiro.imprimirTabuleiro();
        for (int i = 0; i < comandos.length; i++) {
            System.out.println();
            tabuleiro.executarComando(comandos[i]);
            System.out.println("Source: " + comandos[i].substring(0, 2));
            System.out.println("Target: " + comandos[i].substring(3, 5));
            tabuleiro.imprimirTabuleiro();
        }
        tabuleiro.exportarArquivo(pathEstadoFinal);
        return estados;
    }

    public static void main(String args[]){
        executaJogo(args[0], args[1]);
    }
}