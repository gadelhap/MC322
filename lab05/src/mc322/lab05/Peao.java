package mc322.lab05;

public class Peao extends Peca {
    
    /**
     * tipo: tipo do peão.
     * Inicializa um peão.
     */
    Peao(char tipo, int linha, int coluna) {
        super(tipo, linha, coluna);
    }

    /**
     * trajeto: vetor com as peças do trajeto, em que a primeira é a peça na
     * source e a última é a peça no target.
     * Retorna um vetor com duas posições caso seja válido e capturado uma peça
     * Um vetor com um único elemento se válido e não capturou peça
     * null caso seja inválido
     */
    public int[] movimentoValido(Peca[] trajeto) {
        if (trajeto[0] == null || trajeto[trajeto.length - 1] == null){
            return null; //fora dos limites
        }
        if (trajeto.length < 2 || trajeto.length > 3){ //movimento pro source ou movimento excessivo
            return null;
        }
        if (trajeto[0].getLinha() == trajeto[trajeto.length - 1].getLinha() || trajeto[0].getColuna() == trajeto[trajeto.length - 1].getColuna()) {
            return null; //movimento horizontal ou vertical
        }
        if (trajeto[trajeto.length - 1].getTipo() != '-'){ //o target esta ocupado
            return null;
        }
        if (trajeto.length == 3 && trajeto[1].getTipo() == '-'){ //pulando uma casa vazia
            return null;
        }
        if (trajeto.length == 2 && (trajeto[trajeto.length - 1].getLinha() > trajeto[0].getLinha())){
            return null; //movimento para tras sem capturar pecas
        }
        if (trajeto.length == 2){ //avanca uma casa na diagonal
            int [] pecaCapturada = {-1};
            return pecaCapturada;
        }
        int [] pecaCapturada = {trajeto[trajeto.length - 2].getLinha(), trajeto[trajeto.length - 2].getColuna()}; //captura alguem
        return pecaCapturada;
    }

}
