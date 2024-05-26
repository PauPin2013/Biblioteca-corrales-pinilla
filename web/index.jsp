<%-- 
    Document   : index
    Created on : 21/05/2024, 11:36:23 a. m.
    Author     : Estudiante
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <title>Inicio</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <style>
            body {
                background: linear-gradient(to top, rgba(0, 0, 0, 1.2), rgba(0, 0, 0, 0)),
                    url('img/login-bg-17.jpg') no-repeat center center;
                background-size: cover;
                height: 100vh;
                margin: 0;
                color: white;
            }
        </style>
    </head>
    <body>
        <div class="d-flex justify-content-center align-items-center" style="height: 100vh;">
            <div class="container">
                <h1 class="text-center font-weight-bold">Login</h1>
                <form action="ValidaCTO" method="post" class="bg-transparent p-4 rounded" style="max-width: 600px; margin: auto;">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Email address</label>
                        <input type="email" class="form-control form-control-lg" name="email" id="exampleInputEmail1" aria-describedby="emailHelp">
                        <small id="emailHelp" class="form-text" style="color: white;">We'll never share your email with anyone else.</small>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Password</label>
                        <input type="password" class="form-control form-control-lg" name="clave" id="exampleInputPassword1">
                    </div>
                    <button type="submit" name="accion" value="Ingresar" class="btn btn-primary btn-lg btn-block">Ingresar</button>
                </form>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
    </body>
</html>