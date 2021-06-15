package br.zup.wagner.vacine.controlador;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import br.zup.wagner.vacine.form.VacinaForm;
import br.zup.wagner.vacine.modelo.Vacina;
import br.zup.wagner.vacine.repositorio.VacinaRepositorio;

@RestController //recebe request, retorna response
@RequestMapping ("/vacina")
public class VacinaControlador {
	
	private final VacinaRepositorio vacinaRepositorio;

	@Autowired
	public VacinaControlador(VacinaRepositorio vacinaRepositorio) {
		this.vacinaRepositorio = vacinaRepositorio;
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<Vacina> create (@RequestBody @Valid VacinaForm form, UriComponentsBuilder uriBuilder){
		Vacina vacina = form.converteFormParaVacina();
		vacinaRepositorio.save(vacina);
		URI uri = uriBuilder.path("/vacina/{id}").buildAndExpand(vacina.getId()).toUri();
		return ResponseEntity.created(uri).body(vacina);
	}
	
}

