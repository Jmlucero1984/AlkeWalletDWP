package Service;

import DAO.UsuarioDAO;
import Model.Usuario;

public class UsuarioService {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public Usuario autenticar(String email, String password) {
        return usuarioDAO.buscarPorEmailYPassword(email, password);
    }
}