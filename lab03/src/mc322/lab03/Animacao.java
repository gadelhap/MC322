package mc322.lab03;

public class Animacao{
    AquarioLombriga aquarioLombriga;
    String passos;
    int passo;
    Animacao(String animacao){
        int tamAquario, tamLombriga, posicao;
        tamAquario = animacao.substring(0, 2);
        tamLombriga = animacao.substring(2, 4);
        posicao = animacao.substring(4, 6);
        this.aquarioLombriga = new AquarioLombriga(tamAquario, tamLombriga, posicao);
        this.passos = animacao.substring(6);
        this.passo = 0;
    }
}