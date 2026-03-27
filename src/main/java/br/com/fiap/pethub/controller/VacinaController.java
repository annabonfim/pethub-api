package br.com.fiap.pethub.controller;

import br.com.fiap.pethub.entity.Vacina;
import br.com.fiap.pethub.service.VacinaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets/{petId}/vacinas")
public class VacinaController {

    private final VacinaService vacinaService;

    public VacinaController(VacinaService vacinaService) {
        this.vacinaService = vacinaService;
    }

    @GetMapping
    public ResponseEntity<List<Vacina>> listar(@PathVariable Long petId) {
        return ResponseEntity.ok(vacinaService.listar(petId));
    }

    @PostMapping
    public ResponseEntity<Vacina> cadastrar(@PathVariable Long petId, @RequestBody Vacina vacina) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vacinaService.cadastrar(petId, vacina));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vacina> atualizar(@PathVariable Long id, @RequestBody Vacina vacina) {
        return ResponseEntity.ok(vacinaService.atualizar(id, vacina));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        vacinaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
