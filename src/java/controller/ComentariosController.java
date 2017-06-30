/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.PostDAO;
import model.dto.Post;
import model.dao.ComentariosDAO;
import model.dto.Comentarios;
import util.Ayudante;

/**
 *
 * @author admin
 */
public class ComentariosController extends HttpServlet {

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
        
//        PostDAO psDAO = new PostDAO();
//        String ruta = request.getRequestURI();
//        String accion = Ayudante.getAccion(ruta);
//        int id = Integer.parseInt(request.getParameter("id"));
//
//        switch (accion) {
//            case "ingresar":
//                Post p = psDAO.buscar(id);
//                request.setAttribute("post", p);
//                System.out.println("Ingresar_Comentario");
//                request.getRequestDispatcher("../create_comentario.jsp").forward(request, response);
//        }   
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
        
        String ruta = request.getRequestURI();
        String accion = Ayudante.getAccion(ruta);
        
        System.out.print(accion);
        
        String post_id = request.getParameter("post_id");
        String comentario = request.getParameter("comentario");
        String usuario_id = request.getParameter("usuario_id");
        String comentario_estado_id = request.getParameter("comentario_estado_id");
        
        //System.out.print(titulo);
        ComentariosDAO comDAO = new ComentariosDAO();
        

        switch (accion) {
            case "ingresar":
                Comentarios c = new Comentarios();
                c.setPost_id(Integer.parseInt(post_id));
                c.setComentario(comentario);
                c.setUsuario_id(Integer.parseInt(usuario_id));
                c.setComentario_estado_id(Integer.parseInt(comentario_estado_id));
                comDAO.ingresar(c);
                break;
            default:
                throw new AssertionError();
        }
        //Validaciones
        //Crear objeto profesor y cargar datos desde formulario

        //Redireccionar
        response.sendRedirect("../index.jsp");
        
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
