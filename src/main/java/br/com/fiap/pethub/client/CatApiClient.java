package br.com.fiap.pethub.client;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange("https://api.thecatapi.com/v1")
public interface CatApiClient {

    @GetExchange("/breeds")
    List<BreedResponse> listarRacas();

    @GetExchange("/breeds/search")
    List<BreedResponse> buscarRaca(@RequestParam String q);
}