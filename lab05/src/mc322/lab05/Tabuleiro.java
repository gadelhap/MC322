package mc322.lab05;

public class Tabuleiro{
    private TabuleiroDama tabDama;
    private TabuleiroPeao tabPeao;
    Tabuleiro(){
        this.tabDama = new TabuleiroDama();
        this.tabPeao = new TabuleiroPeao();
    }

    public void apresentar() {
        for (int j = 7; j >= 0; j--) {
            System.out.print(j + 1);
            for (int i = 0; i < 8; i++) {
                //verificar se tem dama e ir imprimeindo pelo tab do peao
                if (tabPeao.peoes[i][j].tipo != '-' && tabDama.damas[i][j].tipo == '-'){
                    //talvez trocar por uma funcar de verificar posicao^^^
                    System.out.print(" " + tabPeao.peoes[i][j].tipo);
                } else {
                    System.out.print(" " + tabDama.damas[i][j].tipo);
                }
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }
}
