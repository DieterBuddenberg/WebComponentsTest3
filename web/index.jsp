<%-- 
    Document   : index
    Created on : 29-jun-2017, 17:16:32
    Author     : hans.buddenberg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="Usuarios" method="POST">
            <table border="0">
                <tr>
                    <td>Usuario</td>
                    <td><input type="text" name="txtUsuario" value="" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="text" name="txtPassword" value="" /></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="txtEmail" value="" /></td>
                </tr>
                <tr>
                    <td>Perfil</td>
                    <td><input type="text" name="txtPerfil" value="" /></td>
                </tr>
                
                <input type="submit" value="Grabar a la BD"/>
            </table>
        </form>
    </body>
</html>
