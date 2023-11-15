package com.FGRW.tfpi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.FGRW.tfpi.services.EstadosServices;


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	@Autowired
	EstadosServices estado;
	@Override
	public void run(String... args) throws Exception {
		estado.consumirAPIEArmazenarNoBanco();
		
	}

}