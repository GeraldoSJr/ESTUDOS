import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Wally {
/**
 * Wally mudou de nome, para um nome de 5 letras, receba uma String de nomes e
 * encontre qual o nome dele, imprima o ultimo nome possivel.
 * */

    public static void main(String[] args) {
        String[] nomesPossiveis;
        String nomecerto = "";
        Scanner sc = new Scanner(System.in);
        String pergunta = sc.nextLine();
        nomesPossiveis = pergunta.split(" ");
        System.out.println(Arrays.toString(nomesPossiveis));
        for (int i = 0; i < nomesPossiveis.length; i+=1){
            if (nomesPossiveis[i].length() == 5){
                nomecerto = nomesPossiveis[i];
            }
        }
        System.out.println(nomecerto);
    }
}
