package br.com.POO.TRABALHO.API.repository;

import br.com.POO.TRABALHO.API.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);
}
