import java.util.ArrayList;

public class Mrbet {
    private String codigo;
    private String nome;
    private String mascote;
    private int length = 0;
    private String campeonato;
    private int participantes;
    boolean contem = false;
    boolean contem2 = false;
    boolean contem3 = false;
    boolean contem4 = false;
    boolean contemCamp = false;
    boolean contemCamp2 = false;
    boolean contemCamp3 = false;
    boolean contemCamp4 = false;
    boolean tentar = false;
    String retornoTime = "";
    String retornoVerifica = "";
    private ArrayList times;
    private ArrayList campeonatos;
    private ArrayList apostas;
    private Campeonato campeonatoCorreto;
    private Campeonato campeonatoCorreto2;
    private Campeonato campeonatoCorretoVerifica;
    private Time timeCorreto;
    private Time timeCorreto2;
    private Time timeCorretoVerifica;

    public Mrbet(){
        this.times = new ArrayList();
        this.campeonatos = new ArrayList();
        this.apostas = new ArrayList();
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
        String retornoCamp = "";
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
            retornoCamp = "CAMPEONATO ADICIONADO!";
        }
        else{
            retornoCamp = "CAMPEONATO JÁ EXISTE!";
        }
        return retornoCamp;
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
        String retorno = "";
        for(int i = 0; i < campeonatos.size(); i++){
            Campeonato camp = (Campeonato) campeonatos.get(i);
            if (camp.getCampeonato().equals(campeonato)){
                campeonatoCorreto = camp;
                contemCamp2 = true;
                break;
            }
        }
        if(!this.contemCamp2){
            retorno = "CAMPEONATO NÃO EXISTE!";
        }
        for(int i = 0; i < times.size(); i++){
            Time objeto = (Time) times.get(i);
            if(codigo.equals(objeto.getCodigo())){
                contem2 = true;
                timeCorreto = objeto;
                break;
            }
        }
        if (!this.contem2) {
            retorno = "TIME NÃO EXISTE!";
        }
        if(this.campeonatoCorreto != null && timeCorreto != null) {
            if (campeonatoCorreto.participantesDisponiveis() == 0) {
                retorno = "TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!";
            }else{
                retorno = "TIME INCLUÍDO NO CAMPEONATO!";
                campeonatoCorreto.getTimes()[campeonatoCorreto.getIndex()] = timeCorreto;
                campeonatoCorreto.addParticipantes();
            }
        }
        return retorno;
    }

    String verificaTimeEmCampeonato(String codigo, String campeonato){
        for(int i = 0; i < campeonatos.size(); i++){
            Campeonato camp = (Campeonato) campeonatos.get(i);
            if (camp.getCampeonato().equals(campeonato)){
                campeonatoCorretoVerifica = camp;
                contemCamp3 = true;
                break;
            }
        }
        for(int i = 0; i < times.size(); i++){
            Time objeto = (Time) times.get(i);
            if(codigo.equals(objeto.getCodigo())){
                contem3 = true;
                timeCorretoVerifica = objeto;
                break;
            }
        }
        if(contem3 && contemCamp3){
            for(int i = 0; i < campeonatoCorretoVerifica.getParticipantes(); i++){
                if(campeonatoCorretoVerifica.getTimes()[i].getCodigo().equals(codigo)){
                    this.retornoVerifica = "é verdade que o time está no campeonato.";
                }else{
                    this.retornoVerifica = "é falso que o time está no campeonato.";
                }
            }
        } else if(!contem3 && contemCamp3){
            this.retornoVerifica = "TIME NÃO EXISTE!";
        } else if(contem3 && !contemCamp3){
            this.retornoVerifica = "CAMPEONATO NÃO EXISTE!";
        }
        return retornoVerifica;
    }

    String tentarSorte(String codigo, String campeonato, int colocacao, String valor){
        String retorno = "";
        for(int i = 0; i < campeonatos.size(); i++){
            Campeonato camp = (Campeonato) campeonatos.get(i);
            if (camp.getCampeonato().equals(campeonato)){
                campeonatoCorreto2 = camp;
                contemCamp4 = true;
                if(colocacao <= campeonatoCorreto2.getParticipantes()){
                    tentar = true;
                    break;
                }
            }
        }
        for(int i = 0; i < times.size(); i++){
            Time objeto = (Time) times.get(i);
            if(codigo.equals(objeto.getCodigo())){
                contem4 = true;
                timeCorreto2 = objeto;
                break;
            }
        }
        if (!this.contem4) {
            retorno = "TIME NÃO EXISTE!";
        }else if(!this.contemCamp4){
            retorno = "CAMPEONATO NÃO EXISTE!";
        }
        else if (!tentar){
            retorno = "APOSTA NÃO REGISTRADA!";
        } else{
            retorno = "APOSTA REGISTRADA!";
            Aposta aposta = new Aposta(codigo, campeonato, colocacao, valor);
            apostas.add(aposta);
        }
        return retorno;
    }

    String getTime(int i){
        Time objeto = (Time)this.times.get(i);
        return objeto.nome();
    }
    int getTimeSize(){
        return times.size();
    }

    public int getCampeonato(int i) {
        return (int) campeonatos.get(i);
    }
}
