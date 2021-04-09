package mc322.lab03;

public class Animacao{
    AquarioLombriga aquarioLombriga;
    String passos;
    int passo;
    /**
     * animacao: string representando estado inicial da lombriga no aquário e
     * sequência de passo da animação.
     * Inicializa uma animação. 
     */
    Animacao(String animacao){
        int tamAquario, tamLombriga, posicao;
        tamAquario = animacao.substring(0, 2);
        tamLombriga = animacao.substring(2, 4);
        posicao = animacao.substring(4, 6);
        this.aquarioLombriga = new AquarioLombriga(tamAquario, tamLombriga, posicao);
        this.passos = animacao.substring(6);
        this.passo = 0;
    }
    /**
     * Imprime na tela o estado atual da lombriga no aquário da animação.
     */
    void apresenta(){
        this.aquarioLombriga.apresenta();
    }
    /**
     * Atualiza a animação realizando o próximo passo.
     */
    void passo(){
        try{
            switch(this.passos[this.passo]){
                case 'C':
                    this.aquarioLombriga.crescer();
                    break;
                case 'M':
                    this.aquarioLombriga.mover();
                    break;
                case 'V':
                    this.aquarioLombriga.virar();
                    break;
            }
            this.passo++;
        }
        catch (StringIndexOutOfBoundsException e){
            return;
        }
    }
}