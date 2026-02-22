package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.TransaccionDAO;
import Model.Transaccion;
import Model.Usuario;

/**
 * Servlet implementation class TransaccionServlet
 */
@WebServlet("/transacciones")
public class TransaccionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true);

        if (session == null || session.getAttribute("usuarioLogueado") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");

        TransaccionDAO dao = new TransaccionDAO();
        List<Transaccion> lista = dao.obtenerPorUsuario(usuario.getId());

        request.setAttribute("transacciones", lista);
        request.getRequestDispatcher("transacciones.jsp")
               .forward(request, response);
    }
}
