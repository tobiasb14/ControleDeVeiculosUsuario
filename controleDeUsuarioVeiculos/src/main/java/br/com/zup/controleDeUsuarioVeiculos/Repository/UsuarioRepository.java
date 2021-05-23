package br.com.zup.controleDeUsuarioVeiculos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.controleDeUsuarioVeiculos.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
