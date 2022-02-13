package control.usuario;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.dao.FuncionarioDAO;
import control.dao.UsuarioDAO;
import model.Funcionario;
import model.Usuario;

@WebServlet("/registrarUsuario")
public class RegistrarUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UsuarioDAO usuarioDao = new UsuarioDAO();
		String email = req.getParameter("email");
		String localizacao = req.getParameter("localizacao");
		req.setAttribute("email", email);
		req.setAttribute("localizacao", localizacao);

		if (!validarEmail(email)) {
			req.setAttribute("emailInvalido", true);
			req.getRequestDispatcher("formUsuario.jsp").forward(req, resp);
			return;
		}

		if (emailRepetidoFuncionario(email) || emailRepetidoUsuario(usuarioDao, email)) {
			req.setAttribute("emailRepetido", true);
			req.getRequestDispatcher("formUsuario.jsp").forward(req, resp);
			return;
		}

		if (localizacao.equals("")) {
			req.setAttribute("localizacaoInvalida", true);
			req.getRequestDispatcher("formUsuario.jsp").forward(req, resp);
			return;
		}

		req.removeAttribute("email");
		req.removeAttribute("localizacao");

		Usuario usuario = new Usuario();

		usuario.setEmail(email);
		usuario.setLocalizacao(localizacao);
		usuarioDao.insert(usuario);
		req.setAttribute("registrado", true);

		req.getRequestDispatcher("formUsuario.jsp").forward(req, resp);
	}

	private boolean emailRepetidoFuncionario(String email) {
		for (Iterator<Funcionario> it = new FuncionarioDAO().select().iterator(); it.hasNext();) {
			Funcionario funcionario = it.next();
			if (funcionario.getEmail().equalsIgnoreCase(email)) {
				return true;
			}
		}
		return false;
	}

	private boolean emailRepetidoUsuario(UsuarioDAO usuarioDao, String email) {
		for (Iterator<Usuario> it = usuarioDao.select().iterator(); it.hasNext();) {
			Usuario usuario = it.next();
			if (usuario.getEmail().equalsIgnoreCase(email)) {
				return true;
			}
		}
		return false;
	}

	private boolean validarEmail(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}

}
