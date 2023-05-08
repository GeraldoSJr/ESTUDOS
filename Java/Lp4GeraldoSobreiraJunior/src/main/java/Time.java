public class Time {
    private String codigo;
    private String nome;
    private String mascote;
    public Time(String codigo, String nome, String mascote){
        this.codigo = codigo;
        this.nome = nome;
        this.mascote = mascote;
    }
    String nome(){
        return nome + " / " + mascote;
    }

    String time(){
        return "[" + this.codigo + "] " + nome();
    }

    public String getCodigo() {
        return this.codigo;
    }
}
