package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import DAO.UsuarioDAO;
import Model.Usuario;
 

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    
	 public Usuario autenticar(String email, String password) {
	    	
	        Usuario usuario =  usuarioDAO.buscarPorEmail(email);
	
	        if (usuario == null) {
	            return null;
	        }
	      
	
	        String hashGuardado = usuario.getPassword();
	        if (hashGuardado.startsWith("$2y$")) {
	        	hashGuardado = "$2a$" + hashGuardado.substring(4);
	        }
	
	
	        if (BCrypt.checkpw(password, hashGuardado)) {
	            return usuario;
	        }
	
	        return null;
	    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        
        

        Usuario usuario = autenticar(email,password);

        if (usuario != null) {

            HttpSession session = request.getSession();
            session.setAttribute("usuarioLogueado", usuario);

            response.sendRedirect("index.jsp");

        } else {

            request.setAttribute("error", "Credenciales inválidas");
            request.getRequestDispatcher("login.jsp")
                   .forward(request, response);
        }
    }
}