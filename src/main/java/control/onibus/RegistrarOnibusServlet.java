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

@WebServlet("/registrarOnibus")
public class RegistrarOnibusServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		OnibusDAO onibusDao = new OnibusDAO();
		String localizacao = req.getParameter("localizacao");
		int idFuncionario;
		int idLinha;
		int capacidade;
		req.setAttribute("localizacao", localizacao);
		req.setAttribute("idFuncionario", req.getParameter("idFuncionario"));
		req.setAttribute("idLinha", req.getParameter("idLinha"));
		req.setAttribute("capacidade", req.getParameter("capacidade"));

		if (localizacao.equals("")) {
			req.setAttribute("localizacaoInvalida", true);
			req.getRequestDispatcher("formOnibus.jsp").forward(req, resp);
			return;
		}

		try {
			idFuncionario = Integer.parseInt(req.getParameter("idFuncionario"));
			if (!procurarFuncionarioPorId(idFuncionario)) {
				req.setAttribute("naoEncontradoF", true);
				req.getRequestDispatcher("formOnibus.jsp").forward(req, resp);
				return;
			}
		} catch (NumberFormatException | ArithmeticException e) {
			req.setAttribute("idInvalidaF", true);
			req.getRequestDispatcher("formOnibus.jsp").forward(req, resp);
			e.printStackTrace();
			return;
		}

		try {
			idLinha = Integer.parseInt(req.getParameter("idLinha"));
			if (!procurarLinhaPorId(idLinha)) {
				req.setAttribute("naoEncontradoL", true);
				req.getRequestDispatcher("formOnibus.jsp").forward(req, resp);
				return;
			}
		} catch (NumberFormatException | ArithmeticException e) {
			req.setAttribute("idInvalidaL", true);
			req.getRequestDispatcher("formOnibus.jsp").forward(req, resp);
			e.printStackTrace();
			return;
		}

		try {
			capacidade = Integer.parseInt(req.getParameter("capacidade"));
		} catch (NumberFormatException | ArithmeticException e) {
			req.setAttribute("capacidadeInvalida", true);
			req.getRequestDispatcher("formOnibus.jsp").forward(req, resp);
			e.printStackTrace();
			return;
		}

		if (onibusRepetido(onibusDao, idFuncionario, idLinha)) {
			req.setAttribute("repetido", true);
			req.getRequestDispatcher("formOnibus.jsp").forward(req, resp);
			return;
		}

		req.removeAttribute("localizacao");
		req.removeAttribute("idFuncionario");
		req.removeAttribute("idLinha");
		req.removeAttribute("capacidade");

		Onibus onibus = new Onibus();

		onibus.setLocalizacao(localizacao);
		onibus.setIdFuncionario(idFuncionario);
		onibus.setIdLinha(idLinha);
		onibus.setCapacidade(capacidade);
		onibusDao.insert(onibus);
		req.setAttribute("onibus", onibus);
		req.setAttribute("registrado", true);

		req.getRequestDispatcher("formOnibus.jsp").forward(req, resp);
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

	private boolean onibusRepetido(OnibusDAO onibusDao, int idFuncionario, int idLinha) {
		for (Iterator<Onibus> it = onibusDao.select().iterator(); it.hasNext();) {
			Onibus onibus = it.next();
			if (onibus.getIdFuncionario() == idFuncionario && onibus.getIdLinha() == idLinha) {
				return true;
			}
		}
		return false;
	}

}
