package control.listafavoritos;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.dao.ListaFavoritosDAO;

@WebServlet("/listaListaFavoritos")
public class ListaListaFavoritosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("listaFavoritos", new ListaFavoritosDAO().select());
		req.getRequestDispatcher("/listaListaFavoritos.jsp").forward(req, resp);
	}

}
