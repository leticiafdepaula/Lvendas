package com.lvendas.gestao_vendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;


//@EntityScan(basePackages = {"com.lvendas.gestao_vendas.entidade"})  //fala onde está as entidades
//@EnableJpaRepositories(basePackages = {"com.lvendas.gestao_vendas.repositorio"})
//@ComponentScan(basePackages = {"com.lvendas.gestao_vendas.servico","com.lvendas.gestao_vendas.controlador", "com.lvendas.gestao_vendas.excecao"})

@SpringBootApplication
@Configuration
public class GestaoVendasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoVendasApplication.class, args);
	}

}
