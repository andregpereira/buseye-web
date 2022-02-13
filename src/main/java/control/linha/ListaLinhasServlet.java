package control.linha;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.dao.LinhaDAO;

@WebServlet("/listaLinhas")
public class ListaLinhasServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("linhas", new LinhaDAO().select());
		req.getRequestDispatcher("/listaLinhas.jsp").forward(req, resp);
	}

}
