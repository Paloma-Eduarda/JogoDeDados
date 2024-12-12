import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        List<Integer> numerosApostados = new ArrayList<>();
        List<Jogador> apostas = new ArrayList<>();

        while (true) {
            System.out.println("Faça sua Aposta");
            System.out.println("1. Apostar");
            System.out.println("2. Sortear");
            System.out.println("0. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            try {
                switch(opcao) {
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    case 1:
                        fazerAposta(numerosApostados,apostas);
                        break;
                    case 2:
                        Sortear(apostas);
                        break;
                    default:
                        System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
                }
            } catch (NumberFormatException exception) {
                System.out.println("entrada inválida! Por favor, insira um número" + exception);
            }
        }


    }

    public static void fazerAposta(List<Integer> numerosApostados, List<Jogador> apostas) {

        System.out.println("Digite seu nome");
        String nome = scanner.nextLine();
        System.out.println("Digite um numero de 1 a 12 para fazer a aposta");
        int numeroAposta = scanner.nextInt();
        scanner.nextLine();

        if (verificarSeApostaValida(numeroAposta, numerosApostados)){
            Jogador jogador = new Jogador(nome, numeroAposta);
            apostas.add(jogador);
            numerosApostados.add(numeroAposta);
        }
    }
    public static boolean verificarSeApostaValida(int valorAposta, List<Integer> numerosApostados){

        if (valorAposta < 0 || valorAposta > 12) {
            System.out.println("Valor da aposta inválido. O valor deve estar entre 0 e 12.");
            return false;
        }else if (numerosApostados.contains(valorAposta)) {
            System.out.println("Número de aposta já foi escolhido.");
            return false;
        } else {
            System.out.println("Aposta válida!");
            return true;
        }
    }
    public static void Sortear(List<Jogador> apostas) {
        Dado dado1 = new Dado();
        Dado dado2 = new Dado();

        int numeroSorteado = dado1.jogarDado() + dado2.jogarDado();
        System.out.println(numeroSorteado);

        Jogador vencedor = null;
        for (Jogador jogador : apostas) {
            if (jogador.getValorAposta() == numeroSorteado) {
                vencedor = jogador;
                break;
            }

        }
        if (vencedor != null) {
            System.out.println("O ganhador da aposta é: " + vencedor.getNome());
            vencedor.incrementarVitorias();
        } else {
            System.out.println("A máquina venceu!");
        }
    }
}