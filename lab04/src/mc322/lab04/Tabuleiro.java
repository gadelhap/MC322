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

    public void executarComando(String comando){
        Posicao source, target, intermediaria;
        source = new Posicao(comando.substring(0, 2));
        target = new Posicao(comando.substring(3, 5));
        if (source.x == target.x && source.y == target.y){
            System.out.println("Comando inválido: sem movimento.");
            return;
        }
        if (source.x != target.x && source.y != target.y){
            System.out.println("Comando inválido: movimento diagonal.");
            return;
        }
        if (!source.valida()){
            System.out.println("Comando inválido: source fora do tabuleiro.");
            return;
        }
        if (!target.valida()){
            System.out.println("Comando inválido: target fora do tabuleiro.");
            return;
        }
        if (this.pecas[source.x][source.y] == null){
            System.out.println("Comando inválido: source vazia.");
            return;
        }
        if (this.pecas[target.x][target.y] != null){
            System.out.println("Comando inválido: target ocupada.");
            return;
        }
        if (source.y != target.y){
            if(Math.abs(source.y - target.y) > 1){
                System.out.println("Comando inválido: mais de uma peça intermediária.");
                return;
            }
            intermediaria = new Posicao(((char)(source.x + 97)) + ((char)((source.y + target.y)/2 + 49)));
            if (this.pecas[intermediaria.x][intermediaria.y] == null){
                System.out.println("Comando inválido: sem peça intermediária.");
                return;   
            }
            retirarPeca(intermediaria);
            retirarPeca(source);
            colocarPeca(target);
        }
        else{
            if(Math.abs(source.x - target.x) > 1){
                System.out.println("Comando inválido: movimento inválido.");
                return;
            }
            intermediaria = new Posicao(((char)((source.x + target.x)/2 + 97)) + ((char)(source.y + 49)));
            if (this.pecas[intermediaria.x][intermediaria.y] == null){
                System.out.println("Comando inválido: sem peça intermediária.");
                return;   
            }
            retirarPeca(intermediaria);
            retirarPeca(source);
            colocarPeca(target);
        }

    }
    
    public void colocarPeca(Posicao posicao){
        this.pecas[posicao.x][posicao.y] = new Peca(((char)(posicao.x + 97)) + ((char)(posicao.y + 49)));
    }
    public void retirarPeca(Posicao posicao){
        this.pecas[posicao.x][posicao.y] = null;
    }

    public String paraString(){

    } //converte o jogo de matriz para string

    public void apresentar(){

    } //apresenta com a formatacao desejada


}
