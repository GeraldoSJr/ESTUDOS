public class Desafio {
    private String titulo;
    private int execuções = 0;
    public Desafio(String titulo){
        this.titulo = titulo;
    }

    public int getExecuções() {
        return execuções;
    }

    public String toString(){
        String descricao = "Título:" + this.titulo + "\n" + execuções + "execuções";
    }
}
