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
import br.zup.wagner.vacine.form.UsuarioForm;
import br.zup.wagner.vacine.modelo.Usuario;
import br.zup.wagner.vacine.repositorio.UsuarioRepositorio;

@RestController //recebe request, retorna response
@RequestMapping ("/usuario")
public class UsuarioControlador {

	private final UsuarioRepositorio usuarioRepositorio;

	@Autowired
	public UsuarioControlador(UsuarioRepositorio usuarioRepositorio) {
		this.usuarioRepositorio = usuarioRepositorio;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<Usuario> create (@RequestBody @Valid UsuarioForm form, UriComponentsBuilder uriBuilder){
		Usuario usuario = form.converteFormParaUsuario();
		usuarioRepositorio.save(usuario);
		URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(usuario);
	}
	
}
