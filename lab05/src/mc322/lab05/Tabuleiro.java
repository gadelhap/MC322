package mc322.lab05;

public class Tabuleiro {
    
    private Peca[][] pecas;

    /**
     * Inicializa um Tabuleiro.
     */
    Tabuleiro() {
        this.pecas = new Peca[8][8];
        for (int i = 0; i < 3; i++) {
            if (i == 0 || i == 2) {
                for (int j = 0; j < 8; j += 2) {
                    this.pecas[i][j] = new Peca('-');
                    this.pecas[i][j + 1] = new Peao('b');
                }
            } else {
                for (int j = 0; j < 8; j += 2) {
                    this.pecas[i][j] = new Peao('b');
                    this.pecas[i][j + 1] = new Peca('-');
                }
            }
        }
        for (int i = 3; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                this.pecas[i][j] = new Peca('-');
            }
        }
        for (int i = 5; i < 8; i++) {
            if (i == 5 || i == 7) {
                for (int j = 0; j < 8; j += 2) {
                    this.pecas[i][j] = new Peao('p');
                    this.pecas[i][j + 1] = new Peca('-');
            } else {
                for (int j = 0; j < 8; j += 2) {
                    this.pecas[i][j] = new Peca('-');
                    this.pecas[i][j + 1] = new Peao('p');
                }
            }
        }
    }

    /**
     * Retorna o tabuleiro em forma de string com os tipos das peças, pulando
     * uma linha para cada linha.
     */
    public String paraString() {
        String tabuleiro = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tabuleiro += this.pecas[i][j].getTipo();
            }
            tabuleiro += '\n';
        }
        return tabuleiro;
    }

    /**
     * Imprime o tabuleiro com o eixo de coordenadas na tela.
     */
    public void apresentar() {
        for (int i = 0; i < 8; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < 8; j++) {
                System.out.print(" " + pecas[i][j].getTipo());
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }
}