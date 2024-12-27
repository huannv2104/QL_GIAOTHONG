package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.java.DatabaseConnection;



@WebServlet("/ShowUsersServlet")
public class ShowUsersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ShowUsersServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder usersList = new StringBuilder();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM User";
            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    usersList.append("User ID: ").append(rs.getInt("id")).append(", ");
                    usersList.append("Username: ").append(rs.getString("username")).append("<br>");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.setContentType("text/html");
        response.getWriter().append(usersList.toString());
    }
}
