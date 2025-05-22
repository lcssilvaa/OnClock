package application;

import java.util.Scanner;

public class Preferencias {

    public void exibirPreferencias() {

        MenuUsuario menu = new MenuUsuario();
        Scanner sc = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("Preferências! \n");

            System.out.println("Versão do sistema: 1.0.0");
            System.out.println("Idioma: Português (Brasil)");
            System.out.println("Notificações: Desativado");
            System.out.println("\n0. Sobre");
            System.out.println("1. Para voltar ao menu");

            escolha = sc.nextInt();

            switch (escolha) {

                case 0:
                    System.out.println("\n----------------------------");
                    System.out.println("\nO OnClock é um sistema desenvolvido para facilitar o controle de ponto e a gestão de horas trabalhadas de forma simples, eficiente e segura.");
                    System.out.println("\n----------------------------");
                    exibirPreferencias();
                    break;

                case 1:
                    System.out.println("Retornando ao menu...");
                    return;

                default:
                    System.out.println("Opção inválida!");

            }
            System.out.println("----------------------------");

        } while (escolha != 0);

    }
}

