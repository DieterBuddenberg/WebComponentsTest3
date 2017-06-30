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
import model.dao.UsuarioDAO;
import model.dto.Usuario;
import util.Ayudante;

/**
 *
 * @author admin
 */
public class UsuarioController extends HttpServlet {

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
        
        String perfil_id = request.getParameter("perfil_id");
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        
        UsuarioDAO userDAO = new UsuarioDAO();
        
        System.out.print(ruta);
        System.out.print(accion);
        System.out.print(perfil_id + " " + usuario + " " + password + " " + email);

        Usuario u = new Usuario();
        
        switch (accion) {
            case "ingresar":
                //Usuario u = new Usuario();
                u.setPerfil_id(Integer.parseInt(perfil_id));
                u.setUsuario(usuario);
                u.setPassword(password);
                u.setEmail(email);
                userDAO.ingresar(u);
                break;
//            case "modificar":
//                Post pro = new Post();
//                pro.setTitulo(titulo);
//                pro.setCuerpo(cuerpo);
//                psDAO.modificar(pro, Integer.parseInt(id));
//                break;
            case "login":
                u = userDAO.login(usuario, password);
                //System.out.println("ID PERFIL: " + u.getPerfil_id());
                //request.setAttribute("user", u.getPerfil_id());
                request.setAttribute("perfil", u);
                request.getRequestDispatcher("../index2.jsp").forward(request, response);
                //response.sendRedirect("../index2.jsp");
                //System.out.println("Respuesta: " + response);
                break;
            default:
                throw new AssertionError();
        }
        
        //Validaciones
        //Crear objeto profesor y cargar datos desde formulario
        
        if (accion == "login") {} else {
        //Redireccionar
        //response.sendRedirect("../index2.jsp");
        }
        
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
