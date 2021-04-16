package mc322.lab04;

public class Peca {
    String posicao; //null caso seja um espaco válido vazio, "!" caso seja invalido

    Peca(String posicao){
        this.posicao = posicao;
    }

    public void movimentarDireita(){
        int l = Funcoes.letraParaInteiro(posicao.charAt(0));
        l += 2;
        this.posicao = Character.toString(Funcoes.inteiroParaLetra(l)) + posicao.charAt(1);
    }
    public void movimentarEsquerda(){
        int l = Funcoes.letraParaInteiro(posicao.charAt(0));
        l -= 2;
        this.posicao = Character.toString(Funcoes.inteiroParaLetra(l)) + posicao.charAt(1);
    }

    public void movimentarCima(){
        int n = Character.getNumericValue(posicao.charAt(1));
        n += 2;
        this.posicao = Character.toString(posicao.charAt(0)) + n;
    }

    public void movimentarBaixo(){
        int n = Character.getNumericValue(posicao.charAt(1));
        n -= 2;
        this.posicao = Character.toString(posicao.charAt(0)) + n;
    }

}
