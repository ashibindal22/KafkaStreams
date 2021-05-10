package com.example.domainService;

import java.util.function.Consumer;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.domaincrawler.Domain;

@Configuration
public class DomainKafkaConsumer {
	
	@Bean
	public Consumer<KStream<String, Domain>> domainService()
	{
		return kstream -> kstream.foreach((key,domain) -> 
		{
			System.out.println(String.format("Domain consumed [%s] Status [%s]", domain.getDomain(),domain.isDead()));
		});	
	}
	
	@Bean
	public Consumer<KStream<String, Domain>> domainCountryService()
	{
		return kstream -> kstream.foreach((key,domain) -> {
			
			System.out.println(String.format("Domain Country Consumed [%s] Status [%s]", domain.getDomain(),domain.getCountry()));
			
		});

	}
}
