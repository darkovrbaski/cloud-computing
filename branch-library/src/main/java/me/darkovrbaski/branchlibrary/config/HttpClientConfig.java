package me.darkovrbaski.branchlibrary.config;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HttpClientConfig {

  @Bean
  public RestClient centralHttpClient() {
    return RestClient.builder()
        .baseUrl("http://lib-cn:8080/central-library")
        .build();
  }

}
