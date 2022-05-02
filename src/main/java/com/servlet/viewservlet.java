package com.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewservlet")  
public class viewservlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType ("text/html");
        PrintWriter out = response.getWriter ();
        out.println ("<a href='Index.html'>Add Employee</a>");
        out.println ("<h1>Employees List</h1>");
        List <Emp> list = empDBHandler.getAllEmployees();

        out.print ("<table border='1' width='100%' ");
        out.print("<tr><th>Id</th><th>Name</th><th>Dept</th><th>Update</th><th>Delete</th></tr>");
        
        for (Emp e:list)
        {
         out.print ("<tr><td>" + e.getId () + "</td><td>" + e.getName () +
      "</td><td>" + e.getDept () +
      "</td><td><a href='updateservlet?id=" + e.getId () +
      "'>update</a></td>  <td><a href='deleteservlet?id=" +
      e.getId () + "'>delete</a></td></tr>");
        }
        out.print ("</table>");
        out.close ();
    }
}