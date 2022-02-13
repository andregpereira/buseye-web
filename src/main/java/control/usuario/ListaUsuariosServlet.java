package control.usuario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.dao.UsuarioDAO;

@WebServlet("/listaUsuarios")
public class ListaUsuariosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("usuarios", new UsuarioDAO().select());
		req.getRequestDispatcher("/listaUsuarios.jsp").forward(req, resp);
	}

}
