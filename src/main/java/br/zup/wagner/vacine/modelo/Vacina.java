package br.zup.wagner.vacine.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vacina {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	@ManyToOne
	private Usuario usuario;
	private LocalDate diaTomou;

	public Vacina(String nome, Usuario usuario, LocalDate diaTomou) {
		this.nome = nome;
		this.usuario = usuario;
		this.diaTomou = diaTomou;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDate getDiaTomou() {
		return diaTomou;
	}

	public void setDiaTomou(LocalDate diaTomou) {
		this.diaTomou = diaTomou;
	}

}
