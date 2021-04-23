package mc322.lab05;

public class TabuleiroDama {
    public Dama[][] damas;

    TabuleiroDama(){
        this.damas = new Dama[8][8];
        for (int i = 0; i < 8; i ++){
            for (int j = 0; j < 8; j ++){
                this.damas[i][j].tipo = '-';
            }
        }
    }
}
