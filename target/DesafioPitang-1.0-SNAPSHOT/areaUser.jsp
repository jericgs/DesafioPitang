<%-- 
    Document   : areaAdmin
    Created on : 31/05/2018, 13:16:58
    Author     : jerick.gs
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">    

    <head>

        <title>Usu�rio</title>

        <!-- Required meta tags -->                    
        <meta charset="utf-8">                     
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="Resources/node_modules/bootstrap/compiler/bootstrap.min.css">                


        <!--  Material Dashboard CSS    -->
        <link href="Resources/node_modules/bootstrap/compiler/style-page3.css" rel="stylesheet" />

        <!--  CSS for Demo Purpose, don't include it in your project     -->
        <link href="Resources/node_modules/bootstrap/compiler/demo.css" rel="stylesheet" />        

        <!-- Icone -->        
        <link rel="icon" type="image/png" href="Resources/imagens/icons/icon.ico">

        <!-- Alertas Sweetalert -->
        <link rel="stylesheet" href="Resources/node_modules/sweetalert2/css/sweetalert2.min.css">
        <script src="Resources/node_modules/sweetalert2/dist/sweetalert2.min.js"></script>       

        <!--     Fonts and icons     -->       
        <link rel="stylesheet" href="Resources/font-awe/roboto.min.css">
        <link rel="stylesheet" href="Resources/font-awe/material-icons.min.css">

    </head>

    <body>
        <c:if test="${sessionScope.status == null}">
            <jsp:forward page="controle?logica=Login&usuario=L&senha=S"></jsp:forward>                
        </c:if>

        <div class="wrapper">

            <div class="sidebar" data-color="red" data-image="">
                <!-- Tip 1: You can change the color of the sidebar using: data-color="purple | blue | green | orange | red"
    
                    Tip 2: you can also add an image using data-image tag
                -->
                <div class="logo">

                    <a class="simple-text logo-tim">
                        <div>
                            <img src="Resources/images/icons/dashboard-logo.png">       
                        </div> 
                        <a class="simple-text textLogo" style="padding-top: 12px;">
                            Sistema
                        </a>                        
                    </a>                        
                </div>
                <div class="sidebar-wrapper">
                    <ul class="nav">
                        <li class="active">
                            <a href="./areaUser.jsp">
                                <i class="material-icons">list</i>
                                <p>Consulta</p>
                            </a>
                        </li>
                        <li>
                            <a href="control?logic=Register&username=${sessionScope.username.user}">
                                <i class="material-icons">person_add</i>
                                <p>Cadastro</p>
                            </a>
                        </li>                        
                        <li>
                            <a href="controle?logica=Alteracao&nomeUsuario=${sessionScope.admin.nomeUsuario}">
                                <i class="material-icons">cached</i>
                                <p>Altera��o</p>
                            </a>
                        </li>                                                  
                        <li>
                            <a href="controle?logica=Conta&nomeUsuario=${sessionScope.admin.nomeUsuario}">
                                <i class="material-icons">settings</i>
                                <p>Conta</p>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="main-panel">
                <nav class="navbar navbar-transparent navbar-absolute">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand"> Consulta </a>
                        </div>
                        <div class="collapse navbar-collapse">
                            <ul class="nav navbar-nav navbar-right">                                                        
                                <li>
                                    <a href="control?logic=Logout&status=${sessionScope.status}&username=${sessionScope.username.user}">
                                        <i class="material-icons">exit_to_app</i>
                                        <p class="hidden-lg hidden-md">Sair</p>
                                    </a>                                
                                </li>
                            </ul>
                            <form class="navbar-form navbar-right"></form>
                        </div>
                    </div>
                </nav>

                <div class="content" style="padding-left: 15px; padding-right: 15px;">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="card">
                                    <div class="card-header" data-background-color="red">
                                        <h4 class="title">Usu�rios</h4>
                                        <p class="category">Lista de Usu�rios</p>
                                    </div>
                                    <div class="card-content table-responsive">
                                        <table class="table "> <!-- table-hover !-->
                                            <thead class="text-primary">
                                            <th>ID Usu�rio</th>
                                            <th>Nome Completo</th>
                                            <th>G�nero</th>
                                            </thead>
                                            <tbody id="listUsers"></tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>                        
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </body>

    <!--   Core JS Files   -->
    <script src="Resources/node_modules/bootstrap/js/disp-dasboard/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="Resources/node_modules/bootstrap/js/disp-dasboard/bootstrap.min.js" type="text/javascript"></script>
    <script src="Resources/node_modules/bootstrap/js/disp-dasboard/material.min.js" type="text/javascript"></script>
    <!--  Charts Plugin -->
    <script src="Resources/node_modules/bootstrap/js/disp-dasboard/chartist.min.js"></script>
    <!--  Dynamic Elements plugin -->
    <script src="Resources/node_modules/bootstrap/js/disp-dasboard/arrive.min.js"></script>
    <!--  PerfectScrollbar Library -->
    <script src="Resources/node_modules/bootstrap/js/disp-dasboard/perfect-scrollbar.jquery.min.js"></script>
    <!--  Notifications Plugin    -->
    <!-- <script src="Resources/node_modules/bootstrap/js/disp-dasboard/disp-dasboard/bootstrap-notify.js"></script>-->
    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA8kJ3p081G1hbsHQLkydJg8AtpVUznejw"async defer></script>
    <!-- Material Dashboard javascript methods -->
    <script src="Resources/node_modules/bootstrap/js/disp-dasboard/material-dashboard.js?v=1.2.0"></script>
    <!-- Material Dashboard DEMO methods, don't include it in your project! -->
    <script src="Resources/node_modules/bootstrap/js/disp-dasboard/demo.js"></script>
    <!-- momentjs.com -->        
    <script src="Resources/node_modules/bootstrap/js/disp-dasboard/moment-with-locales.js"></script>

    <script type="text/javascript">
        $(function () {
            setListUsers();
            function setListUsers() {

                setTimeout(setListUsers, 1000);

                $.post("AjaxControl", {ajaxLogic: "AreaAjaxListUsers"}, function (data, status) {

                    //NATIVO
                    //var dados = '{"clientes": [{"id":"1", "nome":"Erick", "email":"jerick.gs@gmail.com"}, {"id":"2", "nome":"Marcos", "email":"marcos.gs@gmail.com"}, {"id":"3", "nome":"Jos�", "email":"jose.gs@gmail.com"}]}';
                    var objDice = JSON.parse(data);

                    listUsers = document.getElementById("listUsers");

                    listUsers.innerHTML = "";
                    for (i = 0; i < objDice.length; i++) {

                        listUsers.innerHTML += "<td>" + objDice[i].idUser + "</td><td>" + objDice[i].name + "</td><td>" + objDice[i].genre + "</td></tr>";
                        //listUsers.innerHTML += "<tr style='cursor:pointer' onclick = document.location='controle?logica=RegulacaoSocorro&nomeUsuario=${sessionScope.medico.nomeUsuario}&idR=" + objDice[i].idR + "'><td>" + objDice[i].idUser + "</td><td>" + objDice[i].name + "</td><td>" + objDice[i].genre + "</td></tr>";

                    }

                });

            }
        });
    </script>

</html>
