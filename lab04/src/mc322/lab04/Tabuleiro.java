package mc322.lab04;

public class Tabuleiro {
    Peca[][] pecas;
    int quantidadePecas;

    Tabuleiro(){
        this.pecas = new Peca[7][7];
        Posicao posicao;
        for (char i = 'a'; i <= 'g'; i++){
            for (char j = '1'; j <= '7'; j++){
                posicao = new Posicao(i + j);
                if (!posicao.valida()){
                    pecas[posicao.x][posicao.y] = null;
                }
                else{
                    pecas[posicao.x][posicao.y] = new Peca(posicao);
                }
            }
        }
        pecas[3][3] = null;

        // for (int i = 0; i < 7; i++){
        //     for (int j = 0; j < 7; j++){
        //         if ((i < 2 && j < 2) | (i < 2 && j > 4) | (i > 4 && j > 4) | (i > 4 && j < 2)){
        //             pecas[i][j] = new Peca("!");
        //         } else if (i == 3 && j == 3){
        //             pecas[3][3] = null;
        //         } else {
        //             char coluna = Funcoes.inteiroParaLetra(j);
        //             char linha = (char)(7 - i); //!!!!!lembrar que as linhas vão de 7 a 1 (reverso)
        //             String posicao = Character.toString(coluna) + Character.toString(linha);
        //             pecas[i][j] = new Peca(posicao);
        //         }
        //     }
        // }
    }

    public void realizarComando(String comando){
    }

    public String paraString(){

    } //converte o jogo de matriz para string

    public void apresentar(){

    } //apresenta com a formatacao desejada


}
