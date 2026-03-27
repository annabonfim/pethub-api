package br.com.fiap.pethub.repository;

import br.com.fiap.pethub.entity.Medicamento;
import br.com.fiap.pethub.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
    List<Medicamento> findByPet(Pet pet);
}
