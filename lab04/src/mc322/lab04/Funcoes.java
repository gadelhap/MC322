package mc322.lab04;

public class Funcoes {
    public static int letraParaInteiro(char letra){
        return (int)letra - (int)('a');
    }

    public static char inteiroParaLetra(int i){
        return (char)(i + (int)('a'));
    }
}
