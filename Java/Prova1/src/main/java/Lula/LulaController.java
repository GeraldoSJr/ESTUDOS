package Lula;

public class LulaController {
    private String[] idsLocais;
    private String[] strsLocais;
    private int[] idsComitivas;
    private String[] strsComitivas;
    private String idLocal;
    private String nomeLocal;
    private String ramal;
    private int idComitiva;
    private String descricao;
    private int qtdPessoas;
    private String fone;
    private int index1 = 0;
    private int index2 = 0;
    Comitivas comitiva;
    Local local;
    public LulaController(){
        this.idsComitivas = new int[100];
        this.idsLocais = new String[100];
        this.strsLocais = new String[100];
        this.strsComitivas = new String[100];
    }
    public void CAD_LOCAL(String idLocal, String nomeLocal, String ramal){
        this.local = new Local(idLocal, nomeLocal, ramal);
        this.idLocal = idLocal;
        this.nomeLocal = nomeLocal;
        this.ramal = ramal;
        idsLocais[index1] = idLocal;
        strsLocais[index1] = local.toString();
        index1 +=1;
    }
    public void CAD_COMITIVA(int idComitiva, String descricao, int qtdPessoas, String fone){
        this.comitiva = new Comitivas(idComitiva, descricao, qtdPessoas, fone);
        this.idComitiva = idComitiva;
        this.descricao = descricao;
        this.qtdPessoas = qtdPessoas;
        this.fone = fone;
        idsComitivas[index2] = idComitiva;
        strsComitivas[index2] = this.comitiva.toString();
        index2 +=1;
    }
    public String EXIBE_COMITIVA(int idComitiva){
        String exCom ="";
        for (int i = 0; i < index2; i+=1){
            if(this.idsComitivas[i] == idComitiva){
                exCom = strsComitivas[i];
            }
        }
        return exCom;
    }
    public String EXIBE_LOCAL(String idLocal){
        String exLoc ="";
        for (int i = 0; i < index1; i+=1){
            if(this.idsLocais[i].equals(idLocal)){
                exLoc = strsLocais[i];
            }
        }
        return exLoc;
    }
}
