package br.zup.wagner.vacine.repositorio.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.zup.wagner.vacine.modelo.Vacina;
import br.zup.wagner.vacine.repositorio.VacinaRepositorio;

@Service
public class VacinaRepositorioImpl implements VacinaRepositorio{
	
	private VacinaJPARep vacinaRepositorio;
	
	@Autowired //injeção dependência, classe inicada, executa construtor, classe é construida, é injetado dentro dela a interface
	public VacinaRepositorioImpl(VacinaJPARep vacinarepositorio) {
		this.vacinaRepositorio = vacinarepositorio;
	}

	@Override //sobrescrita
	public void save(Vacina vacina) {
		this.vacinaRepositorio.save(vacina);
	}
	
}
