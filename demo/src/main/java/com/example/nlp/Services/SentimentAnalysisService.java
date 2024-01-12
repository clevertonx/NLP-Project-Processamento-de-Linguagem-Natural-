package com.example.nlp.Services;

import com.azure.ai.textanalytics.TextAnalyticsClient;
import com.azure.ai.textanalytics.models.DocumentSentiment;
import com.azure.ai.textanalytics.models.SentimentConfidenceScores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SentimentAnalysisService {

    private final TextAnalyticsClient textAnalyticsClient;

    @Autowired
    public SentimentAnalysisService(TextAnalyticsClient textAnalyticsClient) {
        this.textAnalyticsClient = textAnalyticsClient;
    }

    public String analisarSentimento(String texto) {
        DocumentSentiment documentSentiment = textAnalyticsClient.analyzeSentiment(texto);

        String sentimentoMapeado = mapearSentimento(String.valueOf(documentSentiment.getSentiment()));

        return "Sentimento analisado: " + sentimentoMapeado;
    }

    private String mapearSentimento(String sentiment) {
        switch (sentiment) {
            case "positive":
                return "Positivo";
            case "negative":
                return "Negativo";
            default:
                return "Neutro";
        }
    }
}

