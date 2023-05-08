import java.util.ArrayList;

public class MeuDesafioController {
    private String[] desafios;
    private String[] execDesafios;
    private String[] Acao;
    private int i = 1;
    private Desafio desafio;
    private Acao acao;

    public MeuDesafioController(){
        desafios = new String[10000];
        execDesafios = new String[10000];
        Acao = new String[100000];
    }

    private int ADD_DESAFIO(String titulo){
        desafio = new Desafio(titulo);
        desafios[i] = desafio.toString();
    }
}
