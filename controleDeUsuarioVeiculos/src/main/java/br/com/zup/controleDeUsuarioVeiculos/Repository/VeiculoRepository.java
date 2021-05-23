package br.com.zup.controleDeUsuarioVeiculos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.controleDeUsuarioVeiculos.modelo.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{

}
