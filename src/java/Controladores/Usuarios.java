/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hans.buddenberg
 */
public class Usuarios extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Usuarios</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Usuarios at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
        String usuario = request.getParameter("txtUsuario");
        String password = request.getParameter("txtPassword");
        String email = request.getParameter("txtEmail");
        String perfil = request.getParameter("txtPerfil");
        
        Modelos.Usuario datUsuario = new Modelos.Usuario();
        Modelos.Perfil datPerfil = new Modelos.Perfil();
        
        EntityManager em;
        EntityManagerFactory emf;
        
        emf = Persistence.createEntityManagerFactory("WebComponentsTest3PU");
        em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        //datPerfil.setId(Integer.parseInt(perfil));
        datPerfil.setId(null);
        datPerfil.setTipo(perfil);
        datPerfil.setDetalle(null);
        
        //grabamos el rol
        em.persist(datPerfil);
        
        datUsuario.setId(null);
        datUsuario.setUsuario(usuario);
        datUsuario.setPassword(password);
        datUsuario.setEmail(email);
        datUsuario.setPerfilId(datPerfil);
        
        //grabamos el usuario nuevo         
        em.persist(datUsuario);
        em.flush();
        em.getTransaction().commit();
        
        em.close();
        response.sendRedirect("correctoDatos.jsp");

        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
