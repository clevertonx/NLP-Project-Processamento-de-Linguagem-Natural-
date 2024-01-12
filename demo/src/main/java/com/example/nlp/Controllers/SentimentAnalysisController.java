package com.example.nlp.Controllers;

import com.example.nlp.Services.SentimentAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/analise-sentimento")
public class SentimentAnalysisController {

    private final SentimentAnalysisService sentimentAnalysisService;

    @Autowired
    public SentimentAnalysisController(SentimentAnalysisService sentimentAnalysisService) {
        this.sentimentAnalysisService = sentimentAnalysisService;
    }

    @PostMapping("/analisar")
    public ResponseEntity<String> analisarSentimento(@RequestBody String texto) {
        String resultado = sentimentAnalysisService.analisarSentimento(texto);
        return ResponseEntity.ok(resultado);
    }
}
