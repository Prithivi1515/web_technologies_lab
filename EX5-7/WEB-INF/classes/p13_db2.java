import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class p13_db2 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Connection conn = null;
        Statement stmt = null;
        PrintWriter out = response.getWriter();
        String Genre = request.getParameter("Genre");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/movies", "root", "");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM movies where Genre = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Genre);
            ResultSet rs = pstmt.executeQuery();
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                String mov = rs.getString("Movie_Name");
                String dir = rs.getString("Director_Name");
                String act = rs.getString("Actor_Name");
                Double rat = rs.getDouble("Rating");
                String gen = rs.getString("Genre");
                // Display values
                out.println("<p> Movie Name: " + mov + "<br>");
                out.println("Director Name: " + dir + "<br>");
                out.println("Actor Name: " + act + "<br>");
                out.println("Rating: " + rat + "<br>");
                out.println("Genre: " + gen + "<br></p>");
            }
            out.println("</body></html>");
            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.print("Do not connect to DB - Error:" + e);
        }
    }
}