package mc322.lab04;

public class Peca {
    String posicao; //"0" caso seja um espaco válido vazio, "!" caso seja invalido

    Peca(String posicao){
        this.posicao = posicao;
    }

    public int letraParaInteiro(char letra){
        return (int)letra - (int)('a');
    }

    public void movimentarDireita(){

    }
    public void movimentarEsquerda(){

    }

    public void movimentarCima(){

    }

    public void movimentarBaixo(){

    }

}
