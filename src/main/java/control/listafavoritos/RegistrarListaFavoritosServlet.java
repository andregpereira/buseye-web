package control.listafavoritos;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.dao.LinhaDAO;
import control.dao.ListaFavoritosDAO;
import control.dao.UsuarioDAO;
import model.Linha;
import model.ListaFavoritos;
import model.Usuario;

@WebServlet("/registrarListaFavoritos")
public class RegistrarListaFavoritosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ListaFavoritosDAO listaFavoritosDao = new ListaFavoritosDAO();
		int idLinha;
		int idUsuario;
		req.setAttribute("idLinha", req.getParameter("idLinha"));
		req.setAttribute("idUsuario", req.getParameter("idUsuario"));

		try {
			idLinha = Math.toIntExact(Long.parseLong(req.getParameter("idLinha")));
			if (!procurarLinhaPorId(idLinha)) {
				req.setAttribute("naoEncontradaL", true);
				req.getRequestDispatcher("formListaFavoritos.jsp").forward(req, resp);
				return;
			}
		} catch (NumberFormatException | ArithmeticException e) {
			req.setAttribute("idInvalidaL", true);
			req.getRequestDispatcher("formListaFavoritos.jsp").forward(req, resp);
			e.printStackTrace();
			return;
		}

		try {
			idUsuario = Math.toIntExact(Long.parseLong(req.getParameter("idUsuario")));
			if (!procurarUsuarioPorId(idUsuario)) {
				req.setAttribute("naoEncontradoU", true);
				req.getRequestDispatcher("formListaFavoritos.jsp").forward(req, resp);
				return;
			}
		} catch (NumberFormatException | ArithmeticException e) {
			req.setAttribute("idInvalidaU", true);
			req.getRequestDispatcher("formListaFavoritos.jsp").forward(req, resp);
			e.printStackTrace();
			return;
		}

		if (listaFavoritosRepetida(listaFavoritosDao, idLinha, idUsuario)) {
			req.setAttribute("repetido", true);
			req.getRequestDispatcher("formListaFavoritos.jsp").forward(req, resp);
			return;
		}

		req.removeAttribute("idLinha");
		req.removeAttribute("idUsuario");

		ListaFavoritos listaFavoritos = new ListaFavoritos();

		listaFavoritos.setIdLinha(idLinha);
		listaFavoritos.setIdUsuario(idUsuario);
		listaFavoritosDao.insert(listaFavoritos);
		req.setAttribute("listaFavoritos", listaFavoritos);
		req.setAttribute("registrado", true);

		req.getRequestDispatcher("formListaFavoritos.jsp").forward(req, resp);
	}

	private boolean procurarLinhaPorId(int id) {
		for (Iterator<Linha> it = new LinhaDAO().select().iterator(); it.hasNext();) {
			Linha linha = it.next();
			if (linha.getIdLinha() == id) {
				return true;
			}
		}
		return false;
	}

	private boolean procurarUsuarioPorId(int id) {
		for (Iterator<Usuario> it = new UsuarioDAO().select().iterator(); it.hasNext();) {
			Usuario usuario = it.next();
			if (usuario.getIdUsuario() == id) {
				return true;
			}
		}
		return false;
	}

	private boolean listaFavoritosRepetida(ListaFavoritosDAO listaFavoritosDao, int idLinha, int idUsuario) {
		for (Iterator<ListaFavoritos> it = listaFavoritosDao.select().iterator(); it.hasNext();) {
			ListaFavoritos listaFavoritos = it.next();
			if (listaFavoritos.getIdLinha() == idLinha && listaFavoritos.getIdUsuario() == idUsuario) {
				return true;
			}
		}
		return false;
	}

}
