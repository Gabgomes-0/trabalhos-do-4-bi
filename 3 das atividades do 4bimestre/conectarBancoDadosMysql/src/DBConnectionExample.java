
import java.sql.*;

public class DBConnectionExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "yourpassword"; // Altere para a senha correta

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // Criando um Statement
            Statement stmt = connection.createStatement();

            // Realizando uma consulta SQL
            String sql = "SELECT * FROM users";
            ResultSet rs = stmt.executeQuery(sql);

// Processando os resultados
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println("ID: " + id + ", Name: " + name +
                        ", Email: " + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }}}