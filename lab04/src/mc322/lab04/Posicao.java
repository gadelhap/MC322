public class Posicao{
    int x, y;

    /**
     * posicaoString: string de dois caracteres representando uma posição. O
     * primeiro caractere representa x com uma letra de a a g, e o segundo
     * representa y com um número de 1 a 7.
     * Inicializa uma Posicao.
     */
    Posicao(String posicaoString){
        this.x = posicaoString.charAt(0) - 97;
        this.y = posicaoString.charAt(1) - 49;  /* ou coloco Integer.parseInt()? */
    }

    /**
     * Retorna Posicao em forma de string de dois caracteres. O primeiro
     * caractere representa x com uma letra de a a g, e o segundo representa y
     * com um número de 1 a 7.
     */
    String devolvePosicao(){
        String posicaoString = "";
        posicaoString += (char)(this.x + 97);
        posicaoString += (char)(this.y + 49);
        return posicaoString;
    }

    /**
     * Retorna true se Posicao é dentro do tabuleiro, e false, caso contrário.
     */
    boolean valida(){
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