package mc322.lab04;

public class Peca{
    int x, y;

    /*
    * x: coordenada x de Peca.
    * y: coordeanda y de Peca.
    * Inicializa uma Peca.
     */
    Peca(int x, int y){
        this.x = x;
        this.y = y;
    }

    /*
       novaX: nova coordenada x de Peca.
     * novaY: nova coordeanda y de Peca.
     * Atribui nova posição a Peca.
     */
    void mudarPosicao(int novaX, int novaY){
        this.x = novaX;
        this.y = novaY;
    }
}