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

@WebServlet("/formAlterarLinha")
public class FormAlterarLinhaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		for (Iterator<Linha> it = new LinhaDAO().select().iterator(); it.hasNext();) {
			Linha linha = it.next();
			if (linha.getIdLinha() == id) {
				req.setAttribute("linha", linha);
				req.getRequestDispatcher("formAlterarLinha.jsp").forward(req, resp);
				break;
			}
		}
	}

}
