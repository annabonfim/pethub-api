package br.com.fiap.pethub.service;

import br.com.fiap.pethub.entity.Consulta;
import br.com.fiap.pethub.entity.Pet;
import br.com.fiap.pethub.repository.ConsultaRepository;
import br.com.fiap.pethub.repository.PetRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final PetRepository petRepository;

    public ConsultaService(ConsultaRepository consultaRepository, PetRepository petRepository) {
        this.consultaRepository = consultaRepository;
        this.petRepository = petRepository;
    }

    public List<Consulta> listar(Long petId) {
        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet não encontrado"));
        return consultaRepository.findByPet(pet);
    }

    public Consulta cadastrar(Long petId, Consulta consulta) {
        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet não encontrado"));
        consulta.setPet(pet);
        return consultaRepository.save(consulta);
    }

    public Consulta atualizar(Long id, Consulta consultaAtualizada) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Consulta não encontrada"));
        consulta.setData(consultaAtualizada.getData());
        consulta.setVeterinario(consultaAtualizada.getVeterinario());
        consulta.setMotivo(consultaAtualizada.getMotivo());
        consulta.setObservacoes(consultaAtualizada.getObservacoes());
        consulta.setPeso(consultaAtualizada.getPeso());
        return consultaRepository.save(consulta);
    }

    public void deletar(Long id) {
        consultaRepository.deleteById(id);
    }
}