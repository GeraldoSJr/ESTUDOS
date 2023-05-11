import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Mrbet mrbet = new Mrbet();

        Scanner scanner = new Scanner(System.in);
        String escolha = "";
        while (true) {
            escolha = menu(scanner);
            comando(escolha, mrbet, scanner);
        }

    }

    private static String menu(Scanner scanner) {
        System.out.println(
                "\n---\nMENU\n" +
                        "(M)Minha inclusão de times\n" +
                        "(R)Recuperar time\n" +
                        "(.)Adicionar campeonato\n" +
                        "(B)Bora incluir time em campeonato e (V)erificar se time está em campeonato\n" +
                        "(E)xibir campeonatos que o time participa\n" +
                        "(T)Tentar a sorte e status\n" +
                        "(!)Já pode fechar o programa!\n" +
                        "\n" +
                        "Opção> ");
        return scanner.next().toUpperCase();
    }

    private static void comando(String opcao, Mrbet mrbet, Scanner scanner) {
        switch (opcao) {
            case "M":
                cadastraTime(mrbet, scanner);
                break;
            case "R":
                recuperarTime(mrbet, scanner);
                break;
            case ".":
                adicionaCampeonato(mrbet, scanner);
                break;
            case "B":
                incluirTime(mrbet, scanner);
                break;
            case "V":
                verificarTime(mrbet, scanner);
                break;
            case "E":
                exibirCampeonatos(mrbet, scanner);
                break;
            case "T":
                tentarSorte(mrbet, scanner);
                break;
            case "S":
                sai();
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    public static void cadastraTime(Mrbet mrbet, Scanner sc){
        System.out.println("Código: ");
        String codigo = sc.nextLine();
        System.out.println("Nome: ");
        String nome = sc.nextLine();
        System.out.println("Mascote: ");
        String mascote = sc.nextLine();
        mrbet.cadastrarTime(codigo, nome, mascote);
    }
    public static void recuperarTime(Mrbet mrbet, Scanner sc){
        System.out.println("Código: ");
        String codigo = sc.nextLine();
        mrbet.recuperarTime(codigo);
    }
    public static void adicionaCampeonato(Mrbet mrbet, Scanner sc){
        System.out.println("Campeonato: ");
        String campeonato = sc.nextLine();
        System.out.println("Participantes: ");
        int participantes = sc.nextInt();
        mrbet.cadastrarCampeonato(campeonato, participantes);
    }
    public static void incluirTime(Mrbet mrbet, Scanner sc){
        System.out.println("Código: ");
        String codigo = sc.nextLine();
        System.out.println("Campeonato: ");
        String campeonato = sc.nextLine();
        mrbet.incluiTimeEmCampeonato(codigo, campeonato);
    }
    public static void verificarTime(Mrbet mrbet, Scanner sc){
        System.out.println("Código: ");
        String codigo = sc.nextLine();
        System.out.println("Campeonato: ");
        String campeonato = sc.nextLine();
        mrbet.verificaTimeEmCampeonato(codigo, campeonato);
    }
    public static void exibirCampeonatos(Mrbet mrbet, Scanner sc){

    }
    public static void tentarSorte(Mrbet mrbet, Scanner sc){

    }
    private static void sai() {
        System.out.println("\nVlw flw o/");
        System.exit(0);
    }
}
