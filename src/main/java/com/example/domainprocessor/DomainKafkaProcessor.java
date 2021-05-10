package com.example.domainprocessor;



import java.util.function.Function;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.domaincrawler.Domain;

@Configuration
public class DomainKafkaProcessor {
	
	
	@Bean	
	public Function<KStream<String, Domain>, KStream<String, Domain>> domainProcessor()
	{
		return (kstream) -> kstream.filter((key,domain) -> 
		{
			if (domain.isDead())
			{
				System.out.println("Inactive Domain" + domain.getDomain());
			}
			else 
			{
				System.out.println("Active Domain" + domain.getDomain());
			}
			return !domain.isDead(); 
		});
	}
	
	@Bean
	public Function<KStream<String, Domain>, KStream<String, Domain>> domainCountryProcessor()
	{
		return (kstream) -> kstream.filter((key,domain) -> 
		{
			if(domain.getCountry()!= null)
			{
				System.out.println("Not null Countries: " + domain.getDomain()+ " " + domain.getCountry());
			}
			
			return domain.getCountry()!= null;
		});
	}
	
	
}
