/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlets;

import beans.Pelicula;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;

/**
 *
 * @author User
 */

@WebServlet(name = "ServeltTest", urlPatterns = {"/ServeltTest"})
public class ServletTest extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServeltTest</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServeltTest at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Usuario: " + request.getParameter("usuario"));
        System.out.println("Tecnología: " + request.getParameter("tecnologia"));

        Pelicula l1 = new Pelicula(1, "titulo1", "genero1", "autor1", 1, true);
        Pelicula l2 = new Pelicula(2, "titulo2", "genero2", "autor2", 2, false);

        List<Pelicula> Pelicula = new ArrayList<Pelicula>();
        Pelicula.add(l1);
        Pelicula.add(l2);

        Gson gson = new Gson();
        String result = gson.toJson(Pelicula);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    
}
