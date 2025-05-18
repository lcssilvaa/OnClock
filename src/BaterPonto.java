import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class BaterPonto {

    public void baterPonto() {

        LocalDateTime ponto = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String pontoFormatado = ponto.format(formatter);


        String url = "jdbc:mysql://localhost:3306/OnClock";
        String usuario = "root";
        String senha = "";

        Connection con = null;
        PreparedStatement stmt = null;

        try {
            // Abrir conexão com o banco
            con = DriverManager.getConnection(url, usuario, senha);

            // SQL para inserir data e hora
            String sql = "INSERT INTO registros_ponto (data_hora) VALUES (?)";

            // Preparar a query
            stmt = con.prepareStatement(sql);

            // Definir o parâmetro da data/hora (convertendo LocalDateTime para java.sql.Timestamp)
            stmt.setTimestamp(1, java.sql.Timestamp.valueOf(ponto));

            // Executar o comando
            int linhas = stmt.executeUpdate();

            if (linhas > 0) {
                System.out.println("Ponto registrado com sucesso: " + pontoFormatado);
            } else {
                System.out.println("Falha ao registrar ponto.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ou executar comando no banco: " + e.getMessage());
        } finally {
            // Fechar recursos para evitar vazamento de memória
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
}
