import java.util.ArrayList;

public class Mrbet {
    private String codigo;
    private String nome;
    private String mascote;
    private int length = 0;
    private String campeonato;
    private int participantes;
    boolean contem = false;
    boolean contemCamp = false;
    String retornoTime = "";
    private ArrayList times;
    private ArrayList campeonatos;

    public Mrbet(){
        this.times = new ArrayList();
        this.campeonatos = new ArrayList();
    }

    String cadastrarTime(String codigo, String nome, String mascote){
        String retorno = "";
        for(int i = 0; i < times.size(); i++){
            Time objeto = (Time) times.get(i);
            if(codigo.equals(objeto.getCodigo())){
                contem = true;
                break;
            }
        }
        if(!this.contem){
            Time time = new Time(codigo, nome, mascote);
            times.add(time);
            retorno = "INCLUSÃO REALIZADA!";
        }
        else{
            retorno = "TIME JÁ EXISTE!";
        }
        return retorno;
    }

    String cadastrarCampeonato(String campeonato, int participantes){
        String retorno = "";
        for(int i = 0; i < campeonatos.size(); i++){
            Campeonato objeto = (Campeonato) campeonatos.get(i);
            if (campeonato.equals(objeto.getCampeonato())) {
                contemCamp = true;
                break;
            }
        }
        if(!this.contemCamp){
            Campeonato camp = new Campeonato(campeonato, participantes);
            campeonatos.add(camp);
            retorno = "CAMPEONATO ADICIONADO!";
        }
        else{
            retorno = "CAMPEONATO JÁ EXISTE!";
        }
        return retorno;
    }

    String recuperarTime(String codigo){
        for(int i = 0; i < times.size(); i++){
            Time objeto = (Time) times.get(i);
            if(codigo.equals(objeto.getCodigo())){
                this.retornoTime = objeto.time();
            }
            else{
                this.retornoTime = "TIME NÃO EXISTE!";
            }
        }
        return this.retornoTime;
    }

    String incluiTimeEmCampeonato(String codigo, String campeonato){
        return "";
    }

    String verificaTimeEmCampeonato(String codigo, String campeonato){
        return "";
    }

    String getTime(int i){
        Time objeto = (Time)this.times.get(i);
        return objeto.nome();
    }
    int getTimeSize(){
        return times.size();
    }

    public int getLength() {
        return length;
    }

    public int getCampeonato(int i) {
        return (int) campeonatos.get(i);
    }
}
