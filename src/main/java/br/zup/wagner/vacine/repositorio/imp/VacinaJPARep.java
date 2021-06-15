package br.zup.wagner.vacine.repositorio.imp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.zup.wagner.vacine.modelo.Vacina;

@Repository
public interface VacinaJPARep extends JpaRepository<Vacina, Long>{
	
}
