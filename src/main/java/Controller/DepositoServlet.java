package Controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Usuario;
import Service.DepositoService;

/**
 * Servlet implementation class DepositoServlet
 */
@WebServlet("/depositar")
public class DepositoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        HttpSession session = request.getSession(false);

	        if (session == null || session.getAttribute("usuarioLogueado") == null) {
	            response.sendRedirect("login.jsp");
	            return;
	        }

	        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");

	        BigDecimal monto = new BigDecimal(request.getParameter("monto"));

	        DepositoService service = new DepositoService();
	        service.depositar(usuario.getId(), monto);

	        response.sendRedirect("index.jsp");
	    }
	}
