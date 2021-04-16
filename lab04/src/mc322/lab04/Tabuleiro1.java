package mc322.lab04;

public class Tabuleiro1{
    Peca1[][] pecas;
    int quantidadePecas;

    Tabuleiro1(){
        this.pecas = new Peca1[7][7];
        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 7; j++){
                if (Funcoes.posicaoValida(i, j)){
                    this.pecas[i][j] = new Peca1(i, j);
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
            System.out.println("Comando inválido: sem movimento.");
            return false;
        }
        if (srcX != tgtX && srcY != tgtY){
            System.out.println("Comando inválido: movimento diagonal.");
            return false;
        }
        if (!Funcoes.posicaoValida(srcX, srcY)){
            System.out.println("Comando inválido: source fora do tabuleiro.");
            return false;
        }
        if (!Funcoes.posicaoValida(tgtX, tgtY)){
            System.out.println("Comando inválido: target fora do tabuleiro.");
            return false;
        }
        if (this.pecas[srcX][srcY] == null){
            System.out.println("Comando inválido: source vazia.");
            return false;
        }
        if (this.pecas[tgtX][tgtY] != null){
            System.out.println("Comando inválido: target ocupada.");
            return false;
        }
        if(Math.abs(srcX - tgtX) > 1 || Math.abs(srcY - tgtY) > 1){
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

    public void executarComando(String comando){
        if (!comandoValido(comando)){
            return;
        }
        int srcX, srcY, tgtX, tgtY, intX, intY;
        srcX = Funcoes.coordXCharParaInteiro(comando.charAt(0));
        srcY = Funcoes.coordYCharParaInteiro(comando.charAt(1));
        tgtX = Funcoes.coordXCharParaInteiro(comando.charAt(3));
        tgtY = Funcoes.coordYCharParaInteiro(comando.charAt(4));
        intX = (srcX + tgtX) / 2;
        intY = (srcY + tgtY) / 2;
        retirarPeca(srcX, srcY);
        retirarPeca(intX, intY);
        colocarPeca(tgtX, tgtY);
    }
    
    public void colocarPeca(int x, int y){
        this.pecas[x][y] = new Peca1(x, y));
    }

    public void retirarPeca(int x, int y){
        this.pecas[x][y] = null;
    }

    public String paraString(){

    } //converte o jogo de matriz para string

    public void apresentar(){

    } //apresenta com a formatacao desejada

}