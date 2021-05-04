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
     * trajeto: vetor com as peças do trajeto, em que a primeira é a peça
     * imediatamente após a source e a última é a peça no target.
     * Retorna a quantidade de peças não vazias no trajeto.
     */
    private int pecasIntermediarias(Peca[] trajeto) {
        int n = 0;
        for (int ponto = 0; ponto < trajeto.length - 1; ponto++){
            if (trajeto[ponto].getTipo() != '-'){
                n++;
            }
        }
        return n;
    }

    /**
     * trajeto: vetor com as peças do trajeto, em que a primeira é a peça
     * imediatamente após a source e a última é a peça no target.
     * Retorna a posição da peça capturada caso haja captura, um vetor com
     * apenas -1 caso não haja captura e null caso seja um movimento inválido.
     */
    public int[] movimentoValido(Peca[] trajeto) {
        if (this.tipo == '-') { //source vazia.
            return null;
        }
        if (trajeto[trajeto.length - 1] == null) { //target fora do tabuleiro.
            return null;
        }
        if (trajeto.length == 0) { //movimento para o source.
            return null;
        }
        if (this.linha == trajeto[trajeto.length - 1].getLinha() || this.coluna == trajeto[trajeto.length - 1].getColuna()) { //movimento horizontal ou vertical.
            return null;
        }
        if (trajeto[trajeto.length - 1].getTipo() != '-') { //target ocupado.
            return null;
        }
        int n = pecasIntermediarias(trajeto);
        if (n > 1) { //pulando mais de uma peça.
            return null;
        }
        if (n == 0) { //movimento simples.
            int pecaCapturada[] = {-1};
        } else { //movimento com captura.
            for (int contador = 0; contador < trajeto.length - 1; contador++) {
                if (trajeto[contador].getTipo() != '-') {
                    int [] pecaCapturada = {trajeto[contador].getLinha(), trajeto[contador].getColuna()};
                    break;
                }
            }
        }
        return pecaCapturada;
    }
}