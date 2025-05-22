package application;

import java.util.Scanner;

public class MenuAdministrador {

    public void exibirMenu() {

        Cadastro cadastro = new Cadastro();
        Preferencias pref = new Preferencias();
        Scanner sc = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("Seja bem-vindo ao OnClock! \n");
            System.out.println("Qual opção deseja escolher? \n");

            System.out.println("1. Cadastrar usuário");
            System.out.println("2. Gestão de acessos");
            System.out.println("3. Consultar horas");
            System.out.println("4. Alterar hora");
            System.out.println("5. Validar ocorrências");
            System.out.println("6. Exportar relatório");
            System.out.println("7. Preferências");
            System.out.println("\n0. Sair do Sistema");


            escolha = sc.nextInt();

            switch (escolha) {
                case 1:
                    cadastro.cadastrarUsuario();
                    break;
                case 2:
                    System.out.println("Você escolheu Gestão de acessos");
                    break;
                case 3:
                    System.out.println("Você escolheu Consultar horas");
                    break;
                case 4:
                    System.out.println("Você escolheu Alterar hora");
                    break;
                case 5:
                    System.out.println("Você escolheu Validar ocorrências");
                    break;
                case 6:
                    System.out.println("Você escolheu Exportar relatório");
                    break;
                case 7:
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