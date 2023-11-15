import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class p13_db3 extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Connection conn = null;
        Statement stmt = null;
        PrintWriter out = response.getWriter();
        // String department = request.getParameter("course");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // create a database connection using jdbc , port no used here is 3306
            // database name is college and username is root , there is no password
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies", "root", "");
            stmt = conn.createStatement();
            PreparedStatement pstmt = conn.prepareStatement("insert into movies values(?, ?, ?, ?, ?)");
            pstmt.setString(1, request.getParameter("Movie_Name"));
            // Same for second parameter
            pstmt.setString(2, request.getParameter("Director_Name"));
            pstmt.setString(3, request.getParameter("Actor_Name"));
            pstmt.setFloat(4, Float.valueOf(request.getParameter("Rating")));
            pstmt.setString(5, request.getParameter("Genre"));
            // Execute the insert command using executeUpdate()
            // to make changes in database
            pstmt.executeUpdate();
            out.println("<html><body><p> Database Updated</p>");
            // select data from table where dept matches the value given by user in form
            String sql = "SELECT * FROM movies";
            pstmt = conn.prepareStatement(sql);
            // pstmt.setString(1, department);
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