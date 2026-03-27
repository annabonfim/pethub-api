package br.com.fiap.pethub.client;

public record BreedResponse(
        String id,
        String name,
        String temperament,
        String origin,
        String description
) {}
