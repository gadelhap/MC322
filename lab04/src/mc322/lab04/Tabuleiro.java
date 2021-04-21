package mc322.lab04;

public class Tabuleiro {
    
    private Peca[][] pecas;

    /**
     * Inicializa um Tabuleiro.
     */
    Tabuleiro() {
        this.pecas = new Peca[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (Posicao.valida(i, j)) {
                    colocarPeca(i, j);
                } else {
                    this.pecas[i][j] = null;
                }
            }
        }
        retirarPeca(3, 3);
    }

    /**
     * x: coordenada x.
     * y: coordenada y.
     * Coloca uma peça na posição dada, caso válida.
     */
    private void colocarPeca(int x, int y) {
        if (Posicao.valida(x, y)) {
            this.pecas[x][y] = new Peca(true);;
        }
    }

    /**
     * x: coordenada x.
     * y: coordenada y.
     * Retira uma peça da posição dada, caso válida.
     */
    private void retirarPeca(int x, int y) {
        if (Posicao.valida(x, y)) {
            this.pecas[x][y] = new Peca(false);
        }
    }

    /**
     * comando: comando na forma "x1y1:x2y2", em que x1y1 é a posicão de uma
     * peça a ser movida para a posição x2y2.
     * Retorna true, caso seja um comando válido, e false, caso contrário.
     */
    private boolean comandoValido(String comando) {
        int srcX, srcY, tgtX, tgtY, intX, intY;
        srcX = Posicao.coordXCharParaInteiro(comando.charAt(0));
        srcY = Posicao.coordYCharParaInteiro(comando.charAt(1));
        tgtX = Posicao.coordXCharParaInteiro(comando.charAt(3));
        tgtY = Posicao.coordYCharParaInteiro(comando.charAt(4));
        if (srcX == tgtX && srcY == tgtY) {
            System.out.println("Comando inválido: peça movida para a source.");
            return false;
        }
        if (srcX != tgtX && srcY != tgtY) {
            System.out.println("Comando inválido: movimento diagonal.");
            return false;
        }
        if (!Posicao.valida(srcX, srcY)) {
            System.out.println("Comando inválido: source fora do tabuleiro.");
            return false;
        }
        if (!Posicao.valida(tgtX, tgtY)) {
            System.out.println("Comando inválido: target fora do tabuleiro.");
            return false;
        }
        if (this.pecas[srcX][srcY].tipo() == '-') {
            System.out.println("Comando inválido: não há peça na source.");
            return false;
        }
        if (this.pecas[tgtX][tgtY].tipo() == 'P') {
            System.out.println("Comando inválido: já há peça na target.");
            return false;
        }
        if(Math.abs(srcX - tgtX) > 2 || Math.abs(srcY - tgtY) > 2) {
            System.out.println("Comando inválido: mais de uma peça intermediária.");
            return false;
        }
        intX = (srcX + tgtX) / 2;
        intY = (srcY + tgtY) / 2; // posição da peça intermediária a ser comida.
        if (this.pecas[intX][intY].tipo() == '-' ||
                (Math.abs(srcX - intX) < 1 && Math.abs(srcY - intY) < 1)) {
            System.out.println("Comando inválido: não há peça intermediária.");
            return false;
        }
        return true;
    }

    /**
     * comando: comando na forma "x1y1:x2y2", em que x1y1 é a posicão de uma
     * peça a ser movida para a posição x2y2.
     * Executa o comando.
     */
    public void executarComando(String comando) {
        int srcX, srcY, tgtX, tgtY, intX, intY;
        if (!comandoValido(comando)) {
            return;
        }
        srcX = Posicao.coordXCharParaInteiro(comando.charAt(0));
        srcY = Posicao.coordYCharParaInteiro(comando.charAt(1));
        tgtX = Posicao.coordXCharParaInteiro(comando.charAt(3));
        tgtY = Posicao.coordYCharParaInteiro(comando.charAt(4));
        intX = (srcX + tgtX) / 2;
        intY = (srcY + tgtY) / 2; // posição da peça intermediária a ser comida.
        retirarPeca(srcX, srcY);
        retirarPeca(intX, intY);
        colocarPeca(tgtX, tgtY);
    }

    /**
     * Retorna o tabuleiro em forma de string em que espaços vazios são '-',
     * espaços com peça, 'P', e espaços fora do tabuleiro, ' ', pulando uma
     * linha para cada linha.
     */
    public String paraString() {
        String tabuleiro = "";
        for (int j = 6; j >= 0; j--) {
            for (int i = 0; i < 7; i++) {
                if (Posicao.valida(i, j)) {
                    tabuleiro += this.pecas[i][j].tipo();
                } else {
                    tabuleiro += ' ';
                }
            }
            tabuleiro += '\n';
        }
        return tabuleiro;
    }

    /**
     * Imprime o tabuleiro com o eixo de coordenadas na tela.
     */
    public void apresentar() {
        for (int j = 6; j >= 0; j--) {
            System.out.print(j + 1);
            for (int i = 0; i < 7; i++) {
                if (Posicao.valida(i, j)) {
                    System.out.print(" " + pecas[i][j].tipo());
                } else {
                    System.out.print("  "); //2 espacos
                }
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g");
    }
}