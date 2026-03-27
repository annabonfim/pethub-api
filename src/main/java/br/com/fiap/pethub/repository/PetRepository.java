package br.com.fiap.pethub.repository;

import br.com.fiap.pethub.entity.Pet;
import br.com.fiap.pethub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByUser(User user);
}
