package br.zup.wagner.vacine.repositorio;

import br.zup.wagner.vacine.modelo.Usuario;

public interface UsuarioRepositorio{
	void save (Usuario usuario);
	Usuario findByEmail (String email);
}
