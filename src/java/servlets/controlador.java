package servlets;

import beans.bArrendatario;
import beans.bInmueble;
import beans.tblUsuario;
import datos.mArrendatario;
import datos.mInmuebles;
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
            mInmuebles modelInmuebles = new mInmuebles();
            mArrendatario modelArrendatario = new mArrendatario();
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
                    if (session.getAttribute("Arrendador") == null) {
                        response.sendRedirect("controlador?opc=1");
                    } else {
                        List<bInmueble> list2 = modelInmuebles.inmuebles();
                        rd = request.getRequestDispatcher("listInmuebles.jsp");
                        session.setAttribute("Inmuebles", list2.iterator());
                        rd.forward(request, response);
                    }
                    break;
                case 31:
                    if (session.getAttribute("Arrendador") == null) {
                        response.sendRedirect("controlador?opc=1");
                    } else {
                        rd = request.getRequestDispatcher("formNuevoInmueble.jsp");
                        rd.forward(request, response);
                    }
                    break;
                case 311:
                    if (session.getAttribute("Arrendador") == null) {
                        response.sendRedirect("controlador?opc=1");
                    } else {
                        int id = Integer.parseInt(request.getParameter("txtId"));
                        String codigo = request.getParameter("txtCodigo");
                        String nombre = request.getParameter("txtNombre");
                        int precio = Integer.parseInt(request.getParameter("txtValor"));
                        bInmueble inmueble1 = new bInmueble(id, codigo, nombre, precio);
                        if (modelInmuebles.insertar(inmueble1)) {
                            response.sendRedirect("controlador?opc=3");
                        }
                    }
                    break;
                case 32:
                    if (session.getAttribute("Arrendador") == null) {
                        response.sendRedirect("controlador?opc=1");
                    } else {
                        int id = Integer.parseInt(request.getParameter("idInmueble"));
                        List<bInmueble> list3 = modelInmuebles.seleccionar(id);
                        if (list3.size() == 1) {
                            rd = request.getRequestDispatcher("formEditInmueble.jsp");
                            session.setAttribute("inmuebleSel", list3.get(0));
                            rd.forward(request, response);
                        } else {
                            response.sendRedirect("controlador?opc=3");
                        }
                    }
                    break;
                case 321:
                    if (session.getAttribute("Arrendador") == null) {
                        response.sendRedirect("controlador?opc=1");
                    } else {
                        int id = Integer.parseInt(request.getParameter("txtId"));
                        String codigo = request.getParameter("txtCodigo");
                        String nombre = request.getParameter("txtNombre");
                        int precio = Integer.parseInt(request.getParameter("txtValor"));
                        bInmueble inmueble1 = new bInmueble(id, codigo, nombre, precio);
                        if (modelInmuebles.modificar(inmueble1)) {
                            response.sendRedirect("controlador?opc=3");
                        } else {
                            response.sendRedirect("controlador?opc=32&idInmueble=" + inmueble1.getIdInmueble());
                        }
                    }
                    break;
                case 4:
                    if (session.getAttribute("Arrendador") == null) {
                        response.sendRedirect("controlador?opc=1");
                    } else {
                        List<bArrendatario> list4 = modelArrendatario.arrendatarios();
                        rd = request.getRequestDispatcher("listArrendatarios.jsp");
                        session.setAttribute("Arrendatarios", list4.iterator());
                        rd.forward(request, response);
                    }
                    break;
                case 41:
                    if (session.getAttribute("Arrendador") == null) {
                        response.sendRedirect("controlador?opc=1");
                    } else {
                        rd = request.getRequestDispatcher("formNuevoArrendatario.jsp");
                        rd.forward(request, response);
                    }
                    break;
                case 411:
                    if (session.getAttribute("Arrendador") == null) {
                        response.sendRedirect("controlador?opc=1");
                    } else {
                        int id = Integer.parseInt(request.getParameter("txtId"));
                        String nombre = request.getParameter("txtNombre");
                        String apellidos = request.getParameter("txtApellidos");
                        String telef = request.getParameter("txtTelef");
                        String dni = request.getParameter("txtDNI");
                        bArrendatario arrendatario = new bArrendatario(id, nombre, apellidos, dni, telef);
                        if (modelArrendatario.insertar(arrendatario)) {
                            response.sendRedirect("controlador?opc=4");
                        } else {
                            response.sendRedirect("controlador?opc=41");
                        }
                    }
                    break;
                case 42:
                    if (session.getAttribute("Arrendador") == null) {
                        response.sendRedirect("controlador?opc=1");
                    } else {
                        int id = Integer.parseInt(request.getParameter("idArrendatario"));
                        List<bArrendatario> list5 = modelArrendatario.seleccionar(id);
                        if (list5.size() == 1) {
                            rd = request.getRequestDispatcher("formEditArrendatario.jsp");
                            session.setAttribute("selArrendat", list5.get(0));
                            rd.forward(request, response);
                        } else {
                            response.sendRedirect("controlador?opc=4");
                        }
                    }
                    break;
                case 421:
                    if (session.getAttribute("Arrendador") == null) {
                        response.sendRedirect("controlador?opc=1");
                    } else {
                        int id = Integer.parseInt(request.getParameter("txtId"));
                        String nombre = request.getParameter("txtNombre");
                        String apellidos = request.getParameter("txtApellidos");
                        String telef = request.getParameter("txtTelef");
                        String dni = request.getParameter("txtDNI");
                        bArrendatario arrendatario = new bArrendatario(id, nombre, apellidos, dni, telef);
                        if (modelArrendatario.modificar(arrendatario)) {
                            response.sendRedirect("controlador?opc=4");
                        } else {
                            response.sendRedirect("controlador?opc=42&idArrendatario=" + arrendatario.getIdarrendatario());
                        }
                    }
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
