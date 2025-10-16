import java.sql.*;
import java.util.Scanner;

public class UpdateDataExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Conexão com o banco de dados
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "yourpassword"; // Altere para a senha correta

        System.out.print("Enter user ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a linha em branco
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new email: ");
        String email = scanner.nextLine();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // SQL para atualizar dados
            String sql = "UPDATE users SET name = ?, email = ? WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            // Definindo os valores dos parâmetros
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setInt(3, id);

            // Executando a atualização
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("User updated successfully!");
            } else {
                System.out.println("No user found with that ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
