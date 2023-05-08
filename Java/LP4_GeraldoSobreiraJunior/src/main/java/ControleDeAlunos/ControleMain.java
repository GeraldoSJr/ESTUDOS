package ControleDeAlunos;
import ControleDeAlunos.Controle;

import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 *
 * @author geraldosobreirajunior
 *
 */
public class ControleMain {

    public static void main(String[] args) {
        Controle controle = new Controle();

        Scanner scanner = new Scanner(System.in);
        String escolha = "";
        while (true) {
            escolha = menu(scanner);
            comando(escolha, controle, scanner);
        }

    }

    /**
     * Exibe o menu e captura a escolha do/a usuário/a.
     *
     * @param scanner Para captura da opção do usuário.
     * @return O comando escolhido.
     */
    private static String menu(Scanner scanner) {
        System.out.println(
                "\n---\nMENU\n" +
                        "(C)adastrar Aluno\n" +
                        "(E)xibir Aluno\n" +
                        "(N)ovo Grupo\n" +
                        "(A)locar Aluno no Grupo\n" +
                        "(P)ertinência a Grupos\n" +
                        "(O)lhaí quais Grupos o Aluno Tá.\n" +
                        "(S)im, quero Fechar o Programa!\n" +
                        "Opção> ");
        return scanner.nextLine().toUpperCase();
    }

    private static void comando(String opcao, Controle controle, Scanner scanner) {
        switch (opcao) {
            case "C":
                cadastraAluno(controle, scanner);
                break;
            case "E":
                exibeAluno(controle, scanner);
                break;
            case "N":
                novoGrupo(controle, scanner);
                break;
            case "A":
                alocarAluno(controle, scanner);
                break;
            case "P":
                verificarGrupo(controle, scanner);
                break;
            case "O":
                verificarAluno(controle, scanner);
                break;
            case "S":
                sai();
                break;
            default:
                System.out.println("Opçao invalida!");
        }
    }

    /**
     * Função usada para exibir os dados do aluno já cadastrados.
     * @param controle
     * @param scanner
     */
    private static void exibeAluno(Controle controle, Scanner scanner) {
        System.out.print("\nMatricula: ");
        String matricula = scanner.nextLine();
        String aluno = controle.getAluno(matricula);
        System.out.println("Aluno: " + aluno);
    }

    /**
     * Cadastra alunos no sistema.
     * @param controle
     * @param scanner
     */
    private static void cadastraAluno(Controle controle, Scanner scanner) {
        System.out.print("\nMatrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Curso: ");
        String curso = scanner.nextLine();
        System.out.println(controle.cadastraAluno(matricula, nome, curso));
    }

    /**
     * Cadastra novos grupos ao sistema.
     * @param controle
     * @param scanner
     */
    private static void novoGrupo(Controle controle, Scanner scanner) {
        System.out.print("\nGrupo: ");
        String grupo = scanner.nextLine();
        System.out.print("Tamanho: ");
        String comprimento = scanner.nextLine();
        int tamanho = comprimento.trim().isEmpty() ? -1 : Integer.parseInt(comprimento);
        System.out.println(controle.cadastraGrupos(grupo, tamanho));
    }

    /**
     * Coloca um aluno dentro de um grupo.
     * @param controle
     * @param scanner
     */
    private static void alocarAluno(Controle controle, Scanner scanner){
        System.out.print("\nMatrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Grupo: ");
        String grupo = scanner.nextLine();
        System.out.println(controle.alocarAluno(matricula, grupo));
    }

    /**
     * Checa no grupo determinado se um determinado aluno faz parte desse.
     * @param controle
     * @param scanner
     */
    private static void verificarGrupo(Controle controle, Scanner scanner){
        System.out.print("\nGrupo: ");
        String grupo = scanner.nextLine();
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print(controle.pertinencia(grupo, matricula));
    }

    /**
     * Descobre quais grupos o aluno em questão está contido e exibe-os.
     * @param controle
     * @param scanner
     */
    private static void verificarAluno(Controle controle, Scanner scanner){
        System.out.print("\nAluno: ");
        String matricula = scanner.nextLine();
        System.out.print(controle.checkagem(matricula));
    }

    /**
     * Sai da aplicação.
     */
    private static void sai() {
        System.out.println("\nVlw flw o/");
        System.exit(0);
    }
}
