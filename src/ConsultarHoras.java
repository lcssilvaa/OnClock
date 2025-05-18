import java.sql.*;

public class ConsultarHoras {

    public void consultarHoras() {

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnClock", "root", "");

            String sql = "SELECT data_hora FROM registros_ponto";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("Horas trabalhadas registradas: \n");

            while (rs.next()) {
                String hora = rs.getString("data_hora");
                System.out.println("- " + hora);
            }

            rs.close();
            stmt.close();
            con.close();

        } catch
        (SQLException e) {
            System.out.println("Erro ao consultar pontos: " + e.getMessage());
        }
    }
}
