import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class p6 extends HttpServlet {
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    String username = request.getParameter("username");
    String password = request.getParameter("password");

    // Check if the username and password are correct (simplified for the example)
    if ("prithivi".equals(username) && "password123".equals(password)) {
      // Create a session and set a session cookie to keep the user logged in
      HttpSession session = request.getSession(true);
      session.setAttribute("username", username);

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Welcome to Movie World</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Welcome, " + username + "!</h1>");
      out.println("<p>You are now logged in to Movie World.</p>");
      out.println("<a href='LogoutServlet'>Logout</a>");
      out.println("</body>");
      out.println("</html>");
    } else {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Login Failed</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Login Failed</h1>");
      out.println("<p>Invalid username or password. Please try again.</p>");
      out.println("<a href='index.html'>Go back to login</a>");
      out.println("</body>");
      out.println("</html>");
    }
  }
}
