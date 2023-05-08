package Lula;

public class Comitivas {
    private int idComitiva;
    private String descricao;
    private int qtdPessoas;
    private String fone;
    private String toString = "";

    public Comitivas(int idComitiva, String descricao, int qtdPessoas, String fone){
        this.idComitiva = idComitiva;
        this.descricao = descricao;
        this.qtdPessoas = qtdPessoas;
        this.fone= fone;
    }

    public String toString() {
        toString = "ID: " + this.idComitiva + "\nComitiva: "+ descricao + "\nIntegrantes: "+ qtdPessoas + "\nContato: " + fone;
        return toString;
    }
}
