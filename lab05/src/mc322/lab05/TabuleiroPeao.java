package mc322.lab05;

public class TabuleiroPeao {
    public Peao[][] peoes;

    TabuleiroPeao() {
        Peao[][] peoes = new Peao[8][8];
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if(i < 3){ //incompleto

                } else {
                    peoes[i][j] = new Peao('-');
                }
            }
        }
    }


}
