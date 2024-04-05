package Controllers;

import Models.Artista;
import ModelsDAO.ArtistaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static javax.servlet.jsp.tagext.TagAttributeInfo.ID;

/**
 *
 * @author HECTOR MEDINA
 */
public class Controlador extends HttpServlet {

    String listar = "Views/Forms/usuarios/listar.jsp";
    String add = "Views/Forms/usuarios/add.jsp";
    String editar = "Views/Forms/usuarios/editar.jsp";
    Artista p = new Artista();
    ArtistaDAO dao = new ArtistaDAO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("listar")) {
            acceso = listar;
        } else if (action.equalsIgnoreCase("add")) {
            acceso = add;
        } else if (action.equalsIgnoreCase("Agregar")) {
            String ID = request.getParameter("txtID");
            String Nombre = request.getParameter("txtNombre");
            String PaisOrigen = request.getParameter("txtPaisOrigen");
            String EstiloMusical = request.getParameter("txtEstiloMusical");
            p.setID(Integer.parseInt(ID));
            p.setNombre(Nombre);
            p.setPaisOrigen(PaisOrigen);
            p.setEstiloMusical(EstiloMusical);
            dao.add(p);
            acceso = listar;
        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("IDper", request.getParameter("ID"));
            acceso = editar;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            int ID = Integer.parseInt(request.getParameter("txtId"));
            String Nombre = request.getParameter("txtNombre");
            String PaisOrigen = request.getParameter("txtPaisOrigen");
            String EstiloMusical = request.getParameter("txtEstiloMusical");
            p.setID(ID);
            p.setNombre(Nombre);
            p.setPaisOrigen(PaisOrigen);
            p.setEstiloMusical(EstiloMusical);
            dao.editar(p);
            acceso = listar;
        } else if (action.equalsIgnoreCase("eliminar")) {
            int ID = Integer.parseInt(request.getParameter("ID"));
            p.setID(ID);
            dao.eliminar(ID);
            acceso = listar;

        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
