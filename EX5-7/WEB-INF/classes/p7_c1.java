import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.UUID;

public class p7_c1 extends HttpServlet {
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");

    // Retrieve the username and password from the form
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    // Check if the provided credentials are valid (simplified for demonstration)
    if ("admin".equals(username) && "admin123".equals(password)) {
      // Generate a unique session ID (you can use a more secure method)
      String sessionId = UUID.randomUUID().toString();

      // Create a cookie for the session ID
      Cookie sessionCookie = new Cookie("sessionId", sessionId);
      sessionCookie.setMaxAge(3600); // Set the cookie to expire in one hour
      sessionCookie.setPath("/"); // Set the cookie path

      // Add the cookie to the response
      response.addCookie(sessionCookie);

      // Redirect the user to a welcome page
      response.sendRedirect("cookieC2");
    } else {
      // Invalid login, show an error message
      PrintWriter out = response.getWriter();
      out.println("Invalid username or password. <a href='p7_cookie.html'>Try again</a>");
    }
  }
}
