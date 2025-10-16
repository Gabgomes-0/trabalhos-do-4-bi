import java.sql.*;
import java.util.Scanner;

public class InsertDataExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Conexão com o banco de dados
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "yourpassword"; // Altere para a senha correta

        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // SQL para inserir dados
            String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            // Definindo os valores dos parâmetros
            pstmt.setString(1, name);
            pstmt.setString(2, email);

            // Executando a inserção
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("User added successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }}}