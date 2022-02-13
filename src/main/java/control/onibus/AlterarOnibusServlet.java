package control.onibus;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.dao.FuncionarioDAO;
import control.dao.LinhaDAO;
import control.dao.OnibusDAO;
import model.Funcionario;
import model.Linha;
import model.Onibus;

@WebServlet("/alterarOnibus")
public class AlterarOnibusServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		OnibusDAO onibusDao = new OnibusDAO();
		int id = Integer.parseInt(req.getParameter("id"));
		String localizacao = req.getParameter("localizacao");
		int idFuncionario;
		int idLinha;
		int capacidade;

		if (localizacao.equals("")) {
			req.setAttribute("localizacaoInvalida", true);
			req.getRequestDispatcher("formAlterarOnibus").forward(req, resp);
			return;
		}

		try {
			idFuncionario = Integer.parseInt(req.getParameter("idFuncionario"));
			if (!procurarFuncionarioPorId(idFuncionario)) {
				req.setAttribute("naoEncontradoF", true);
				req.getRequestDispatcher("formAlterarOnibus").forward(req, resp);
				return;
			}
		} catch (NumberFormatException | ArithmeticException e) {
			req.setAttribute("idInvalidaF", true);
			req.getRequestDispatcher("formAlterarOnibus").forward(req, resp);
			e.printStackTrace();
			return;
		}

		try {
			idLinha = Integer.parseInt(req.getParameter("idLinha"));
			if (!procurarLinhaPorId(idLinha)) {
				req.setAttribute("naoEncontradaL", true);
				req.getRequestDispatcher("formAlterarOnibus").forward(req, resp);
				return;
			}
		} catch (NumberFormatException | ArithmeticException e) {
			req.setAttribute("idInvalidaL", true);
			req.getRequestDispatcher("formAlterarOnibus").forward(req, resp);
			e.printStackTrace();
			return;
		}

		try {
			capacidade = Integer.parseInt(req.getParameter("capacidade"));
		} catch (NumberFormatException | ArithmeticException e) {
			req.setAttribute("capacidadeInvalida", true);
			req.getRequestDispatcher("formAlterarOnibus").forward(req, resp);
			e.printStackTrace();
			return;
		}

		if (onibusRepetido(onibusDao, id, idFuncionario, idLinha)) {
			req.setAttribute("repetido", true);
			req.getRequestDispatcher("formAlterarOnibus").forward(req, resp);
			return;
		}

		for (Iterator<Onibus> it = onibusDao.select().iterator(); it.hasNext();) {
			Onibus onibus = it.next();
			if (onibus.getIdOnibus() == id) {
				onibus.setLocalizacao(localizacao);
				onibus.setIdFuncionario(idFuncionario);
				onibus.setIdLinha(idLinha);
				onibus.setCapacidade(capacidade);
				onibusDao.update(onibus);
				req.setAttribute("onibus", onibus);
				req.setAttribute("alterado", true);
				break;
			}
		}

		req.getRequestDispatcher("listaOnibus").forward(req, resp);
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

	private boolean procurarLinhaPorId(int id) {
		for (Iterator<Linha> it = new LinhaDAO().select().iterator(); it.hasNext();) {
			Linha linha = it.next();
			if (linha.getIdLinha() == id) {
				return true;
			}
		}
		return false;
	}

	private boolean onibusRepetido(OnibusDAO onibusDao, int id, int idFuncionario, int idLinha) {
		for (Iterator<Onibus> it = onibusDao.select().iterator(); it.hasNext();) {
			Onibus onibus = it.next();
			if (onibus.getIdOnibus() != id && onibus.getIdFuncionario() == idFuncionario
					&& onibus.getIdLinha() == idLinha) {
				return true;
			}
		}
		return false;
	}

}
