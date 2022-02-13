package control.funcionario;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.dao.FuncionarioDAO;
import control.dao.UsuarioDAO;
import model.Funcionario;
import model.Usuario;

@WebServlet("/registrarFuncionario")
public class RegistrarFuncionarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FuncionarioDAO funcionarioDao = new FuncionarioDAO();
		String nome = req.getParameter("nome");
		String cpf = req.getParameter("cpf");
		LocalDate dataNascimento;
		String email = req.getParameter("email");
		String telefone = req.getParameter("telefone");
		String cargo = req.getParameter("cargo");
		String situacao = req.getParameter("situacao");
		req.setAttribute("nome", nome);
		req.setAttribute("cpf", cpf);
		req.setAttribute("dataNascimento", req.getParameter("dataNascimento"));
		req.setAttribute("email", email);
		req.setAttribute("telefone", telefone);
		req.setAttribute("cargo", cargo);
		req.setAttribute("situacao", situacao);

		if (nome.equals("")) {
			req.setAttribute("nomeInvalido", true);
			req.getRequestDispatcher("formFuncionario.jsp").forward(req, resp);
			return;
		}

		try {
			Long.parseLong(cpf);
			if (cpfRepetido(funcionarioDao, cpf)) {
				req.setAttribute("cpfRepetido", true);
				req.getRequestDispatcher("formFuncionario.jsp").forward(req, resp);
				return;
			}
		} catch (NumberFormatException e) {
			req.setAttribute("cpfInvalido", true);
			req.getRequestDispatcher("formFuncionario.jsp").forward(req, resp);
			e.printStackTrace();
			return;
		}

		try {
			dataNascimento = LocalDate.parse(req.getParameter("dataNascimento"),
					DateTimeFormatter.ofPattern("uuuu-MM-dd"));
		} catch (DateTimeParseException e) {
			req.setAttribute("dataInvalida", true);
			req.getRequestDispatcher("formFuncionario.jsp").forward(req, resp);
			e.printStackTrace();
			return;
		}

		if (!validarEmail(email)) {
			req.setAttribute("emailInvalido", true);
			req.getRequestDispatcher("formFuncionario.jsp").forward(req, resp);
			return;
		}

		if (emailRepetidoFuncionario(funcionarioDao, email) || emailRepetidoUsuario(email)) {
			req.setAttribute("emailRepetido", true);
			req.getRequestDispatcher("formFuncionario.jsp").forward(req, resp);
			return;
		}

		try {
			Long.parseLong(telefone);
			if (telefoneRepetido(funcionarioDao, telefone)) {
				req.setAttribute("telefoneRepetido", true);
				req.getRequestDispatcher("formFuncionario.jsp").forward(req, resp);
				return;
			}
		} catch (NumberFormatException e) {
			req.setAttribute("telefoneInvalido", true);
			req.getRequestDispatcher("formFuncionario.jsp").forward(req, resp);
			e.printStackTrace();
			return;
		}

		if (cargo.equals("")) {
			req.setAttribute("cargoInvalido", true);
			req.getRequestDispatcher("formFuncionario.jsp").forward(req, resp);
			return;
		}

		if (situacao == null) {
			req.setAttribute("situacaoInvalida", true);
			req.getRequestDispatcher("formFuncionario.jsp").forward(req, resp);
			return;
		}

		if (!situacao.equalsIgnoreCase("ATIVO") && !situacao.equalsIgnoreCase("INATIVO")) {
			req.setAttribute("situacaoInvalidaHtml", true);
			req.getRequestDispatcher("formFuncionario.jsp").forward(req, resp);
			return;
		}

		req.removeAttribute("nome");
		req.removeAttribute("cpf");
		req.removeAttribute("dataNascimento");
		req.removeAttribute("email");
		req.removeAttribute("telefone");
		req.removeAttribute("cargo");
		req.removeAttribute("situacao");

		Funcionario funcionario = new Funcionario();

		funcionario.setNome(nome.toUpperCase());
		funcionario.setCpf(cpf);
		funcionario.setDataNasc(dataNascimento);
		funcionario.setEmail(email);
		funcionario.setTelefone(telefone);
		funcionario.setCargo(cargo);
		funcionario.setSituacao(situacao.toUpperCase());
		funcionarioDao.insert(funcionario);
		req.setAttribute("registrado", true);
		req.setAttribute("funcionarioRegistrado", funcionario);

		req.getRequestDispatcher("formFuncionario.jsp").forward(req, resp);
	}

	public boolean cpfRepetido(FuncionarioDAO funcionarioDao, String cpf) {
		for (Iterator<Funcionario> it = funcionarioDao.select().iterator(); it.hasNext();) {
			Funcionario funcionario = it.next();
			if (funcionario.getCpf().equals(cpf)) {
				return true;
			}
		}
		return false;
	}

	public boolean emailRepetidoFuncionario(FuncionarioDAO funcionarioDao, String email) {
		for (Iterator<Funcionario> it = funcionarioDao.select().iterator(); it.hasNext();) {
			Funcionario funcionario = it.next();
			if (funcionario.getEmail().equalsIgnoreCase(email)) {
				return true;
			}
		}
		return false;
	}

	private boolean emailRepetidoUsuario(String email) {
		for (Iterator<Usuario> it = new UsuarioDAO().select().iterator(); it.hasNext();) {
			Usuario usuario = it.next();
			if (usuario.getEmail().equalsIgnoreCase(email)) {
				return true;
			}
		}
		return false;
	}

	private boolean telefoneRepetido(FuncionarioDAO funcionarioDao, String telefone) {
		for (Iterator<Funcionario> it = funcionarioDao.select().iterator(); it.hasNext();) {
			Funcionario funcionario = it.next();
			if (funcionario.getTelefone().equalsIgnoreCase(telefone)) {
				return true;
			}
		}
		return false;
	}

	private boolean validarEmail(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}

}
