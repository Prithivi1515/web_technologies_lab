import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class p9_u2 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            // Getting the username from the query string
            String username = request.getParameter("username");
            out.print("Hello, " + username + "! Welcome back to Movie World.");
            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
