package control.linha;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.dao.FuncionarioDAO;
import control.dao.LinhaDAO;
import model.Funcionario;
import model.Linha;

@WebServlet("/registrarLinha")
public class RegistrarLinhaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LinhaDAO linhaDao = new LinhaDAO();
		String nome = req.getParameter("nome");
		LocalTime duracaoPercurso;
		int idFuncionario;
		req.setAttribute("nome", nome);
		req.setAttribute("duracaoPercurso", req.getParameter("duracaoPercurso"));
		req.setAttribute("idFuncionario", req.getParameter("idFuncionario"));

		if (nome.equals("")) {
			req.setAttribute("nomeInvalido", true);
			req.getRequestDispatcher("formLinha.jsp").forward(req, resp);
			return;
		}

		try {
			duracaoPercurso = LocalTime.parse(req.getParameter("duracaoPercurso"),
					DateTimeFormatter.ofPattern("HH:mm"));
		} catch (DateTimeParseException e) {
			req.setAttribute("duracaoPercursoInvalida", true);
			req.getRequestDispatcher("formLinha.jsp").forward(req, resp);
			e.printStackTrace();
			return;
		}

		try {
			idFuncionario = Integer.parseInt(req.getParameter("idFuncionario"));
			if (!procurarFuncionarioPorId(idFuncionario)) {
				req.setAttribute("naoEncontrado", true);
				req.getRequestDispatcher("formLinha.jsp").forward(req, resp);
				return;
			}
		} catch (NumberFormatException | ArithmeticException e) {
			req.setAttribute("idInvalida", true);
			req.getRequestDispatcher("formLinha.jsp").forward(req, resp);
			e.printStackTrace();
			return;
		}

		if (linhaRepetida(linhaDao, nome, idFuncionario)) {
			req.setAttribute("repetido", true);
			req.getRequestDispatcher("formLinha.jsp").forward(req, resp);
			return;
		}

		req.removeAttribute("nome");
		req.removeAttribute("duracaoPercurso");
		req.removeAttribute("idFuncionario");

		Linha linha = new Linha();

		linha.setNome(nome);
		linha.setDuracaoPercurso(duracaoPercurso);
		linha.setIdFuncionario(idFuncionario);
		linhaDao.insert(linha);
		req.setAttribute("linha", linha);
		req.setAttribute("registrado", true);

		req.getRequestDispatcher("formLinha.jsp").forward(req, resp);
	}

	private boolean procurarFuncionarioPorId(int id) {
		for (Iterator<Funcionario> it = new FuncionarioDAO().select().iterator(); it.hasNext();) {
			Funcionario funcionario = it.next();
			if (funcionario.getIdFuncionario() == id) {
				return true;
			}
		}
		return false;
	}

	private boolean linhaRepetida(LinhaDAO linhaDao, String nome, int idFuncionario) {
		for (Iterator<Linha> it = linhaDao.select().iterator(); it.hasNext();) {
			Linha linha = it.next();
			if (linha.getNome().equalsIgnoreCase(nome) && linha.getIdFuncionario() == idFuncionario) {
				return true;
			}
		}
		return false;
	}

}
