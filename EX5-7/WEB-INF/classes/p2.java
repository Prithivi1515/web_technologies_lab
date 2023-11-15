import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class p2 extends HttpServlet {
   public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Welcome to FILMY FEVER";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

      String username = request.getParameter("username");

      out.println(docType +
            "<html>\n" +
            "<head><title>" + title + "</title></head>\n" +
            "<body>\n" +
            "<h1>Welcome to Movie World, " + username + "!</h1>\n" +
            "<p>Explore our collection of movies and enjoy your time on our website.</p>\n" +
            "</body>\n" +
            "</html>");
   }
}
