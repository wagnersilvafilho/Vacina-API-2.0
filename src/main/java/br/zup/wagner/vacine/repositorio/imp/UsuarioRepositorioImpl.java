package br.zup.wagner.vacine.repositorio.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.zup.wagner.vacine.modelo.Usuario;
import br.zup.wagner.vacine.repositorio.UsuarioRepositorio;

@Service
public class UsuarioRepositorioImpl implements UsuarioRepositorio{
	
		private UsuarioJPARep usuarioRepositorio;

		@Autowired
		public UsuarioRepositorioImpl(UsuarioJPARep usuarioRepositorio) {
			this.usuarioRepositorio = usuarioRepositorio;
		}
		
		@Override
		public void save (Usuario usuario) {
			this.usuarioRepositorio.save(usuario);
		}

		@Override
		public Usuario findByEmail(String email) {
			return this.usuarioRepositorio.findByEmail(email);
		}
		
}
