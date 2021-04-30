package mc322.lab05;

public class Posicao {

    /**
     * x: coordenada x em forma de char, partindo de 'a'.
     * Retorna a coordenada x em forma de int, partindo de 0.
     */
    public static int coordXCharParaInteiro(char x) {
        return (int)x - (int)('a');
    }

    /**
     * x: coordenada x em forma de int, partindo de 0.
     * Retorna a coordenada x em forma de char, partindo de 'a'.
     */
    public static char coordXInteiroParaChar(int x) {
        return (char)(x + (int)('a'));
    }
    
    /**
     * y: coordenada y em forma de char, partindo de '1'.
     * Retorna a coordenada y em forma de int partindo de 0.
     */
    public static int coordYCharParaInteiro(char y) {
        return (int)y - (int)('1');
    }

    /**
     * y: coordenada y em forma de int, partindo de 0.
     * Retorna a coordenada y em forma de char, partindo de '1'.
     */
    public static char coordYInteiroParaChar(int y) {
        return (char)(y + (int)('1'));
    }

    /**
     * x: coordenada x.
     * y: coordenada y.
     * Retorna true se a posição é dentro do tabuleiro, e false, caso contrário.
     */
    public static boolean valida(int x, int y) {
        if ((x < 0 || x > 7) || (y < 0 || y > 7)) {
            return false;
        } else {
            return true;
        }
    }
}
