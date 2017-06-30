<%-- 
    Document   : index.jsp
    Created on : 29-jun-2017, 18:22:51
    Author     : hans.buddenberg
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.dto.Post"%>
<%@page import="model.dao.PostDAO"%>
<%@page import="model.dto.Comentarios"%>
<%@page import="model.dao.ComentariosDAO"%>

<%
    PostDAO pstDao = new PostDAO();
    ArrayList<Post> posts = pstDao.listar();
    ComentariosDAO comDao = new ComentariosDAO();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mi Blog</title>
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="resources/css/materialize.css"  media="screen,projection"/>

        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

        <!-- Funciones -->
        <script>
        </script>

    </head>

    <body>
        <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>

        <!-- Cabecera -->
        <header>
            <div class="navbar-fixed">
                <nav>
                    <div class="nav-wrapper">
                        <a href="#!" class="brand-logo">&MediumSpace;Mi Blog - Hans Buddenberg</a>
                        <ul class="right hide-on-med-and-down">

                            <li><a href="${pageContext.request.contextPath}/index.jsp">Inicio</a></li>
                            <li><a href="${pageContext.request.contextPath}/login.jsp">Login</a></li>       
                            <li><a href="${pageContext.request.contextPath}/signup.jsp">Registro</a></li>
                        </ul>
                    </div>
                </nav>
            </div>
        </header>

        <!-- Cuerpo -->
        <section id="main" class="row container">
            
            <h1>Noticias</h1>

            <!-- Articulos --> 
            <section id="articles_list" class="col s12">
                <% for (Post p : posts) {%>
                <article>
                    <hgroup><h2><a href="#"><%=p.getTitulo()%></a></h2></hgroup>
                    <p class="extract"><%=p.getCuerpo()%></p>
                    <% ArrayList<Comentarios> coms = comDao.listar(p.getId());
                        for (Comentarios c : coms) {%>
                    <p class="comments"><%=c.getComentario()%></p>
                    <% }%>
                    <a href="Comentarios/ingresar?id=<%=p.getId()%>">Comentar</a>
                </article>
                <% }%>
            </section>

            <!-- Barra Lateral -->
            <!--<aside class="col s3 red lighten-3">
                <section class="widget">
                    <h3>Widget</h3>
                    <ul>
                        <li><a href="#">Lorem  Ipsum</a></li>
                        <li><a href="#">Lorem  Ipsum</a></li>
                        <li><a href="#">Lorem  Ipsum</a></li>
                        <li><a href="#">Lorem  Ipsum</a></li>
                        <li><a href="#">Lorem  Ipsum</a></li>
                    </ul>
                </section>
                <section class="widget">
                    <h3>Widget</h3>
                    <ul>
                        <li><a href="#">Lorem  Ipsum</a></li>
                        <li><a href="#">Lorem  Ipsum</a></li>
                        <li><a href="#">Lorem  Ipsum</a></li>
                        <li><a href="#">Lorem  Ipsum</a></li>
                        <li><a href="#">Lorem  Ipsum</a></li>
                    </ul>
                </section>
            </aside>-->

        </section>

        <!-- Pie de pagina -->
        <footer class="page-footer">
            <!-- <div class="container">
                <div class="row">
                    <div class="col l6 s12">
                        <h5 class="white-text">Footer Content</h5>
                        <p class="grey-text text-lighten-4">You can use rows and columns here to organize your footer content.</p>
                    </div>
                    <div class="col l4 offset-l2 s12">
                        <h5 class="white-text">Links</h5>
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/index.jsp">Inicio</a></li>
                            <li><a href="${pageContext.request.contextPath}/login.jsp">Login</a></li>       
                            <li><a href="${pageContext.request.contextPath}/signup.jsp">Registro</a></li>
                        </ul>
                    </div>
                </div>
            </div> -->
            <div class="footer-copyright">
                <div class="container">
                    <p class="copyright"> © 2017 Copyright @ Hans Buddenberg <!--</p>-->
                        <!--<a class="grey-text text-lighten-4 right" href="#!">More Links</a></p>-->
                </div>
            </div>
        </footer>

    </body>
</html>
