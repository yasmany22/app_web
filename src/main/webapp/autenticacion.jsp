<%-- 
    Document   : autenticacion
--%>

<%@page import="com.yasmany.app_web.Conector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Login - Brand</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
</head>
<body class="bg-gradient-primary">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-10 col-lg-12 col-xl-10">
                <div class="card shadow-lg o-hidden border-0 my-5">
                    <div class="card-body p-0">
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-flex">
                                <div class="flex-grow-1 bg-login-image" style="background-image: url(&quot;assets/img/more/amigos4.jpg;);"></div>
                            </div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h4 class="text-dark mb-4">Login!</h4>
                                    </div>
                                    <!------------- Formulario ---------------------->
                                    <form class="user" action="autenticacion.jsp" method="post">
                                        <div class="mb-3"><input class="form-control form-control-user" type="text" id="exampleInputUser" aria-describedby="userHelp" placeholder="Ingrese nombre de usuario..." name="user"></div>
                                        <div class="mb-3"><input class="form-control form-control-user" type="password" id="exampleInputPassword" placeholder="Contrase??a" name="pwd"></div>
                                        <div class="mb-3">
                                            <div class="custom-control custom-checkbox small">
                                                <div class="form-check"><input class="form-check-input custom-control-input" type="checkbox" id="formCheck-1"><label class="form-check-label custom-control-label" for="formCheck-1">Recordarme..</label></div>
                                            </div>
                                        </div><button class="btn btn-primary d-block btn-user w-100" type="submit">Login</button>
                                        <hr><a class="btn btn-primary d-block btn-google btn-user w-100 mb-2" role="button"><i class="fab fa-google"></i>&nbsp; Login con Google</a><a class="btn btn-primary d-block btn-facebook btn-user w-100" role="button"><i class="fab fa-facebook-f"></i>&nbsp; Login con Facebook</a>
                                        <hr>
                                    </form>
                                    
                                    <%
                                        Class.forName("com.mysql.jdbc.Driver");
                                        Conector bdd = new Conector();
                                        bdd.conectar();

                                        if (bdd.login(request.getParameter("user"), request.getParameter("pwd"))) {
                                            out.println("<div class='alert alert-success' role='alert'>Acceso correcto...!</div>");
                                        } else {
                                            out.println("<div class='alert alert-danger' role='alert'>Usuario y/o contrase??a incorrectos!</div>");
                                        }
                                        bdd.close_con();
                                    %>

                
                                    <div class="text-center"><a class="small" href="forgot-password.html">Olvid?? su contrase??a?</a></div>
                                    <div class="text-center"><a class="small" href="register.html">Crear una cuenta..!</a></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/bs-init.js"></script>
    <script src="assets/js/theme.js"></script>
</body>

</html>