package mc322.lab04;

public class Tabuleiro {
    Peca[][] pecas;
    int quantidadePecas;

    public int letraParaInteiro(char letra){
        return (int)letra - (int)('a');
    }

    public char inteiroParaLetra(int i){
        return (char)(i + (int)('a'));
    }

    Tabuleiro(){
        pecas = new Peca[7][7];
        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 7; j++){
                if ((i < 2 && j < 2) | (i < 2 && j > 4) | (i > 4 && j > 4) | (i > 4 && j < 2)){
                    pecas[i][j] = new Peca("!");
                } else if (i == 3 && j == 3){
                    pecas[3][3] = null;
                } else {
                    char coluna = inteiroParaLetra(j);
                    char linha = (char)(7 - i); //!!!!!lembrar que as linhas vão de 7 a 1 (reverso)
                    String posicao = Character.toString(coluna) + Character.toString(linha);
                    pecas[i][j] = new Peca(posicao);
                }
            }
        }
    }

    public void realizarComando(String comando){
    }

    public String converterString(); //converte o jogo de matriz para string

    public void apresentar(); //apresenta com a formatacao desejada


}
