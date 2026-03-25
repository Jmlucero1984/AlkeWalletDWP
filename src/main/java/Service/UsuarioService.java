package Service;

import org.mindrot.jbcrypt.BCrypt;

import DAO.UsuarioDAO;
import Model.Usuario;

public class UsuarioService {

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
}