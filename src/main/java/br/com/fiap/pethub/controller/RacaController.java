package br.com.fiap.pethub.controller;

import br.com.fiap.pethub.client.CatApiClient;
import br.com.fiap.pethub.client.DogApiClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/racas")
public class RacaController {

    private final DogApiClient dogApiClient;
    private final CatApiClient catApiClient;

    public RacaController(DogApiClient dogApiClient, CatApiClient catApiClient) {
        this.dogApiClient = dogApiClient;
        this.catApiClient = catApiClient;
    }

    @GetMapping("/search")
    public ResponseEntity<?> buscar(@RequestParam String q, @RequestParam String especie) {
        return switch (especie.toUpperCase()) {
            case "CACHORRO" -> ResponseEntity.ok(dogApiClient.buscarRaca(q));
            case "GATO" -> ResponseEntity.ok(catApiClient.buscarRaca(q));
            default -> ResponseEntity.ok(List.of());
        };
    }
}