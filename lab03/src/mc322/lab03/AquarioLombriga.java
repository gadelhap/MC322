package mc322.lab03;

public class AquarioLombriga{
    int tamAquario, tamLombriga, posicao; /* Posição da cauda. */
    boolean orientacaoDireita;
    /**
     * tamAquario: tamanho do aquário;
     * tamLombriga: tamanho da lombriga;
     * posicao: posição do lombriga;
     * Inicializa uma lombriga em um aquário orientada para a direita.
     */
    AquarioLombriga(int tamAquario, int tamLombriga, int posicao){
        if (posicao + tamLombriga - 1 > tamAquario){
            posicao = 1;
        }
        if (tamLombriga > tamAquario){
            tamAquario = tamLombriga;
        }
        this.tamAquario = tamAquario;
        this.tamLombriga = tamLombriga;
        this.posicao = posicao;
        this.orientacaoDireita = true;
    }
    /**
     * Retorna true caso a lombriga tenha crescido de tamanho em 1 unidade na
     * direção da cauda ou false, caso contrário.
     */
    boolean crescer(){
        if ((this.orientacaoDireita && this.posicao == 1) ||
            (!this.orientacaoDireita && this.posicao == this.tamAquario)){
            return false;
        }
        else{
            this.tamLombriga++;
            if (orientacaoDireita){
                this.posicao--;
            }
            else{
                this.posicao++;
            }
            return true;
        }
    }
    /**
     * Vira a orientação da cabeça da lombriga.
     */
    void virar(){
        if (this.orientacaoDireita){
            this.posicao += this.tamLombriga - 1;
        }
        else{
            this.posicao -= this.tamLombriga - 1;
        }
        this.orientacaoDireita = !this.orientacaoDireita;
    }
    /**
     * Retorna true, caso a lombriga se mova 1 unidade na direção da cabeça, ou
     * false, caso esteja no limite do aquário e se vire.
     */
    boolean mover(){
        if ((this.orientacaoDireita && this.posicao == this.tamAquario - this.tamLombriga + 1) ||
        (!this.orientacaoDireita && this.posicao == this.tamLombriga)){
            virar();
            return false;
        }
        else{
            if (this.orientacaoDireita){
                this.posicao++;
            }
            else{
                this.posicao--;
            }
            return true;
        }
    }
    /**
     * Imprime na tela a lombriga no aquário em que # representa espaço vazio,
     * @ representa o corpo da lombriga e 0 representa sua cabeça.
     */
    void apresenta(){
        String aquarioLombriga;
        aquarioLombriga = "";
        if (this.orientacaoDireita){
            for (int i = 0; i < this.posicao - 1; i++){
                aquarioLombriga += '#';
            }
            for (int i = 0; i < this.tamLombriga - 1; i++){
                aquarioLombriga += '@';
            }
            aquarioLombriga += '0';
            for (int i = 0; i < this.tamAquario - this.posicao - this.tamLombriga + 1; i++){
                aquarioLombriga += '#';
            }
        }
        else{
            for (int i = 0; i < this.posicao - this.tamLombriga; i++){
                aquarioLombriga += '#';
            }
            aquarioLombriga += '0';
            for (int i = 0; i < this.tamLombriga - 1; i++){
                aquarioLombriga += '@';
            }
            for (int i = 0; i < this.tamAquario - this.posicao; i++){
                aquarioLombriga += '#';
            }
        }
        System.out.println(aquarioLombriga);
    }
}