package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Usuario;
import Service.UsuarioService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UsuarioService usuarioService = new UsuarioService();



    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Usuario usuario = usuarioService.autenticar(email, password);

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