package br.com.alura.ecomart.controller;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("gerador")
public class GeradorDeProductosController {

    private final ChatClient chatClient;

    public GeradorDeProductosController(@Qualifier("gpt-4o-mini") ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping
    public String gerarProductos() {

        var pergunta = "Gere 5 productos ecológicos";

        return this.chatClient.prompt()
                .user(pergunta)
                .call()
                .content();
    }

}
