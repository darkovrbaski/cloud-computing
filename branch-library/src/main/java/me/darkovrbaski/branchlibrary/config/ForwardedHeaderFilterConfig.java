package me.darkovrbaski.branchlibrary.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ForwardedHeaderFilter;

@Configuration
public class ForwardedHeaderFilterConfig {

  @Bean
  ForwardedHeaderFilter forwardedHeaderFilter() {
      return new ForwardedHeaderFilter();
  }

}
