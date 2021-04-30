package mc322.lab05;

public class Dama extends Peca{

    /**
     * tipo: tipo da dama.
     * Inicializa uma dama.
     */
    Dama(char tipo) {
        super(tipo);
    }

    /**
     * trajeto: vetor com as posições do trajeto, em que a primeira posição é a
     * da dama na source e a última é o target.
     * Retorna true se o movimento é válido.
     */
    public boolean movimentoValido(int[][] trajeto) {
        if (trajeto[0][0] == trajeto[trajeto.length - 1][0] || trajeto[0][1] == trajeto[trajeto.length - 1][1]){
            return false;
        }
        if (trajeto.length < 3){
            return false;
        }
        if (!Posicao.valida(trajeto[trajeto.length - 1][0], trajeto[trajeto.length - 1][1])) {
            return false;
        }
        this.tipo = '-';
        return true;
    }


}
