public class Posicao{
    int x, y;

    /**
     * posicaoString: string de dois caracteres representando x e y,
     * respectivamente. x é uma letra de a a g, e y é um número de 1 a 7.
     * Inicializa uma Posicao.
     */
    Posicao(String posicaoString){
        this.x = posicaoString.charAt(0) - 97;
        this.y = posicaoString.charAt(1) - 49;  /* ou coloco Integer.parseInt()? */
    }

    /**
     * Retorna Posicao em forma de string de dois caracteres representando x e y,
     * respectivamente. x é uma letra de a a g, e y é um número de 1 a 7.
     */
    String devolvePosicao(){
        String posicaoString = "";
        posicaoString += (this.x + 97);
        posicaoString += (this.y + 49);
        return posicaoString;
    }

    /**
     * Retorna true se Posicao é dentro do tabuleiro, e false, caso contrário.
     */
    valida(){
        if ((this.x < 0 || this.x > 6) || (this.y < 0 || this.y > 6)){
            return false;
        }
        else if ((this.x < 2 || this.x > 4) && (this.y < 2 || this.y > 4)){
            return false;
        }
        else{
            return true;
        }
    }
}