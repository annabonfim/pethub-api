package br.com.fiap.pethub.controller;

import br.com.fiap.pethub.entity.Consulta;
import br.com.fiap.pethub.service.ConsultaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/pets/{petId}/consultas")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @GetMapping
    public ResponseEntity<List<Consulta>> listar(@PathVariable Long petId) {
        return ResponseEntity.ok(consultaService.listar(petId));
    }

    @PostMapping
    public ResponseEntity<Consulta> cadastrar(@PathVariable Long petId, @RequestBody Consulta consulta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(consultaService.cadastrar(petId, consulta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consulta> atualizar(@PathVariable Long petId, @PathVariable Long id, @RequestBody Consulta consulta) {
        return ResponseEntity.ok(consultaService.atualizar(id, consulta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        consultaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}