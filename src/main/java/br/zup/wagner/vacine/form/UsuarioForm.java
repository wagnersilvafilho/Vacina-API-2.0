package br.zup.wagner.vacine.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import br.zup.wagner.vacine.modelo.Usuario;

public class UsuarioForm {
	@NotNull
	@NotEmpty
	private String nome;
	@NotNull
	@NotEmpty
	private String email;
	@NotNull
	@NotEmpty
	@CPF
	private String cpf;
	@NotNull
	@Past
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate nascimento;
	
	public UsuarioForm(String nome, String email, String cpf, LocalDate nascimento) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.nascimento = nascimento;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public LocalDate getNascimento() {
		return nascimento;
	}
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	
	public Usuario converteFormParaUsuario() {
		return new Usuario (this.nome, this.email, this.cpf, this.nascimento);
	}
	
}
