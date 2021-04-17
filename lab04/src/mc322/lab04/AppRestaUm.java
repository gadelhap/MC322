package mc322.lab04;

public class AppRestaUm{
    public static String[] executaJogo(String path){
        Tabuleiro tabuleiro = new Tabuleiro();
        CSVReader csv = new CSVReader();
        csv.setDataSource(path);
        String comandos[] = csv.requestCommands();
        String historico[] = new String[comandos.length + 1];
        historico[0] = tabuleiro.paraString();
        System.out.println("Tabuleiro inicial:");
        tabuleiro.apresentar();
        for (int i = 1; i <= comandos.length; i++){
            tabuleiro.executarComando(comandos[i]);
            historico[i] = tabuleiro.paraString();
            System.out.println("Source: " + comandos[i].substring(0, 2));
            System.out.println("Target: " + comandos[i].substring(3, 5));
            tabuleiro.apresentar();
        }
        return historico;
    }
}