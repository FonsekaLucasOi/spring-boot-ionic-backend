package com.cursomc;

import com.cursomc.domain.*;
import com.cursomc.domain.enums.EstadoPagamento;
import com.cursomc.domain.enums.TipoCliente;
import com.cursomc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

    @Autowired
	private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

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


        Estado minasGerais = new Estado(null, "Minas Gerais");
        Estado saoPauloEstado = new Estado(null, "São Paulo");

        Cidade uberlandia = new Cidade(null, "Uberlândia", minasGerais);
        Cidade saoPauloCidade = new Cidade(null, "São Paulo", saoPauloEstado);
        Cidade campinas = new Cidade(null, "Campinas", saoPauloEstado);

        minasGerais.getCidades().addAll(Arrays.asList(uberlandia));
        saoPauloEstado.getCidades().addAll(Arrays.asList(saoPauloCidade, campinas));

        estadoRepository.saveAll(Arrays.asList(minasGerais, saoPauloEstado));
        cidadeRepository.saveAll(Arrays.asList(uberlandia, saoPauloCidade, campinas));

        Cliente maria = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOA_FISICA);
        maria.getTelefones().addAll(Arrays.asList("27363323", "93838393"));

        Endereco primeiroEndereco = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", maria, uberlandia);
        Endereco segundoEndereco = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", maria, saoPauloCidade);

        maria.getEnderecos().addAll(Arrays.asList(primeiroEndereco, segundoEndereco));

        clienteRepository.saveAll(Arrays.asList(maria));
        enderecoRepository.saveAll(Arrays.asList(primeiroEndereco, segundoEndereco));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        Pedido primeiroPedido = new Pedido(null, simpleDateFormat.parse("30/09/2017 10:32"), maria, primeiroEndereco);
        Pedido segundoPedido = new Pedido(null, simpleDateFormat.parse("10/10/2017 19:35"), maria, segundoEndereco);

        Pagamento primeiroPagamento = new PagamentoComCartao(null, EstadoPagamento.QUITADO, primeiroPedido, 6);
        primeiroPedido.setPagamento(primeiroPagamento);

        Pagamento segundoPagamento = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, segundoPedido, simpleDateFormat.parse("20/10/2017 00:00"), null);
        segundoPedido.setPagamento(segundoPagamento);

        maria.getPedidos().addAll(Arrays.asList(primeiroPedido, segundoPedido));

        pedidoRepository.saveAll(Arrays.asList(primeiroPedido, segundoPedido));
        pagamentoRepository.saveAll(Arrays.asList(primeiroPagamento, segundoPagamento));

        ItemPedido primeiroItemPedido = new ItemPedido(primeiroPedido, produtoComputador, 0.00, 1, 2000.00);
        ItemPedido segundoItemPedido = new ItemPedido(primeiroPedido, produtoMouse, 0.00, 2, 80.00);
        ItemPedido terceiroItemPedido = new ItemPedido(segundoPedido, produtoImpressora, 100.00, 1, 800.00);

        primeiroPedido.getItemPedidos().addAll(Arrays.asList(primeiroItemPedido, segundoItemPedido));
        segundoPedido.getItemPedidos().addAll(Arrays.asList(terceiroItemPedido));

        produtoComputador.getItens().addAll(Arrays.asList(primeiroItemPedido));
        produtoImpressora.getItens().addAll(Arrays.asList(terceiroItemPedido));
        produtoMouse.getItens().addAll(Arrays.asList(segundoItemPedido));

        itemPedidoRepository.saveAll(Arrays.asList(primeiroItemPedido, segundoItemPedido, terceiroItemPedido));

	}
}
