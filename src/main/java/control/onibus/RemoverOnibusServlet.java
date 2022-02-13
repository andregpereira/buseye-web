package control.onibus;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.dao.OnibusDAO;
import model.Onibus;

@WebServlet("/removerOnibus")
public class RemoverOnibusServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		OnibusDAO onibusDao = new OnibusDAO();
		int id = Integer.parseInt(req.getParameter("id"));

		for (Iterator<Onibus> it = onibusDao.select().iterator(); it.hasNext();) {
			Onibus onibus = it.next();
			if (onibus.getIdOnibus() == id) {
				onibusDao.delete(onibus);
				req.setAttribute("onibus", onibus);
				req.setAttribute("removido", true);
				break;
			}
		}

		req.getRequestDispatcher("listaOnibus").forward(req, resp);
	}

}
