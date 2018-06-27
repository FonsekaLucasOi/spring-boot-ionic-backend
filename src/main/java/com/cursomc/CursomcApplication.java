package com.cursomc;

import com.cursomc.domain.Categoria;
import com.cursomc.domain.Produto;
import com.cursomc.repositories.CategoriaRepository;
import com.cursomc.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

    @Autowired
	private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria categoriaInformatica = new Categoria(null, "Informática");
		Categoria categoriaEscritorio = new Categoria(null, "Escritório");

		Produto produtoComputador = new Produto(null, "Computador", 2000.00);
		Produto produtoImpressora = new Produto(null, "Impressora", 800.00);
		Produto produtoMouse = new Produto(null, "Mouse", 80.00);

		categoriaInformatica.getProdutos().addAll(Arrays.asList(produtoComputador, produtoImpressora, produtoMouse));
		categoriaEscritorio.getProdutos().addAll(Arrays.asList(produtoMouse));

		produtoComputador.getCategorias().addAll(Arrays.asList(categoriaInformatica));
		produtoImpressora.getCategorias().addAll(Arrays.asList(categoriaInformatica, categoriaEscritorio));
		produtoMouse.getCategorias().addAll(Arrays.asList(categoriaInformatica));

		categoriaRepository.saveAll(Arrays.asList(categoriaInformatica, categoriaEscritorio));
		produtoRepository.saveAll(Arrays.asList(produtoComputador, produtoImpressora, produtoMouse));
	}
}
