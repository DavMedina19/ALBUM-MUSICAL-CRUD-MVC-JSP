
<%@page import="java.util.Iterator"%>
<%@page import="Models.Artista"%>
<%@page import="java.util.List"%>
<%@page import="ModelsDAO.ArtistaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ALBUM MUSICAL APP 2</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f4f4f4;
            }

            div {
                text-align: center;
                margin-top: 20px;
            }

            h1 {
                margin-bottom: 20px;
            }

            a {
                text-decoration: none;
                padding: 5px 10px;
                margin: 5px;
                background-color: #808080;
                color: #fff;
                border-radius: 3px;
                transition: background-color 0.3s;
            }

            a:hover {
                background-color: #666;
            }

            .add-button {
                margin-top: 20px;
            }

            table {
                width: 80%;
                margin: 0 auto;
                border-collapse: collapse;
                background-color: #fff;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            th, td {
                padding: 10px;
                text-align: center;
                border-bottom: 1px solid #ddd;
            }

            th {
                background-color: #f2f2f2;
            }
        </style>
    </head>
    <body>
        <div>
            <h1>ALBUM DE ARTISTAS</h1>
            <a class="add-button" href="Controlador?accion=add">Agregar Nuevo Artista</a>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>PaisOrigen</th>
                        <th>EstiloMusical</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <%
                    ArtistaDAO dao = new ArtistaDAO();
                    List<Artista> list = dao.listar();
                    Iterator<Artista> iter = list.iterator();
                    Artista per = null;
                    while (iter.hasNext()) {
                        per = iter.next();
                %>
                <tbody>
                    <tr>
                        <td><%= per.getID()%></td>                        
                        <td><%= per.getNombre()%></td>
                        <td><%= per.getPaisOrigen()%></td>
                        <td><%= per.getEstiloMusical()%></td>
                        <td>
                            <a href="Controlador?accion=editar&ID=<%= per.getID()%>">Editar</a>
                            <a href="Controlador?accion=eliminar&ID=<%= per.getID()%>">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>

