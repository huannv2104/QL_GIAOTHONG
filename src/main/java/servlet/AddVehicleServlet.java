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



@WebServlet("/addVehicle")
public class AddVehicleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddVehicleServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 int userId = Integer.parseInt(request.getParameter("userId"));
         String vehicleName = request.getParameter("vehicleName");
         String licensePlate = request.getParameter("licensePlate");

         try (Connection conn = DatabaseConnection.getConnection()) {
             String sql = "INSERT INTO Vehicle (user_id, vehicle_name, license_plate) VALUES (?, ?, ?)";
             try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                 stmt.setInt(1, userId);
                 stmt.setString(2, vehicleName);
                 stmt.setString(3, licensePlate);
                 stmt.executeUpdate();
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }

         // Redirect to show vehicles after adding a new vehicle
         response.sendRedirect("ShowVehiclesServlet?userId=" + userId);
     
    }
}
