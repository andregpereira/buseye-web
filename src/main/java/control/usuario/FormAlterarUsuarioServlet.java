package control.usuario;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.dao.UsuarioDAO;
import model.Usuario;

@WebServlet("/formAlterarUsuario")
public class FormAlterarUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		for (Iterator<Usuario> it = new UsuarioDAO().select().iterator(); it.hasNext();) {
			Usuario usuario = it.next();
			if (usuario.getIdUsuario() == id) {
				req.setAttribute("usuario", usuario);
				req.getRequestDispatcher("formAlterarUsuario.jsp").forward(req, resp);
				break;
			}
		}
	}

}
