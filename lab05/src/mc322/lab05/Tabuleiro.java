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
                    this.pecas[i][j] = new Peca('-', i, j);
                    this.pecas[i][j + 1] = new Peao('b', i, j + 1);
                }
            } else {
                for (int j = 0; j < 8; j += 2) {
                    this.pecas[i][j] = new Peao('b', i, j);
                    this.pecas[i][j + 1] = new Peca('-', i, j + 1);
                }
            }
        }
        for (int i = 3; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                this.pecas[i][j] = new Peca('-', i, j);
            }
        }
        for (int i = 5; i < 8; i++) {
            if (i == 5 || i == 7) {
                for (int j = 0; j < 8; j += 2) {
                    this.pecas[i][j] = new Peao('p', i, j);
                    this.pecas[i][j + 1] = new Peca('-', i, j + 1);
                }
            } else {
                for (int j = 0; j < 8; j += 2) {
                    this.pecas[i][j] = new Peca('-', i, j);
                    this.pecas[i][j + 1] = new Peao('p', i, j + 1);
                }
            }
        }
    }

    /**
     * srcI: linha da source.
     * srcJ: coluna da source.
     * tgtI: linha do target.
     * tgtJ: coluna do target.
     * Retorna um vetor com as peças de um trajeto entre as posições source e
     * target no tabuleiro, sendo a peça na source o primeiro item do vetor e
     * a peça no target, o último.
     */
    private Peca[] determinarTrajeto(int srcI, int srcJ, int tgtI, int tgtJ) {
        Peca trajeto[];
        int tamanho = (tgtI != srcI) ? (Math.abs(tgtI - srcI) + 1) : (Math.abs(tgtJ - srcJ) + 1); /* calcula o tamanho de acordo com o tipo de trajeto: diagonal, vertical ou horizontal */
        trajeto = new Peca[tamanho];
        int i = srcI;
        int j = srcJ;
        int incrementoI = (tgtI - srcI) / (tamanho - 1);
        int incrementoJ = (tgtJ - srcJ) / (tamanho - 1);
        for (int ponto = 0; ponto < tamanho; ponto++) {
            trajeto[ponto] = this.pecas[i][j];
            i += incrementoI;
            j += incrementoJ;
        }
        return trajeto;
    }

    /**
     * comando: string no formato sJsI:tJtI, em que sJsI é a coluna e a linha
     * da posição inicial e tJtI, da posição final.
     * Atualiza o tabuleiro de acordo com um comando válido.
     * Se o movimento for válido e tiver peça capturada ele move.
     * Se não for válido ele retorna o vetor [-1]
     */
    public void solicitaMovimento(String comando) {
        int srcI = Posicao.linhaCharParaInteiro(comando.charAt(1));
        int srcJ = Posicao.colunaCharParaInteiro(comando.charAt(0));
        int tgtI = Posicao.linhaCharParaInteiro(comando.charAt(4));
        int tgtJ = Posicao.colunaCharParaInteiro(comando.charAt(3));
        Peca trajeto[] = determinarTrajeto(srcI, srcJ, tgtI, tgtJ);
        int pecaCapturada[] = this.pecas[srcI][srcJ].movimentoValido(trajeto); //null se o movimento eh invalido, nao null se permitido (tamanho 1 sem peça comida e tamanho 2 com peça comida)
        if (pecaCapturada != null) {
            this.pecas[tgtI][tgtJ].setTipo(this.pecas[srcI][srcJ].getTipo());
            this.pecas[srcI][srcJ].setTipo('-');
            if (pecaCapturada.length >= 2) {
                this.pecas[pecaCapturada[0]][pecaCapturada[1]].setTipo('-');
            } else {
                System.out.println("Movimento inválido, Senhor");
            }
        }
    }

    /**
     * path: caminho para um arquivo CSV.
     * Escreve no arquivo as casas do tabuleiro, uma a cada linha, coluna por
     * coluna. As casas são as posições ji seguidas da respectiva peça: vazia
     * '_', peça branca 'b' ou peça preta 'p'.
     */
    public void exportarArquivo(String path) {
        CSVHandling csv = new CSVHandling();
        String tabuleiro[] = new String[8 * 8];
        char coluna, linha;
        for (int j = 0; j < 8; j++) {
            coluna = Posicao.colunaInteiroParaChar(j);
            for (int i = 0; i < 8; i++) {
                linha = Posicao.linhaInteiroParaChar(i);
                tabuleiro[j * 8 + i] += coluna + linha;
                if (this.pecas[i][j].getTipo() == '-') {
                    tabuleiro[j * 8 + i] += '_';
                } else {
                    tabuleiro[j * 8 + i] += Character.toLowerCase(this.pecas[i][j].getTipo());
                }
            }
        }
        csv.setDataExport(path);
        csv.exportState(tabuleiro);
    }

    /**
     * Imprime o tabuleiro com o eixo de coordenadas na tela.
     */
    public void imprimirTabuleiro() {
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