package model;

import java.time.LocalTime;

public class Linha {

	private int idLinha;
	private String nome;
	private LocalTime duracaoPercurso;
	private int idFuncionario;

	public int getIdLinha() {
		return idLinha;
	}

	public void setIdLinha(int idLinha) {
		this.idLinha = idLinha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalTime getDuracaoPercurso() {
		return duracaoPercurso;
	}

	public void setDuracaoPercurso(LocalTime duracaoPercurso) {
		this.duracaoPercurso = duracaoPercurso;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

}
