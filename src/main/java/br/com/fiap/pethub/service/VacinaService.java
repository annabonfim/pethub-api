package br.com.fiap.pethub.service;

import br.com.fiap.pethub.entity.Pet;
import br.com.fiap.pethub.entity.Vacina;
import br.com.fiap.pethub.repository.PetRepository;
import br.com.fiap.pethub.repository.VacinaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class VacinaService {

    private final VacinaRepository vacinaRepository;
    private final PetRepository petRepository;

    public VacinaService(VacinaRepository vacinaRepository, PetRepository petRepository) {
        this.vacinaRepository = vacinaRepository;
        this.petRepository = petRepository;
    }

    public List<Vacina> listar(Long petId) {
        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet não encontrado"));
        return vacinaRepository.findByPet(pet);
    }

    public Vacina cadastrar(Long petId, Vacina vacina) {
        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet não encontrado"));
        vacina.setPet(pet);
        return vacinaRepository.save(vacina);
    }
    public Vacina atualizar(Long id, Vacina vacinaAtualizada) {
        Vacina vacina = vacinaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vacina não encontrada"));
        vacina.setNome(vacinaAtualizada.getNome());
        vacina.setDataAplicacao(vacinaAtualizada.getDataAplicacao());
        vacina.setProximaDose(vacinaAtualizada.getProximaDose());
        vacina.setObservacoes(vacinaAtualizada.getObservacoes());
        return vacinaRepository.save(vacina);
    }

    public void deletar(Long id) {
        vacinaRepository.deleteById(id);
    }
}