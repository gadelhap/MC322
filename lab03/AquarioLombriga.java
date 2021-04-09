package lab03;

public class AquarioLombriga{
    int tamLombriga, tamAquario, posicao; /* Posição da cauda. */
    boolean orientacaoDireita;
    /**
    * Inicializa uma lombriga de dado tamanho, em um aquário de dado tamanho,
    * em uma dada posição virada para a direita.
    */
    AquarioLombriga(int tamLombriga, int tamAquario, int posicao){
        if (posicao + tamLombriga - 1 > tamAquario){
            posicao = 1;
        }
        if (tamLombriga > tamAquario){
            tamAquario = tamLombriga;
        }
        this.tamLombriga = tamLombriga;
        this.tamAquario = tamAquario;
        this.posicao = posicao;
        this.orientacaoDireita = true;
    }
}