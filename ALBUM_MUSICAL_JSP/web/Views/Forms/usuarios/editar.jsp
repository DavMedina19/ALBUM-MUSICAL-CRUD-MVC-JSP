
<%@page import="Models.Artista"%>
<%@page import="ModelsDAO.ArtistaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f4f4f4;
            }

            div {
                width: 50%;
                margin: 20px auto;
                padding: 20px;
                background-color: #fff;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            h1 {
                text-align: center;
                margin-bottom: 20px;
            }

            form {
                text-align: left;
            }

            input[type="text"], input[type="submit"] {
                width: 100%;
                padding: 10px;
                margin-bottom: 10px;
                border: 1px solid #ccc;
                border-radius: 3px;
                box-sizing: border-box;
            }

            input[type="submit"] {
                background-color: #808080;
                color: #fff;
                border: none;
                cursor: pointer;
            }

            input[type="submit"]:hover {
                background-color: #0056b3;
            }

            a {
                display: block;
                margin-top: 10px;
                text-align: center;
                text-decoration: none;
                color: #007bff;
            }

            a:hover {
                text-decoration: underline;
            }
        </style>
    </head>
    <body>
        <div>
            <%
                ArtistaDAO dao = new ArtistaDAO();
                int ID = Integer.parseInt((String) request.getAttribute("IDper"));
                Artista p = (Artista) dao.list(ID);
            %>
            <h1>EDITAR ARTISTA</h1>
            <form action="Controlador">
                ID:<br>
                <input type="text" name="txtID" value="<%= p.getID()%>"><br>
                Nombre: <br>
                <input type="text" name="txtNombre" value="<%= p.getNombre()%>"><br>
                PaisOrigen: <br>
                <input type="text" name="txtPaisOrigen" value="<%= p.getPaisOrigen()%>"><br>
                EstiloMusical: <br>
                <input type="text" name="txtEstiloMusical" value="<%= p.getEstiloMusical()%>"><br>
                <input type="hidden" name="txtId" value="<%= p.getID()%>">
                <input type="submit" name="accion" value="Actualizar"><br>
                <a href="Controlador?accion=listar">Regresar</a>
            </form>
        </div>
    </body>
</html>
