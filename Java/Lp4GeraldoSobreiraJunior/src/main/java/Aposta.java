public class Aposta {
    private String codigo;
    private String campeonato;
    private int colocaçao;
    private String valor;
    private String status = "";

    Mrbet mrbet = new Mrbet();

    public Aposta(String codigo, String campeonato, int colocaçao, String valor){
        this.codigo = codigo;
        this.campeonato = campeonato;
        this.colocaçao = colocaçao;
        this.valor = valor;
    }
    String status(){
        for(int i = 0; i < mrbet.getTimeSize(); i++) {
            this.status += mrbet.getTime(i) + '\n' + "Campeonato: " + campeonato + '\n' +"Colocação: " + colocaçao + " / " + mrbet.getCampeonato(i) + '\n' + " Valor da Aposta: " + valor + '\n';
        }
        return this.status;
    }
}
