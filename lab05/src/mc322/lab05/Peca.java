package mc322.lab05;

public class Peca {
    
    protected char tipo; /* vazia ('-'), peão preto 'p', peão branco 'b', dama
                            preta 'P' ou dama branca 'B' */
    
    /**
     * tipo: tipo da peça.
     * Inicializa uma peça.
     */
    Peca(char tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna o tipo da peça.
     */
    public char getTipo() {
        return this.tipo;
    }

    /**
     * tipo: tipo novo para a peça.
     * Altera o tipo da peça.
     */
    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public boolean movimentoValido(int[][] trajeto);
}
