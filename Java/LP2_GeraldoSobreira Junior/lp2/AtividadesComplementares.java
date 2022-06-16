package lp2;

/**
 * Constrói uma estrutura de atividades extracurriculares.
 * Gerencia projetos, cursos e estágios.
 *
 * @param Estagio recebe horas passadas nessa atividade.
 * @param Projeto recebe meses passados nessa atividade.
 * @param Curso recebe horas passadas nessa atividade.
 *
 */

public class AtividadesComplementares {
    private int horasEstagio;
    private int mesesProjeto = 0;
    private double horasCurso;
    int creditosEstagio;
    double creditosCurso;
    int creditosProjeto;
    private String [] atividades = new String[4];
    int i = 0;
    public AtividadesComplementares(){
    }
    public void adicionarEstagio(int horasEstagio) {
        this.horasEstagio = horasEstagio;
        creditosEstagio = (int)(horasEstagio/300) * 5;
        atividades[i] = "Estagio " + Integer.toString(this.horasEstagio);
        i += 1;
    }

    public void adicionarProjeto(int mesesProjeto) {
        this.mesesProjeto += mesesProjeto;
        atividades[i] = "Projeto " + Integer.toString(mesesProjeto);
        creditosProjeto += (int)(mesesProjeto / 3) * 2;
        i += 1;
    }

    public void adicionarCurso(double horasCurso) {
        this.horasCurso += horasCurso;
        creditosCurso += (int)(horasCurso / 30 + 0.5);
        atividades[i] = "Cursos " + Double.toString(this.horasCurso);
    }

    public String[] pegaAtividades() {
        return atividades;
    }
    public double contaCreditos() {
        return this.creditosEstagio + creditosProjeto + creditosCurso;
    }
}
