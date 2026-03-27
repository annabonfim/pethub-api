package br.com.fiap.pethub.repository;

import br.com.fiap.pethub.entity.Consulta;
import br.com.fiap.pethub.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    List<Consulta> findByPet(Pet pet);
}
