package br.com.fiap.pethub.config;

import br.com.fiap.pethub.client.CatApiClient;
import br.com.fiap.pethub.client.DogApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;


@Configuration
public class HttpExchangeConfig {

    @Bean
    public DogApiClient dogApiClient() {
        RestClient restClient = RestClient.builder()
                .baseUrl("https://api.thedogapi.com/v1")
                .defaultHeader("x-api-key", "live_BBOo5SKg7cYU3i3udiTPdbqCZNx0S0y2GARPC95nVkH9ZPrRct889lv3CknVB1oy")
                .build();
        return HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(restClient))
                .build()
                .createClient(DogApiClient.class);
    }

    @Bean
    public CatApiClient catApiClient() {
        RestClient restClient = RestClient.builder()
                .baseUrl("https://api.thecatapi.com/v1")
                .defaultHeader("x-api-key", "live_ZnaksXh1EqzouWCWwF4caqrewIvzO9SPjBNiXRuHBkoUYMLmZXRrQi38kc0IjJyP")
                .build();
        return HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(restClient))
                .build()
                .createClient(CatApiClient.class);
    }
}