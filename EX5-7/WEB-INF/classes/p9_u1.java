import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class p9_u1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            String username = request.getParameter("userName");

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Welcome to Movie World</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Welcome, " + username + "!</h1>");
            out.println("<p>You've entered the world of movies. Explore and enjoy!</p>");
            out.println("<a href='url2?username=" + username
                    + "'>Continue to Movie Genre Selection</a>");
            out.println("</body>");
            out.println("</html>");

            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
