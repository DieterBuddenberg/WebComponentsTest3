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

            <h1>Login</h1>

            <form action="Usuario/login" method="POST">

                <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">Usuario</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" placeholder="Escriba Nombre Usuario" name="usuario" required>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" placeholder="Escriba password" name="password" required>
                    </div>
                </div>

                <div class="form-group row">
                    <div class="offset-sm-2 col-sm-10 ">
                        <button type="submit" class="btn btn-primary" style="float: right;">Login</button>
                    </div>
                </div>
            </form>

            <!--<a href="index.jsp">Volver</a>-->
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
                       <!-- <a class="grey-text text-lighten-4 right" href="#!">More Links</a></p> -->
                </div>
            </div>
        </footer>
    </body>
</html>