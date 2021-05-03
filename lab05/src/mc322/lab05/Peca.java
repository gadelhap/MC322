package mc322.lab05;

public class Peca {
    
    protected char tipo; /* vazia '-', peão preto 'p', peão branco 'b', dama
                            preta 'P' ou dama branca 'B' */
    protected int linha, coluna;

    /**
     * tipo: tipo da peça.
     * linha: linha da peça.
     * coluna: coluna da peça.
     * Inicializa uma peça.
     */
    Peca(char tipo, int linha, int coluna) {
        this.tipo = tipo;
        this.linha = linha;
        this.coluna = coluna;
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

    /**
     * Retorna a linha da peça.
     */
    public int getLinha() {
        return this.linha;
    }

    /**
     * Retorna a coluna da peça.
     */
    public int getColuna() {
        return this.coluna;
    }

    public int[] movimentoValido(Peca trajeto[]){
        return null;
    }
}
