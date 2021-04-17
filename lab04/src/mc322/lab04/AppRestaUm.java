package mc322.lab04;

import java.util.Scanner;

public class AppRestaUm {
    
    /**
     * path: path para um arquivo CSV com uma série de comandos.
     * Retorna um vetor de strings com todos estados do tabuleiro de Resta Um
     * durante um jogo com os dados comandos e imprime na tela esses estados
     * com suas descrições.
     */
    public static String[] executaJogo(String path) {
        Tabuleiro tabuleiro = new Tabuleiro();
        CSVReader csv = new CSVReader();
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
        Scanner input = new Scanner(System.in);
        String path = input.next();
        // String estados[];
        path = path.replaceAll("'", ""); //caso usuario passe o path com aspas (arrastando o path pro terminal)
        /*estados = */executaJogo(path);
        // System.out.println();
        // for (int i = 0; i < estados.length; i++){
        //     System.out.println(estados[i]);
        // }
    }
}