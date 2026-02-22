package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CuentaDAO;
import Model.Cuenta;
import Model.Usuario;

/**
 * Servlet implementation class saldo
 */
@WebServlet("/saldo")
public class SaldoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        HttpSession session = request.getSession(false);

	        if (session == null || session.getAttribute("usuarioLogueado") == null) {
	            response.sendRedirect("login.jsp");
	            return;
	        }

	        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");

	        CuentaDAO cuentaDAO = new CuentaDAO();
	        Cuenta cuenta = cuentaDAO.obtenerCuentaActiva(usuario.getId());

	        request.setAttribute("cuenta", cuenta);
	        request.getRequestDispatcher("saldo.jsp")
	               .forward(request, response);
	    }
	}