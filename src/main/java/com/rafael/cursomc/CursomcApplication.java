package com.rafael.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rafael.cursomc.domain.Categoria;
import com.rafael.cursomc.domain.Produto;
import com.rafael.cursomc.repositores.CategoriaRepository;
import com.rafael.cursomc.repositores.CidadeRepository;
import com.rafael.cursomc.repositores.EstadoRepository;
import com.rafael.cursomc.repositores.ProdutoRepository;
import com.rafael.cursomc.domain.Cidade;
import com.rafael.cursomc.domain.Estado;

@SpringBootApplication
public class CursomcApplication  implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository; 
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));		
		
		categoriaRepository.save(Arrays.asList(cat1, cat2));
		produtoRepository.save(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Minas Gerasis");
		Estado est2 = new Estado(null, "São Paulo");
		Estado est3 = new Estado(null, "Ceará");
		
		Cidade c1 = new Cidade(null, "Underlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		Cidade c4 = new Cidade(null, "Fortaleza", est3);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		est3.getCidades().addAll(Arrays.asList(c4));
		
		estadoRepository.save(Arrays.asList(est1, est2, est3));
		cidadeRepository.save(Arrays.asList(c1, c2, c3, c4));
		
	}
	

}
