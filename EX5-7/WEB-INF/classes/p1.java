import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class p1 extends HttpServlet {
   public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      response.setContentType("text/html");

      // Retrieve the 'movie' parameter from the request
      String movie = request.getParameter("movie");
      String movieTitle = getMovieTitle(movie);
      String movieDescription = getMovieDescription(movie);

      PrintWriter out = response.getWriter();
      out.println("<!DOCTYPE html>");
      out.println("<html lang=\"en\">");
      out.println("<head>");
      out.println("    <meta charset=\"UTF-8\">");
      out.println("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
      out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
      out.println("    <title>" + movieTitle + " - Movie Streaming</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("    <h1>Viewing " + movieTitle + "</h1>");
      out.println("    <p>" + movieDescription + "</p>");
      out.println("    <video width=\"640\" height=\"360\" controls>");
      out.println("        <source src=\"" + movie + ".mp4\" type=\"video/mp4\">");
      out.println("        Your browser does not support the video tag.");
      out.println("    </video>");
      out.println("</body>");
      out.println("</html>");
   }

   private String getMovieTitle(String movie) {
      // Replace with actual movie titles based on the movie parameter
      if ("movie1".equals(movie)) {
         return "Movie 1";
      } else if ("movie2".equals(movie)) {
         return "Movie 2";
      } else if ("movie3".equals(movie)) {
         return "Movie 3";
      } else {
         return "Unknown Movie";
      }
   }

   private String getMovieDescription(String movie) {
      // Replace with actual movie descriptions based on the movie parameter
      if ("movie1".equals(movie)) {
         return "This is an exciting action movie.";
      } else if ("movie2".equals(movie)) {
         return "A heartwarming drama for the whole family.";
      } else if ("movie3".equals(movie)) {
         return "A thrilling sci-fi adventure.";
      } else {
         return "Description not available.";
      }
   }
}
