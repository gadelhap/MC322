package mc322.lab05;

import java.util.Scanner;

public class AppDama {
    
    /**
     * path: path para um arquivo CSV com uma série de comandos.
     * Retorna um vetor de strings com todos estados do tabuleiro de Jogo de
     * Damas durante um jogo com os dados comandos e imprime na tela esses
     * estados com suas descrições.
     */
    public static String[] executaJogo(String path) {
        Tabuleiro tabuleiro = new Tabuleiro();
        CSVHandling csv = new CSVHandling();
        String comandos[];
        String estados[];
        csv.setDataSource(path);
        comandos = csv.requestCommands();
        estados = new String[comandos.length + 1];
        estados[0] = tabuleiro.paraString();
        System.out.println("Tabuleiro inicial:");
        tabuleiro.apresentar();
        for (int i = 0; i < comandos.length; i++) {
            System.out.println();
            tabuleiro.executarComando(comandos[i]);
            estados[i + 1] = tabuleiro.paraString();
            System.out.println("Source: " + comandos[i].substring(0, 2));
            System.out.println("Target: " + comandos[i].substring(3, 5));
            tabuleiro.apresentar();
        }
        return estados;
    }

    public static void main(String args[]){
        String path = args[0];
        /*estados = */executaJogo(path);
        // System.out.println();
        // for (int i = 0; i < estados.length; i++){
        //     System.out.println(estados[i]);
        // }
    }
}