package Lula;

public class Local {
    private String idLocal;
    private String nomeLocal;
    private String ramal;
    private String toString = "";

    public Local(String idLocal, String nomeLocal, String ramal){
        this.idLocal = idLocal;
        this.nomeLocal = nomeLocal;
        this.ramal = ramal;
    }

    public String toString() {
        toString = idLocal+ " - " + nomeLocal + " - " + ramal;
        return toString;
    }
}
