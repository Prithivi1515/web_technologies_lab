import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Arrays;

public class p7_c2 extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");

    // Retrieve the session ID from the cookie
    String sessionId = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if (cookie.getName().equals("sessionId")) {
          sessionId = cookie.getValue();
          break;
        }
      }
    }

    PrintWriter out = response.getWriter();

    if (sessionId != null) {
      // User is logged in, display a welcome message
      out.println("<h1>Welcome to the Movie Streaming Website</h1>");
      out.println("<p>Session ID: " + sessionId + "</p>");
      out.println("<a href='logout'>Logout</a>");
    } else {
      // User is not logged in, show a login link
      out.println("<h1>Welcome to the Movie Streaming Website</h1>");
      out.println("<p>You are not logged in. <a href='index.html'>Login</a></p>");
    }
  }
}
