package bacit.web.bacit_web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/GreetingWithNameServlet")
public class GreetingWithNameServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        PrintWriter out = response.getWriter();
        //Give me your name
        out.println("<html><body>");
        out.println("<form action = 'GreetingWithNameServlet' method = 'post'>");
        out.println("<input type = 'text' name = 'yourName'>");
        out.println("<input type = 'submit'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String name = request.getParameter("yourName");

        PrintWriter out = response.getWriter();

        out.println("Your name is: " + name);
    }
}
