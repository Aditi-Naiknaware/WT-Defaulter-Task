package com.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addservlet
 */
@WebServlet("/addservlet")
public class addservlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void processRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType ("text/html;charset=UTF-8");
    }

 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
  *      response)
  */
    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest (request, response);
        try
        {
            PrintWriter out = response.getWriter ();
            String eid = request.getParameter ("id");
            int id = Integer.parseInt (eid);
            String ename = request.getParameter ("name");
            String dept = request.getParameter ("dept");
            try
            {
             Class.forName ("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/db", "root", "AditiMysql2302");
             Statement stmt = con.createStatement ();
             stmt.executeUpdate ("insert into emp values (" + id + ",'" + ename + "', '" + dept + "')");
             out.println ("<h1>Record Inserted Successfully</h1>");
             String sql = "select * from emp";
             ResultSet rs = stmt.executeQuery (sql);
             out.println ("<form action = 'viewservlet' method='post'>");
             out.print ("<tr><a href ='viewservlet'>View Employee</a></td></tr>");
             out.println ("</tr>");
             out.println ("</table>");
             out.println ("</form>");
             rs.close ();
             stmt.close ();
             con.close ();

            } 
            catch (SQLException se)
            {
             throw new RuntimeException ("Cannot Connect the Database!", se);
            }

        } 
        catch (ClassNotFoundException cnfe)
        {
        }
    }
}