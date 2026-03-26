package Controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CuentaDAO;
import DAO.RetiroDAO;
import Model.Cuenta;
import Model.Usuario;
 

/**
 * Servlet implementation class RetiroServlet
 */

@WebServlet("/retirar")
public class RetiroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RetiroDAO retiroDAO = new RetiroDAO();
	CuentaDAO cuentaDAO = new CuentaDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("usuarioLogueado") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");

        BigDecimal monto = new BigDecimal(request.getParameter("monto"));
        Cuenta cuenta = cuentaDAO.obtenerCuentaActiva(usuario.getId());
;       BigDecimal saldoActual = cuenta.getBalance();
        
        if(monto.compareTo(BigDecimal.ZERO)<=0) {
        	request.setAttribute("error", "Introduzca un monto mayor que 0");
        	   request.getRequestDispatcher("retiro.jsp")
               .forward(request, response);
    
        } else if(monto.compareTo(saldoActual)>0) {
        	request.setAttribute("error", "No hay saldo suficiente");
     	   request.getRequestDispatcher("retiro.jsp")
            .forward(request, response);
        } else {

	        try {
	        	retiroDAO.retirar(usuario.getId(), monto);
	            response.sendRedirect("index.jsp");
	        } catch (RuntimeException e) {
	            request.setAttribute("error", e.getMessage());
	            request.getRequestDispatcher("retiro.jsp")
	                   .forward(request, response);
	        }
        }
    }
}