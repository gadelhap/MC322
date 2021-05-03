package mc322.lab05;

public class Dama extends Peca {

    /**
     * tipo: tipo da dama.
     * Inicializa uma dama.
     */
    Dama(char tipo, int linha, int coluna) {
        super(tipo, linha, coluna);
    }

    /**
     * trajeto: vetor com as peças do trajeto, em que a primeira é a peça na
     * source e a última é a peça no target.
     * Retorna um vetor com duas posições caso seja válido e capturado uma peça
     * Um vetor com um único elemento se válido e não capturou peça
     * Null caso seja inválido
     */
    public int[] movimentoValido(Peca[] trajeto) {
        if (trajeto.length < 2){
            return  null;
        }
        if (){

        }
    }
}