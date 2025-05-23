package application;

import java.util.Scanner;


public class MenuUsuario {

    BaterPonto ponto = new BaterPonto();
    ConsultarHoras consulta = new ConsultarHoras();
    Preferencias pref = new Preferencias();

    public void exibirMenu() {

        Scanner sc = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("Seja bem-vindo ao OnClock! \n");
            System.out.println("Qual opção deseja escolher? \n");

            System.out.println("1. Consultar horas trabalhadas");
            System.out.println("2. Registrar ocorrências");
            System.out.println("3. Bater ponto");
            System.out.println("4. Preferências");
            System.out.println("\n0. Para sair do sistema");

            escolha = sc.nextInt();

            switch (escolha) {
                case 1:
                    consulta.consultarHoras();
                    break;

                case 2:
                    System.out.println("teste");
                    break;

                case 3:
                    ponto.baterPonto();
                    break;

                case 4:
                    pref.exibirPreferencias();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");

            }
            System.out.println("----------------------------");

        } while (escolha != 0);

        sc.close();
    }
}