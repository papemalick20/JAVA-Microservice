package org.paiement.openfeign;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Configuration
public class Feignconf {
	
	@Bean
    RequestInterceptor patchInterceptor() {
        return new RequestInterceptor() {
            @SuppressWarnings("deprecation")
			@Override
            public void apply(RequestTemplate template) {
                if (template.method().equalsIgnoreCase("PATCH")) {
                    template.method("PATCH");
                }
            }
        };
    }

}
