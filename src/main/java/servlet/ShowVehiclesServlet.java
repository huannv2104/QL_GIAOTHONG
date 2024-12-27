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

@WebServlet("/ShowVehiclesServlet")
public class ShowVehiclesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ShowVehiclesServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        StringBuilder vehiclesList = new StringBuilder();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM Vehicle WHERE user_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, userId);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        vehiclesList.append("Vehicle Name: ").append(rs.getString("vehicle_name")).append(", ");
                        vehiclesList.append("License Plate: ").append(rs.getString("license_plate")).append("<br>");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.setContentType("text/html");
        response.getWriter().append(vehiclesList.toString());
    }
}
