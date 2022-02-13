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

@WebServlet("/alterarListaFavoritos")
public class AlterarListaFavoritosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ListaFavoritosDAO listaFavoritosDao = new ListaFavoritosDAO();
		int id = Integer.parseInt(req.getParameter("id"));
		int idLinha;
		int idUsuario;

		try {
			idLinha = Math.toIntExact(Long.parseLong(req.getParameter("idLinha")));
			if (!procurarLinhaPorId(idLinha)) {
				req.setAttribute("naoEncontradaL", true);
				req.getRequestDispatcher("formAlterarListaFavoritos").forward(req, resp);
				return;
			}
		} catch (NumberFormatException | ArithmeticException e) {
			req.setAttribute("idInvalidaL", true);
			req.getRequestDispatcher("formAlterarListaFavoritos").forward(req, resp);
			e.printStackTrace();
			return;
		}

		try {
			idUsuario = Math.toIntExact(Long.parseLong(req.getParameter("idUsuario")));
			if (!procurarUsuarioPorId(idUsuario)) {
				req.setAttribute("naoEncontradoU", true);
				req.getRequestDispatcher("formAlterarListaFavoritos").forward(req, resp);
				return;
			}
		} catch (NumberFormatException | ArithmeticException e) {
			req.setAttribute("idInvalidaU", true);
			req.getRequestDispatcher("formAlterarListaFavoritos").forward(req, resp);
			e.printStackTrace();
			return;
		}

		if (listaFavoritosRepetida(listaFavoritosDao, id, idLinha, idUsuario)) {
			req.setAttribute("repetido", true);
			req.getRequestDispatcher("formAlterarListaFavoritos").forward(req, resp);
			return;
		}

		for (Iterator<ListaFavoritos> it = listaFavoritosDao.select().iterator(); it.hasNext();) {
			ListaFavoritos listaFavoritos = it.next();
			if (listaFavoritos.getIdLista() == id) {
				listaFavoritos.setIdLinha(idLinha);
				listaFavoritos.setIdUsuario(idUsuario);
				listaFavoritosDao.update(listaFavoritos);
				req.setAttribute("listaFav", listaFavoritos);
				req.setAttribute("alterado", true);
				break;
			}
		}

		req.getRequestDispatcher("listaListaFavoritos").forward(req, resp);
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

	private boolean listaFavoritosRepetida(ListaFavoritosDAO listaFavoritosDao, int id, int idLinha, int idUsuario) {
		for (Iterator<ListaFavoritos> it = listaFavoritosDao.select().iterator(); it.hasNext();) {
			ListaFavoritos listaFavoritos = it.next();
			if (listaFavoritos.getIdLista() != id && listaFavoritos.getIdLinha() == idLinha
					&& listaFavoritos.getIdUsuario() == idUsuario) {
				return true;
			}
		}
		return false;
	}

}
