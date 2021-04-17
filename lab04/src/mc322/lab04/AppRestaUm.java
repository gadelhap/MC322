package mc322.lab04;

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
            tabuleiro.executarComando(comandos[i]);
            estados[i + 1] = tabuleiro.paraString();
            System.out.println("Source: " + comandos[i].substring(0, 2));
            System.out.println("Target: " + comandos[i].substring(3, 5));
            tabuleiro.apresentar();
        }
        return estados;
    }
}