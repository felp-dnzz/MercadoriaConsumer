package com.info.mercadoriaconsumer.Service;

import com.info.mercadoriaconsumer.Model.Mercadoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class MercadoriaService {
    @Autowired
    private WebClient webClient;

    private final String uri = "/Mercadoria";

    public Mercadoria findById (String codbarras) {
        Mono<Mercadoria> monoMercadoria = this.webClient.method(HttpMethod.GET).
             uri(uri + "/" + codbarras).
                retrieve().
                bodyToMono(Mercadoria.class);
        return monoMercadoria.block();
    }
    public List<Mercadoria> findAll(){
        Mono<List<Mercadoria>> monoListMercadoria = this.webClient.method(HttpMethod.POST).
                uri(uri).
                retrieve().
                bodyToFlux(Mercadoria.class).collectList();
        return monoListMercadoria.block();
    }
    public Mercadoria save(Mercadoria mercadoria) {
        Mono<Mercadoria> monoUsuario = this.webClient.method(HttpMethod.POST).
                uri(uri).
                body(BodyInserters.fromValue(mercadoria)).
                retrieve().
                bodyToMono(Mercadoria.class);
        return monoUsuario.block();
    }

    public Void delete(String codbarras) {
        Mono<Void> monoVoid = this.webClient.method(HttpMethod.DELETE).
                uri(uri + "/" + codbarras).retrieve().bodyToMono(Void.class);
        return monoVoid.block();
    }
}
