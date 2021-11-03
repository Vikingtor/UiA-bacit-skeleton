package bacit.web.bacit_web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/GreetingWithDbServlet")
public class GreetingWithDbServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<form action = 'GreetingWithDbServlet' method = 'POST'>");

        out.println("<Label for = 'FirstName'>First Name:</Label>");
        out.println("<input type = 'text' name = 'FirstName'>");
        out.println("<br>");

        out.println("<Label for = 'LastName'>Last Name:</Label>");
        out.println("<input type = 'text' name = 'LastName'>");
        out.println("<br>");

        out.println("<Label for = 'Email'>Email:</Label>");
        out.println("<input type = 'text' name = 'Email'>");
        out.println("<br>");

        out.println("<Label for = 'Password'>Password:</Label>");
        out.println("<input type = 'text' name = 'Password'>");
        out.println("<br>");

        out.println("<input type = 'submit'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
            String firstname = request.getParameter("FirstName");
            String lastname = request.getParameter("LastName");
            String email = request.getParameter("Email");
            String password = request.getParameter("Password");

            Connection con = DBUtils.getINSTANCE().getConnection(out);
            String query = "insert into Users (FirstName, LastName, Email, Password) values (?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setString(3, email);
            ps.setString(4, password);
            ps.executeUpdate();
        }
        catch(SQLException | ClassNotFoundException ex)
        {
            out.println(ex);
        }
    }
}
