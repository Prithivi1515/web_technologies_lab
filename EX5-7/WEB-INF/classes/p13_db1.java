import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class p13_db1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Connection conn = null;
        Statement stmt = null;
        PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            out.println("<h1> into class</h1>");
            // create a database connection using jdbc , port no used here is 3306
            // database name is college and username is root , there is no password
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/movies", "root", "");
            if (conn != null) {
                out.println("<h1> No issues in Connection</h1>");
            }
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM collection";
            ResultSet rs = stmt.executeQuery(sql);
            // Extract data from result set
            while (rs.next()) {
                out.println("<h1> into while loop</h1>");
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
            e.printStackTrace();
            out.println("An error occurred: " + e.getMessage());
        }

    }
}