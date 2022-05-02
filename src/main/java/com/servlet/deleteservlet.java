package com.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteservlet")
public class deleteservlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType ("text/html");
        PrintWriter out = response.getWriter ();
        String sid = request.getParameter ("id");
        int id = Integer.parseInt (sid);
        empDBHandler.delete (id);

        int status = empDBHandler.delete (id);
        if (status > 0)
        {
         out.print ("<p>Record deleted successfully!</p>");
         response.sendRedirect ("viewservlet");
        }
        else
        {
         out.println ("Sorry! unable to delete record");
        }
        response.sendRedirect ("viewservlet");
    }
}