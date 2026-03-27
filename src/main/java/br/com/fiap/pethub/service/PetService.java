package br.com.fiap.pethub.service;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import br.com.fiap.pethub.repository.PetRepository;
import br.com.fiap.pethub.repository.UserRepository;
import br.com.fiap.pethub.entity.Pet;
import br.com.fiap.pethub.entity.User;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository;
    private final UserRepository userRepository;

    public PetService(PetRepository petRepository, UserRepository userRepository) {
        this.petRepository = petRepository;
        this.userRepository = userRepository;
    }

    public List<Pet> listarMeusPets(String email) {
        User user = userRepository.findByEmail(email).orElseThrow();
        return petRepository.findByUser(user);
    }

    public Pet cadastrar(Pet pet, String email) {
        User user = userRepository.findByEmail(email).orElseThrow();
        pet.setUser(user);
        return petRepository.save(pet);
    }

    public Pet buscarPorId(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet não encontrado"));
    }

    public Pet atualizar(Long id, Pet petAtualizado) {
        Pet pet = buscarPorId(id);
        pet.setNome(petAtualizado.getNome());
        pet.setEspecie(petAtualizado.getEspecie());
        pet.setRaca(petAtualizado.getRaca());
        pet.setDataNascimento(petAtualizado.getDataNascimento());
        return petRepository.save(pet);
    }

    public void deletar(Long id) {
        petRepository.deleteById(id);
    }
}