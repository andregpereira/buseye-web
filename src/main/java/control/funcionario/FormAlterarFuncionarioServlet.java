package control.funcionario;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.dao.FuncionarioDAO;
import model.Funcionario;

@WebServlet("/formAlterarFuncionario")
public class FormAlterarFuncionarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		for (Iterator<Funcionario> it = new FuncionarioDAO().select().iterator(); it.hasNext();) {
			Funcionario funcionario = it.next();
			if (funcionario.getIdFuncionario() == id) {
				req.setAttribute("funcionario", funcionario);
				req.getRequestDispatcher("formAlterarFuncionario.jsp").forward(req, resp);
				break;
			}
		}

	}

}
