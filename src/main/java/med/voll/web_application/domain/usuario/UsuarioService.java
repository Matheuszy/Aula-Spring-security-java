package med.voll.web_application.domain.usuario;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario loadUserByUsername(String username) {
        return repository.findByEmailIgnoreCase(username).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
}
