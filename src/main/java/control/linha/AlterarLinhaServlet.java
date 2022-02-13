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

@WebServlet("/alterarLinha")
public class AlterarLinhaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LinhaDAO linhaDao = new LinhaDAO();
		int id = Integer.parseInt(req.getParameter("id"));
		String nome = req.getParameter("nome");
		LocalTime duracaoPercurso;
		int idFuncionario;

		if (nome.equals("")) {
			req.setAttribute("nomeInvalido", true);
			req.getRequestDispatcher("formAlterarLinha").forward(req, resp);
			return;
		}

		try {
			duracaoPercurso = LocalTime.parse(req.getParameter("duracaoPercurso"),
					DateTimeFormatter.ofPattern("HH:mm"));
		} catch (DateTimeParseException e) {
			req.setAttribute("duracaoPercursoInvalida", true);
			req.getRequestDispatcher("formAlterarLinha").forward(req, resp);
			e.printStackTrace();
			return;
		}

		try {
			idFuncionario = Integer.parseInt(req.getParameter("idFuncionario"));
			if (!procurarFuncionarioPorId(idFuncionario)) {
				req.setAttribute("naoEncontrado", true);
				req.getRequestDispatcher("formAlterarLinha").forward(req, resp);
				return;
			}
		} catch (NumberFormatException | ArithmeticException e) {
			req.setAttribute("idInvalida", true);
			req.getRequestDispatcher("formAlterarLinha").forward(req, resp);
			e.printStackTrace();
			return;
		}

		if (linhaRepetida(linhaDao, nome, idFuncionario)) {
			req.setAttribute("repetido", true);
			req.getRequestDispatcher("formAlterarLinha").forward(req, resp);
			return;
		}

		for (Iterator<Linha> it = linhaDao.select().iterator(); it.hasNext();) {
			Linha linha = it.next();
			if (linha.getIdLinha() == id) {
				linha.setNome(nome);
				linha.setDuracaoPercurso(duracaoPercurso);
				linha.setIdFuncionario(idFuncionario);
				linhaDao.update(linha);
				req.setAttribute("linha", linha);
				req.setAttribute("alterado", true);
				break;
			}
		}

		req.getRequestDispatcher("listaLinhas").forward(req, resp);
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
