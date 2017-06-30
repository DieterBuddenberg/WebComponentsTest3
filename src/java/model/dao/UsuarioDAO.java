/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dto.Usuario;
import util.Conexion;

public class UsuarioDAO {

    Conexion con;

    public UsuarioDAO() {
        con = new Conexion();
    }
   
    //  public void ingresar(Usuario p) {
    public void ingresar(Usuario u) {
        //String sql = "INSERT INTO post" +
        //             "(`usuario_id`,`titulo`,`cuerpo`,`postestado_id`) " +
        //             "VALUES (" + p.getUsuario_id() + ",'"+ p.getTitulo() + "','"+ p.getCuerpo() + "',"+ p.getUsuarioestado_id() + ")";
        //System.out.print(p.getTitulo());
        String sql = "INSERT INTO usuario" +
                     "(`perfil_id`,`usuario`,`password`,`email`) " +
                     "VALUES (" + 1 + ",'"+ u.getUsuario()+ "','"+ u.getPassword()+ "','"+ u.getEmail() + "')";
        System.out.println(sql);
        con.update(sql);
    }
          
    public void modificar(Usuario p, int id) {
        String sql = "update post SET "
                   + "perfil_id = '" + p.getPerfil_id()+ "',"
                   + "nombre = '" + p.getUsuario() + "',"
                   + "apellido ='" + p.getPassword()+ "' "
                   + "email ='" + p.getEmail()+ "' "
                   + "where id=" + id;
        con.update(sql);
    }

    public ArrayList<Usuario> listar() {
        ArrayList<Usuario> user = new ArrayList<Usuario>();
        ResultSet datos = null;
        try {
            String sql = "SELECT * FROM post";

            datos = con.query(sql);

            while (datos.next()) {
                Usuario u = new Usuario();
                u.setId(datos.getInt("id"));
                u.setPerfil_id(datos.getInt("perfil_id"));
                u.setUsuario(datos.getString("usuario"));
                u.setPassword(datos.getString("password"));
                u.setEmail(datos.getString("email"));

                //agregar profesor a arraylist de post
                user.add(u);


            }
        } catch (SQLException ex) {
            System.out.println("Listar");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;


    }

    public void eliminar(int id) {
        String sql = "DELETE FROM usuario WHERE id=" + id;
        con.update(sql);
    }

    public Usuario buscar(int id) {
        try {
            String sql = "SELECT * FROM usuario WHERE id = " + id;
            ResultSet datos = null;

            datos = con.query(sql);

            datos.next();

            Usuario u = new Usuario();
            u.setId(datos.getInt("id"));
            u.setPerfil_id(datos.getInt("perfil_id"));
            u.setUsuario(datos.getString("usuario"));
            u.setPassword(datos.getString("password"));
            u.setEmail(datos.getString("email"));

            return u;
        } catch (SQLException ex) {
            System.out.println("Buscar");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    public Usuario login(String user, String password) {
        try {
            String sql = "SELECT * FROM usuario WHERE usuario = '" + user + "' and password = '" + password + "'";
            System.out.println(sql);
            ResultSet datos = null;

            datos = con.query(sql);
            
            datos.next();

            Usuario u = new Usuario();
            u.setId(datos.getInt("id"));
            u.setPerfil_id(datos.getInt("perfil_id"));
            u.setUsuario(datos.getString("usuario"));
            u.setPassword(datos.getString("password"));
            u.setEmail(datos.getString("email"));
            
            return u;
        } catch (SQLException ex) {
            System.out.println("Error Usuario");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }


}
