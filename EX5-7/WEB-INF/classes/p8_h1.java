import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class p8_h1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            String movieId = request.getParameter("movieId");
            String title = request.getParameter("title");

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Movie Information</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Movie Information</h1>");
            out.println("<p>You selected the movie with ID " + movieId + " and title: " + title + "</p>");
            // Fetch and display movie details based on movieId
            out.println("<p>Movie details go here...</p>");
            out.println("</body>");
            out.println("</html>");

            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
