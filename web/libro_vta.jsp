<%-- 
    Document   : libro_vta
    Created on : 21/05/2024, 11:06:51 a. m.
    Author     : Estudiante
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%HttpSession obj=request.getSession();
if(obj !=null && obj.getAttribute("usuario")!=null){
    
%>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <style>
            body {
                background: linear-gradient(to top, rgba(0, 0, 0, 1.2), rgba(0, 0, 0, 0)),
                    url('img/fondo.jpg') no-repeat center center;
                background-size: cover;
                height: 100vh;
                margin: 0;
            }
        </style>
    </head>
    <body>
        <div class="d-flex bg-transparent text-white">
            <div class="card col-sm-4 bg-transparent border-0 my-4">
                <div class="card-body">
                    <form action="ControlCTO" method="POST">
                        <div class="form-group">
                            <label>ISBN</label>
                            <input type="text" value="${libro.getIsbn()}" name="txtIsbn" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" value="${libro.getNombre()}" name="txtNombre" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Autor</label>
                            <input type="text" value="${libro.getAutor()}" name="txtAutor" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Editorial</label>
                            <input type="text" value="${libro.getEditorial()}" name="txtEditorial" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Año</label>
                            <input type="text" value="${libro.getAnio()}" name="txtAnio" class="form-control">
                        </div>
                        <input type="submit" name="menu" value="Agregar" class="btn btn-info">
                        <input type="submit" name="menu" value="Actualizar" class="btn btn-secondary">
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="d-flex align-items-center justify-content-center my-4">
                                <img src="img/icono.png" width="50" height="50" class="mr-4" alt="Ícono de Libros">
                                <h1 class="m-0">Lista de Libros</h1>
                            </div>
                        </div>
                    </div>
                    <table class="table table-hover table-dark">
                        <thead>
                            <tr>
                                <th scope="col">ISBN</th>
                                <th scope="col">Nombre Libro</th>
                                <th scope="col">Autor</th>
                                <th scope="col">Editorial</th>
                                <th scope="col">Año</th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach var="libro" items="${lista}">
                                <tr>
                                    <td>${libro.getIsbn()}</td>
                                    <td>${libro.getNombre()}</td>
                                    <td>${libro.getAutor()}</td>
                                    <td>${libro.getEditorial()}</td>
                                    <td>${libro.getAnio()}</td>
                                    <td>
                                        <a class="btn btn-info" href="ControlCTO?menu=Editar&id=${libro.getIsbn()}">Editar</a>
                                        <a class="btn btn-secondary" href="ControlCTO?menu=Eliminar&id=${libro.getIsbn()}">Delete</a>                                        
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>   

        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
    </body>

</html>
<%}else{
         request.getRequestDispatcher("error.html").forward(request, response);
        }
%>
