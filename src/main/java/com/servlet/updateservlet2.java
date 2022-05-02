package com.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateservlet2") 
public class updateservlet2 extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType ("text/html");
        PrintWriter out = response.getWriter ();
        String sid = request.getParameter ("id");
        int id = Integer.parseInt (sid);
        String name = request.getParameter ("name");
        String dept = request.getParameter ("dept");
        Emp e = new Emp ();
        e.setId (id);
        e.setName (name);
        e.setDept (dept);

        int status = empDBHandler.update (e);
        if (status > 0)
        {
         out.println ("Record updated succesfully...");
         response.sendRedirect ("viewservlet");
        }
        else
        {
         out.println ("Sorry! unable to update record");
        }
        out.close ();
    }
}