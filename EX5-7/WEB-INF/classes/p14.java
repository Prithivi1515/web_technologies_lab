import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class p14 extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        int score = 0;

        // Evaluate the answers
        if ("Hyper Text Markup Language".equals(request.getParameter("q1"))) {
            score++;
        }
        if (".class-selector".equals(request.getParameter("q2"))) {
            score++;
        }
        if ("Adding interactivity and behavior".equals(request.getParameter("q3"))) {
            score++;
        }
        if ("Cascading Style Sheet".equals(request.getParameter("q4"))) {
            score++;
        }
        if ("color".equals(request.getParameter("q5"))) {
            score++;
        }

        out.println("<html>");
        out.println("<head><title>Exam Results</title></head>");
        out.println("<body>");
        out.println("<h1>Exam Results</h1>");
        out.println("<p>Username: " + username + "</p>");
        out.println("<p>Your score: " + score + " out of 5</p>");
        out.println("<a href='p14.html'>Back to Home</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
