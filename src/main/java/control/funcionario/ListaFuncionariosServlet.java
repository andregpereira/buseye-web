package control.funcionario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.dao.FuncionarioDAO;

@WebServlet("/listaFuncionarios")
public class ListaFuncionariosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("funcionarios", new FuncionarioDAO().select());
		req.getRequestDispatcher("/listaFuncionarios.jsp").forward(req, resp);
	}

}
