package com.example.nlp.Configurations;

import com.azure.ai.textanalytics.TextAnalyticsClient;
import com.azure.ai.textanalytics.TextAnalyticsClientBuilder;
import com.azure.core.credential.AzureKeyCredential;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Value("${azure.text-analytics.key}")
    private String azureTextAnalyticsKey;

    @Value("${azure.text-analytics.endpoint}")
    private String azureTextAnalyticsEndpoint;

    @Bean
    public TextAnalyticsClient textAnalyticsClient() {
        return new TextAnalyticsClientBuilder()
                .credential(new AzureKeyCredential(azureTextAnalyticsKey))
                .endpoint(azureTextAnalyticsEndpoint)
                .buildClient();
    }
}
