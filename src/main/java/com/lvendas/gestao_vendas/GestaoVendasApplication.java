package com.lvendas.gestao_vendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.lvendas.gestao_vendas.entidade"})  //fala onde está as entidades
@EnableJpaRepositories(basePackages = {"com.lvendas.gestao_vendas.repositorio"})
@ComponentScan(basePackages = {"com.lvendas.gestao_vendas.servico","com.lvendas.gestao_vendas.controlador"})
@SpringBootApplication
public class GestaoVendasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoVendasApplication.class, args);
	}

}
