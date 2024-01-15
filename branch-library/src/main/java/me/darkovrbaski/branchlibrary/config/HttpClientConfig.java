package me.darkovrbaski.branchlibrary.config;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HttpClientConfig {

  @Value("${central-lib.host}")
  String centralLibHost;

  @Value("${central-lib.port}")
  String centralLibPort;

  @Bean
  public RestClient centralHttpClient() {
    return RestClient.builder()
        .baseUrl(String.format("http://%s:%s/central-library", centralLibHost, centralLibPort))
        .build();
  }

}
