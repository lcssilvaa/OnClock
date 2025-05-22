package application;

import java.sql.*;

public class FazerLogin {

    // ... campos existentes podem ser removidos ou adaptados conforme necessário ...

    public String fazerLoginWithCredentials(String email, String senha) { //
        Criptografia crip = new Criptografia(); //
        String senhaHash = crip.gerarHash(senha); //

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnClock", "root", ""); //
             PreparedStatement stmt = con.prepareStatement("SELECT permissao FROM usuarios WHERE email = ? AND senha = ?")) { //

            stmt.setString(1, email); //
            stmt.setString(2, senhaHash); //

            try (ResultSet rs = stmt.executeQuery()) { //
                if (rs.next()) { //
                    return rs.getString("permissao"); //
                }
            }
        } catch (SQLException e) { //
            System.err.println("Erro de banco de dados durante o login: " + e.getMessage()); // Registre o erro em vez de apenas imprimir
        }
        return null; // Login falhou
    }

    // Você pode remover o fazerLogin() original ou adaptá-lo se ainda for necessário para outros fins
    // public String fazerLogin() { ... }
}