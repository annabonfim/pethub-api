package br.com.fiap.pethub.controller;

import br.com.fiap.pethub.entity.Medicamento;
import br.com.fiap.pethub.service.MedicamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets/{petId}/medicamentos")
public class MedicamentoController {

    private final MedicamentoService medicamentoService;

    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    @GetMapping
    public ResponseEntity<List<Medicamento>> listar(@PathVariable Long petId) {
        return ResponseEntity.ok(medicamentoService.listar(petId));
    }

    @PostMapping
    public ResponseEntity<Medicamento> cadastrar(@PathVariable Long petId, @RequestBody Medicamento medicamento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(medicamentoService.cadastrar(petId, medicamento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medicamento> atualizar(@PathVariable Long petId, @PathVariable Long id, @RequestBody Medicamento medicamento) {
        return ResponseEntity.ok(medicamentoService.atualizar(id, medicamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        medicamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
