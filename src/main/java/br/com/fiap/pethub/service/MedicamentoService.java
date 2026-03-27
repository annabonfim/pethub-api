package br.com.fiap.pethub.service;


import br.com.fiap.pethub.entity.Medicamento;
import br.com.fiap.pethub.entity.Pet;
import br.com.fiap.pethub.repository.MedicamentoRepository;
import br.com.fiap.pethub.repository.PetRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;
    private final PetRepository petRepository;

    public MedicamentoService(MedicamentoRepository medicamentoRepository, PetRepository petRepository) {
        this.medicamentoRepository = medicamentoRepository;
        this.petRepository = petRepository;
    }

    public List<Medicamento> listar(Long petId) {
        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet não encontrado"));
        return medicamentoRepository.findByPet(pet);
    }

    public Medicamento cadastrar(Long petId, Medicamento medicamento) {
        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet não encontrado"));
        medicamento.setPet(pet);
        return medicamentoRepository.save(medicamento);
    }

    public Medicamento atualizar(Long id, Medicamento medicamentoAtualizado) {
        Medicamento medicamento = medicamentoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medicamento não encontrado"));
        medicamento.setNome(medicamentoAtualizado.getNome());
        medicamento.setDose(medicamentoAtualizado.getDose());
        medicamento.setFrequencia(medicamentoAtualizado.getFrequencia());
        medicamento.setDataInicio(medicamentoAtualizado.getDataInicio());
        medicamento.setDataFim(medicamentoAtualizado.getDataFim());
        return medicamentoRepository.save(medicamento);
    }

    public void deletar(Long id) {
        medicamentoRepository.deleteById(id);
    }
}