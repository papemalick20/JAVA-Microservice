package org.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayAdriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayAdriaApplication.class, args);
	}
	
	@Bean
    DiscoveryClientRouteDefinitionLocator discoveryClientRouteDefinitionLocator(
           ReactiveDiscoveryClient discoveryClient, 
           DiscoveryLocatorProperties properties) {
       return new DiscoveryClientRouteDefinitionLocator(discoveryClient, properties);
   }

}
