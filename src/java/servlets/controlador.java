package servlets;

import beans.tblUsuario;
import datos.mUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "controlador", urlPatterns = {"/controlador"})
public class controlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int opc = Integer.parseInt(request.getParameter("opc"));
            RequestDispatcher rd = null;
            HttpSession session = request.getSession();
            mUsuario modelUsuario = new mUsuario();
            switch (opc) {
                case 1:
                    response.sendRedirect("index.html");
                    break;
                case 2:
                    String usu = request.getParameter("txtUsuario");
                    String pass = request.getParameter("txtPassword");
                    List<tblUsuario> list1 = modelUsuario.usuarios(usu, pass);
                    if (list1.size() == 1) {
                        rd = request.getRequestDispatcher("home.jsp");
                        session.setAttribute("Arrendador", list1.get(0));
                        rd.forward(request, response);
                    } else {
                        response.sendRedirect("controlador?opc=1");
                    }
                    break;
                case 21:
                    if (session.getAttribute("Arrendador") == null) {
                        response.sendRedirect("controlador?opc=1");
                    } else {
                        rd = request.getRequestDispatcher("home.jsp");
                        rd.forward(request, response);
                    }
                    break;
                case 22:
                    if (session.getAttribute("Arrendador") == null) {
                        response.sendRedirect("controlador?opc=1");
                    } else {
                        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
                        List<tblUsuario> list2 = modelUsuario.seleccionar(idUsuario);
                        if (list2.size() == 1) {
                            rd = request.getRequestDispatcher("formModificarUsuario.jsp");
                            session.setAttribute("Seleccion", list2.get(0));
                            rd.forward(request, response);
                        }
                    }
                    break;
                case 221:
                    if (session.getAttribute("Arrendador") == null) {
                        response.sendRedirect("controlador?opc=1");
                    } else {
                        int id = Integer.parseInt(request.getParameter("txtId"));
                        String nombre = request.getParameter("txtNombre");
                        String apellidos = request.getParameter("txtApellidos");
                        String telef = request.getParameter("txtTelef");
                        String dni = request.getParameter("txtDNI");
                        String usuario = request.getParameter("txtUsuario");
                        String contraseña = request.getParameter("txtPassword");
                        tblUsuario usuario1 = new tblUsuario(id, nombre, apellidos, telef, dni, usuario, contraseña);
                        if (modelUsuario.modificar(usuario1)) {
                            session.invalidate();
                            response.sendRedirect("controlador?opc=1");
                        } else {
                            response.sendRedirect("controlador?opc=22&idUsuario=" + usuario1.getIdUsuario());
                        }
                    }
                    break;
                case 3:
                    rd = request.getRequestDispatcher("listInmuebles.jsp");
                    rd.forward(request, response);
                    break;
                case 4:
                    rd = request.getRequestDispatcher("listArrendatarios.jsp");
                    rd.forward(request, response);
                    break;
                case 5:
                    rd = request.getRequestDispatcher("listContratos.jsp");
                    rd.forward(request, response);
                    break;
                default:
                    out.print("<h1>[ERROR] No se ha encontrado la opción en el controlador</h1>\n"
                            + "        <p>La opción buscada es: <b>http://localhost:8084/sw_inmuebles/controlador?opc=" + opc + "</b></p>\n"
                            + "        <a href=\"controlador?opc=1\">Ir a inicio</a>");
                    break;
            }

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
        processRequest(request, response);
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
