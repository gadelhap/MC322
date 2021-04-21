package mc322.lab04;

public class Peca {
    
    private char tipo; /* P, peça, ou -, vazio*/

    /*
    * tipo: true, caso seja uma peça, ou false, caso seja um espaço vazio.
    * Inicializa uma Peca.
     */
    Peca(boolean tipo) {
        this.tipo = (tipo ? 'P' : '-');
    }

    /**
     * Retorna o tipo da peça.
     */
    char tipo(){
        return this.tipo;
    }
}