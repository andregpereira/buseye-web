package control.listafavoritos;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.dao.ListaFavoritosDAO;
import model.ListaFavoritos;

@WebServlet("/removerListaFavoritos")
public class RemoverListaFavoritosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ListaFavoritosDAO listaFavoritosDao = new ListaFavoritosDAO();
		int id = Integer.parseInt(req.getParameter("id"));

		for (Iterator<ListaFavoritos> it = listaFavoritosDao.select().iterator(); it.hasNext();) {
			ListaFavoritos listaFavoritos = it.next();
			if (listaFavoritos.getIdLista() == id) {
				listaFavoritosDao.delete(listaFavoritos);
				req.setAttribute("listaFav", listaFavoritos);
				req.setAttribute("removido", true);
				break;
			}
		}

		req.getRequestDispatcher("listaListaFavoritos").forward(req, resp);
	}

}
