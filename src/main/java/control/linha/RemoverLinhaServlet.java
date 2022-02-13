package control.linha;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.dao.LinhaDAO;
import model.Linha;

@WebServlet("/removerLinha")
public class RemoverLinhaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LinhaDAO linhaDao = new LinhaDAO();
		int id = Integer.parseInt(req.getParameter("id"));

		for (Iterator<Linha> it = linhaDao.select().iterator(); it.hasNext();) {
			Linha linha = it.next();
			if (linha.getIdLinha() == id) {
				linhaDao.delete(linha);
				req.setAttribute("linha", linha);
				req.setAttribute("removido", true);
				break;
			}
		}

		req.getRequestDispatcher("listaLinhas").forward(req, resp);
	}

}
