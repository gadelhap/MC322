package mc322.lab05;

public class Tabuleiro{
    Peca[][] pecas;
    Tabuleiro(){

    }

    public void apresentar() {
        for (int j = 7; j >= 0; j--) {
            System.out.print(j + 1);
            for (int i = 0; i < 8; i++) {
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }
}
