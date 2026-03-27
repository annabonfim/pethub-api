package br.com.fiap.pethub.client;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange("https://api.thedogapi.com/v1")
public interface DogApiClient {

    @GetExchange("/breeds")
    List<BreedResponse> listarRacas();

    @GetExchange("/breeds/search")
    List<BreedResponse> buscarRaca(@RequestParam String q);
}
