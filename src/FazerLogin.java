import java.sql.*;
import java.util.Scanner;

public class FazerLogin {

    String permissao;
    String email;
    String senha;
    String senhaHash = "";
    boolean logar = false;

    Scanner scanner = new Scanner(System.in);
    MenuAdministrador menu = new MenuAdministrador();

    public String fazerLogin() {

        Criptografia crip = new Criptografia();

        String[] menuLogin = {
                "Digite o seu email",
                "Digite a sua senha",
        };

        while (!logar) {
            System.out.println(menuLogin[0]);
            this.email = scanner.nextLine().trim();

            System.out.println(menuLogin[1]);
            this.senha = scanner.nextLine().trim();

            senhaHash = crip.gerarHash(this.senha);

            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnClock", "root", "");

                //inserir os dados no banco

                String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";
                PreparedStatement stmt = con.prepareStatement(sql);

                //substitui os ? da coluna email e da coluna senha pelas variáveis inseridas

                stmt.setString(1, this.email);
                stmt.setString(2, senhaHash);

                // executa o código (Insert)

                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    String permissao = rs.getString("permissao");
                    System.out.println("Login realizado com sucesso! Permissão: " + permissao);
                    return permissao;

                } else {
                    System.out.println("E-mail ou senha inválidos.");
                }

                rs.close();
                stmt.close();
                con.close();

            } catch (Exception e) {
                System.out.println("Erro ao conectar: " + e.getMessage());
            }
        }
        return "";
    }
}

