package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.java.DatabaseConnection;


/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Here you might want to display a form to add a user, but this is not necessary for the POST method.
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 String username = request.getParameter("username");
         String password = request.getParameter("password");

         try (Connection conn = DatabaseConnection.getConnection()) {
             String sql = "INSERT INTO User (username, password) VALUES (?, ?)";
             try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                 stmt.setString(1, username);
                 stmt.setString(2, password);
                 stmt.executeUpdate();
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }

         // Redirect to show users after adding the new user
         response.sendRedirect("ShowUsersServlet");
     }
    
}
