package com.testes;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.testes.domain.Categoria;
import com.testes.domain.Conta;
import com.testes.repositories.CategoriaRepository;
import com.testes.repositories.ContaRepository;

@SpringBootApplication
public class TestecursoApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ContaRepository contaRepository;

	public static void main(String[] args) {
		SpringApplication.run(TestecursoApplication.class, args);
	}

	public void run(String... args) throws Exception {

		Categoria moradia = new Categoria(null, "Moradia");
		Categoria carroManutencao = new Categoria(null, "Manutenção do Carro");
		Categoria mercado = new Categoria(null, "Mercardo");

		Conta aluguel = new Conta(null, "Aluguel", 2200.00);
		Conta funileiro = new Conta(null, "Funileiro", 1100.00);
		Conta borracha = new Conta(null, "Borracha da Porta", 39.00);
		Conta walmart = new Conta(null, "Walmart", 240.00);

		moradia.getContas().addAll(Arrays.asList(aluguel));
		carroManutencao.getContas().addAll(Arrays.asList(funileiro, borracha));
		mercado.getContas().addAll(Arrays.asList(walmart));

		aluguel.getCategorias().addAll(Arrays.asList(moradia));
		funileiro.getCategorias().addAll(Arrays.asList(carroManutencao));
		borracha.getCategorias().addAll(Arrays.asList(carroManutencao));
		walmart.getCategorias().addAll(Arrays.asList(mercado));

		categoriaRepository.saveAll(Arrays.asList(moradia, carroManutencao, mercado));
		contaRepository.saveAll(Arrays.asList(aluguel, funileiro, borracha, walmart));
	}
}
