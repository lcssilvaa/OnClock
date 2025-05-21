import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Cadastro {

    public void cadastrarUsuario() {

        Scanner scanner = new Scanner(System.in);
        Criptografia crip = new Criptografia();

        String nome;
        String email;
        String permiss;
        String senha;
        String senhaHash = "";

        do {
            System.out.print("Digite o nome do funcionário: ");
            nome = scanner.nextLine();
            if (!nome.matches("^[a-zA-Zá-úÁ-Ú\\s]+$")) {
                System.out.println("Erro: O nome deve conter apenas letras. Tente novamente.");
                continue;
            }

            System.out.print("Digite a senha do funcionário (4 a 12 caracteres): ");
            senha = scanner.nextLine();
            if (senha.length() < 4 || senha.length() > 12) {
                System.out.println("Erro: A senha deve conter entre 4 e 12 caracteres. Tente novamente.");
                
                //criptografa a senha
                
                senhaHash = Criptografia.gerarHash(senha);
                continue;
            }

            System.out.print("Digite o email do funcionário: ");
            email = scanner.nextLine();
            if (!EmailValidator.isValidEmail(email)) {
                System.out.println("Erro: Email inválido. Tente novamente.");
                continue;
            }

            System.out.print("Digite a permissão do funcionário: ");
            permiss = scanner.nextLine().toLowerCase();
            if (!permiss.equals("admin") && !permiss.equals("usuario")) {
                System.out.println("Erro: A permissão deve ser 'admin' ou 'usuario'. Tente novamente.");
                continue;
            }

            break;

        } while (true) ;

        // conectar com o banco de dados

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnClock", "root", "");

            //inserir os dados

            String sql = "INSERT INTO usuarios (nome, senha, email, permissao) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            // substitui os ? do código acima

            stmt.setString(1, nome);
            stmt.setString(2, senhaHash);
            stmt.setString(3, email);
            stmt.setString(4, permiss);

            //executa o comando insert

            stmt.executeUpdate();
            System.out.println("Usuário cadastrado com sucesso!");

            stmt.close();
            con.close();

            //pega qualquer erro do mysql e mostra

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
        }
    }
}


