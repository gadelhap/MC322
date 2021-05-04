package mc322.lab05;

public class Dama extends Peca {

    /**
     * tipo: tipo da dama.
     * Inicializa uma dama.
     */
    Dama(char tipo, int linha, int coluna) {
        super(tipo, linha, coluna);
    }

    private int pecasNoCaminho(Peca[] trajeto){ //verifica quantas pecas tem no caminho do source ate o target da dama
        int n = 0;
        for (int i = 1; i < trajeto.length - 1; i++){
            if (trajeto[i].getTipo() != '-'){
                n += 1;
            }
        }
        return n;
    }
    /**
     * trajeto: vetor com as peças do trajeto, em que a primeira é a peça na
     * source e a última é a peça no target.
     * Retorna um vetor com duas posições caso seja válido e capturado uma peça
     * Um vetor com um único elemento se válido e não capturou peça
     * Null caso seja inválido
     */
    public int[] movimentoValido(Peca[] trajeto) {
        if (trajeto[0] == null || trajeto[trajeto.length - 1] == null){
            return null; //fora dos limites
        }
        if (trajeto.length < 2){ //movimento pro source
            return null;
        }
        if (trajeto[0].getLinha() == trajeto[trajeto.length - 1].getLinha() || trajeto[0].getColuna() == trajeto[trajeto.length - 1].getColuna()) {
            return null; //movimento horizontal ou vertical
        }
        if (trajeto[trajeto.length - 1].getTipo() != '-'){ //o target esta ocupado
            return null;
        }
        int n = pecasNoCaminho(trajeto);
        if (n > 1){ //pulando mais de uma peça
            return null;
        }
        if (n < 1){
            int [] pecaCapturada = {-1};
            return pecaCapturada;
        }
        if (trajeto[trajeto.length - 2].getTipo() == '-'){
            return null;
        }
        int [] pecaCapturada = {trajeto[trajeto.length - 2].getLinha(), trajeto[trajeto.length - 2].getColuna()}; //captura alguem
        return pecaCapturada;
    }
}