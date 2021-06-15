package br.zup.wagner.vacine.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import br.zup.wagner.vacine.modelo.Usuario;
import br.zup.wagner.vacine.modelo.Vacina;
import br.zup.wagner.vacine.repositorio.UsuarioRepositorio;

public class VacinaForm {
	@NotNull
	@NotEmpty
	private String nome;
	@NotNull
	@NotEmpty
	private String email;
	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate diaTomou;

	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	public VacinaForm(String nome, String email, LocalDate diaTomou, UsuarioRepositorio usuarioRepositorio) {
		this.nome = nome;
		this.email = email;
		this.diaTomou = diaTomou;
		this.usuarioRepositorio = usuarioRepositorio;
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

	public LocalDate getDiaTomou() {
		return diaTomou;
	}

	public void setDiaTomou(LocalDate diaTomou) {
		this.diaTomou = diaTomou;
	}
	
	public Vacina converteFormParaVacina () {
		Usuario usuario = this.usuarioRepositorio.findByEmail(email);
		return new Vacina (this.nome, usuario, this.diaTomou);
	}

}
