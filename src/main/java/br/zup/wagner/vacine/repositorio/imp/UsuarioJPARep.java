package br.zup.wagner.vacine.repositorio.imp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.zup.wagner.vacine.modelo.Usuario;

@Repository
public interface UsuarioJPARep extends JpaRepository<Usuario, Long>{
	Usuario findByEmail(String email);
}
