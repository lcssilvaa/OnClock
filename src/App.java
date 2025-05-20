
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            List<Cadastro> funcionarios = new ArrayList<>();
            while (true) {
                System.out.println("""
                            \n=== Cadastros de funcionários ===                   
                            0 - Sair do programa;
                            1 - Fazer um cadastro;
                            2 - Visualizar os funcionários;
                            === Digite um dos números acima para proseguir! ===\n""");
                try {
                    int menu = scanner.nextInt();
                    scanner.nextLine();
                    switch (menu) {
                        case 0 -> {
                            System.out.println("Saindo do prgrama. Tenha um bom dia!");
                            return;
                        }

                        case 1 -> {
                            do {
                                try {
                                    System.out.print("Digite o nome do funcionário: ");
                                    String nome = scanner.nextLine();
                                    if (!nome.matches("^[a-zA-Zá-úÁ-Ú\\s]+$")) {
                                        System.out.println("Erro: O nome deve conter apenas letras. Tente novamente.");
                                        continue;
                                    }

                                    System.out.print("Digite o sobrenome do funcinário: ");
                                    String sobrenome = scanner.nextLine();
                                    if (!sobrenome.matches("^[a-zA-Zá-úÁ-Ú\\s]+$")) {
                                        System.out.println("Erro: O sobrenome deve conter apenas letras. Tente novamente.");
                                        continue;
                                    }

                                    System.out.print("Digite o email do funcinário: ");
                                    String email = scanner.nextLine();
                                    if (!EmailValidator.isValidEmail(email)) {
                                        System.out.println("Erro: Email inválido. Tente novamente.");
                                        continue;
                                    }

                                    System.out.print("Digite a permissão do funcinário: ");
                                    String permiss = scanner.nextLine().toLowerCase();
                                    if (!permiss.equals("admin") && !permiss.equals("funcionario")) {
                                        System.out.println("Erro: A permissão deve ser 'admin' ou 'funcionario'. Tente novamente.");
                                        continue;
                                    }
                                    // Adicionando o novo cadastro do funcionario em uma lista
                                    Cadastro funcionario = new Cadastro(nome, sobrenome, email, permiss);
                                    funcionarios.add(funcionario);
                                    System.out.println("Funcionário cadastrado com sucesso!");
                                    break;

                                } catch (InputMismatchException e) {
                                    System.out.println("Erro: Entrada inválida.");
                                    System.out.println("Datalhes do erro: " + e.getMessage());
                                    scanner.nextLine();
                                }

                            } while (true);
                        }

                        case 2 -> {

                            if (funcionarios.isEmpty()) {
                                System.out.println("Nenhum funcionário cadastrado.");
                            } else {
                                System.out.println("Funcionários cadastrados:");
                                int i = 1;
                                for (Cadastro funcionario : funcionarios) {
                                    System.out.println(i++ + ". " + funcionario);
                                }
                            }
                        }

                        default ->
                            System.out.println("Opção inválida. Tente novamente.");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Erro: Entrada inválida.");
                    System.out.println("Datalhes do erro: " + e.getMessage());
                    scanner.nextLine();
                }
            }
        }
    }
}
