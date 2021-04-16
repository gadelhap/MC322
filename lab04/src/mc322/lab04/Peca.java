package mc322.lab04;

public class Peca{
    Posicao posicao;

    /**
     * posicao: posição da peça no tabuleiro.
     * Inicializa uma Peca.
     */
    Peca(Posicao posicao){
        this.posicao = posicao;
    }

    /**
     * novaPosicao: Posicao a ser atribuída a Peca.
     * Atribui nova posição a Peca.
     */
    void mudarPosicao(Posicao novaPosicao){
        this.posicao = novaPosicao;
    }

    // public void movimentarDireita(){
    //     int l = Funcoes.letraParaInteiro(posicao.charAt(0));
    //     l += 2;
    //     this.posicao = Character.toString(Funcoes.inteiroParaLetra(l)) + posicao.charAt(1);
    // }
    // public void movimentarEsquerda(){
    //     int l = Funcoes.letraParaInteiro(posicao.charAt(0));
    //     l -= 2;
    //     this.posicao = Character.toString(Funcoes.inteiroParaLetra(l)) + posicao.charAt(1);
    // }

    // public void movimentarCima(){
    //     int n = Character.getNumericValue(posicao.charAt(1));
    //     n += 2;
    //     this.posicao = Character.toString(posicao.charAt(0)) + n;
    // }

    // public void movimentarBaixo(){
    //     int n = Character.getNumericValue(posicao.charAt(1));
    //     n -= 2;
    //     this.posicao = Character.toString(posicao.charAt(0)) + n;
    // }

}
