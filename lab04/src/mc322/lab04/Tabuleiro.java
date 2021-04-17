package mc322.lab04;

public class Tabuleiro{
    Peca[][] pecas;
    int quantidadePecas;

    Tabuleiro(){
        this.pecas = new Peca[7][7];
        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 7; j++){
                if (Funcoes.posicaoValida(i, j)){
                    this.pecas[i][j] = new Peca(i, j);
                }
                else{
                    this.pecas[i][j] = null;
                }
            }
        }
        pecas[3][3] = null;
        this.quantidadePecas = 32;
    }

    public boolean comandoValido(String comando){
        int srcX, srcY, tgtX, tgtY, intX, intY;
        srcX = Funcoes.coordXCharParaInteiro(comando.charAt(0));
        srcY = Funcoes.coordYCharParaInteiro(comando.charAt(1));
        tgtX = Funcoes.coordXCharParaInteiro(comando.charAt(3));
        tgtY = Funcoes.coordYCharParaInteiro(comando.charAt(4));
        if (srcX == tgtX && srcY == tgtY){
            System.out.println("Comando inválido: peça movida para o mesmo local de origem.");
            return false;
        }
        if (srcX != tgtX && srcY != tgtY){
            System.out.println("Comando inválido: movimento diagonal.");
            return false;
        }
        if (!Funcoes.posicaoValida(srcX, srcY)){
            System.out.println("Comando inválido: peça fora do tabuleiro.");
            return false;
        }
        if (!Funcoes.posicaoValida(tgtX, tgtY)){
            System.out.println("Comando inválido: movimento para fora do tabuleiro.");
            return false;
        }
        if (this.pecas[srcX][srcY] == null){
            System.out.println("Comando inválido: não há peçã na posição de origem.");
            return false;
        }
        if (this.pecas[tgtX][tgtY] != null){
            System.out.println("Comando inválido: já possui uma peça na posicao de destino.");
            return false;
        }
        if(Math.abs(srcX - tgtX) > 2 || Math.abs(srcY - tgtY) > 2){
            System.out.println("Comando inválido: mais de uma peça intermediária.");
            return false;
        }
        intX = (srcX + tgtX) / 2;
        intY = (srcY + tgtY) / 2;
        if (this.pecas[intX][intY] == null){
            System.out.println("Comando inválido: sem peça intermediária.");
            return false;
        }
        return true;
    }

    public void colocarPeca(int x, int y){
        this.pecas[x][y] = new Peca(x, y);
    }

    public void retirarPeca(int x, int y){
        this.pecas[x][y] = null;
    }

    public void executarComando(String comando){
        if (!comandoValido(comando)){
            return;
        }
        int srcX, srcY, tgtX, tgtY, intX, intY;
        srcX = Funcoes.coordXCharParaInteiro(comando.charAt(0));
        srcY = Funcoes.coordYCharParaInteiro(comando.charAt(1));
        tgtX = Funcoes.coordXCharParaInteiro(comando.charAt(3));
        tgtY = Funcoes.coordYCharParaInteiro(comando.charAt(4));
        intX = (srcX + tgtX) / 2; // posicao da
        intY = (srcY + tgtY) / 2; // peca comida
        retirarPeca(srcX, srcY);
        retirarPeca(intX, intY);
        colocarPeca(tgtX, tgtY);
    }

    public String paraString(){
        String tab = "";
        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 7; j++){
                if (Funcoes.posicaoValida(i, j)){
                    if (pecas[i][j] != null){
                        tab += "P";
                    } else {
                        tab += "-";
                    }
                } else {
                    tab += " ";
                }
            }
        }
        return tab;
    } //converte o jogo de matriz para string

    public void apresentar(){
        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 7; j++){
                System.out.print(7 - i);
                if (Funcoes.posicaoValida(i, j)){
                    if (pecas[i][j] != null){
                        System.out.print(" P");
                    } else {
                        System.out.print(" -");
                    }
                } else {
                    System.out.print("  "); //2 espacos
                }
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g");
    } //apresenta com a formatacao desejada
}