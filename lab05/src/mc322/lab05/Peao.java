package mc322.lab05;

public class Peao extends Peca{
    public char tipo; //b (brancas), p (pretas), - (nao tem peao -> verificar se eh vazio ou dama)

    Peao(char tipo){
        this.tipo = tipo;
    }

    @Override
    protected void mover() {
        super.mover();
    }
}
