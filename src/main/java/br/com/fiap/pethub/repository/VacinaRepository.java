package br.com.fiap.pethub.repository;

import br.com.fiap.pethub.entity.Pet;
import br.com.fiap.pethub.entity.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VacinaRepository extends JpaRepository<Vacina, Long> {
    List<Vacina> findByPet(Pet pet);
}
