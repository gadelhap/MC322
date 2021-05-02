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
     * sourceI: linha da source.
     * sourceJ: coluna da source.
     * targetI: linha do target.
     * targetJ: coluna do target.
     * Retorna um vetor com as peças de um trajeto entre as posições source e
     * target no tabuleiro, sendo a peça na source o primeiro item do vetor e
     * a peça no target, o último.
     */
    private Peca[] determinarTrajeto(int sourceI, int sourceJ, int targetI, int targetJ) {
        Peca trajeto[];
        if (sourceI != targetI && sourceJ != targetJ) {
            int incrementoI = (sourceI < targetI) ? 1 : -1;
            int incrementoJ = (sourceJ < targetJ) ? 1 : -1;
            for (int i = sourceI; i != targetI + incremento; i += incrementoI) {
                for (int j = sourceJ; j != targetJ + incremento; j += incrementoJ) {

                }
            }
        }
        
    }

    private void solicitaMovimento(String comando) {}

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