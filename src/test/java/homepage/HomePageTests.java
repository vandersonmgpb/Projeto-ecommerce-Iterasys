package homepage;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import base.BaseTests;
import pages.CarrinhoPage;
import pages.LoginPage;
import pages.ModalProdutoPage;
import pages.ProdutoPage;

public class HomePageTests extends BaseTests {
	
	@Test
	public void testContarProdutos_oitoProdutosDiferentes() {
		carregarPaginaInicial();
		assertThat(homePage.contarProdutos(), is(8));
	}
	
	@Test
	public void testValidarCarinhoZerado_ZeroItensNoCarrinho() {
		int produtosNoCarrinho = homePage.obterQuantidadeProdutosNoCarrinho();
//		System.out.println(produtosNoCarrinho);
		assertThat(produtosNoCarrinho, is(0));
		
	}
	
	ProdutoPage produtoPage;
	String nomeProduto_ProdutoPage;
	@Test
	public void testValidarDetalhesDoProduto_DescricaoEValorIguais() {
		int indice = 0;
		String nomeProduto_HomePage = homePage.obterNomeProduto(indice);
		String precoProduto_HomePage = homePage.obterPrecoProduto(indice);
		
		System.out.println(nomeProduto_HomePage);
		System.out.println(precoProduto_HomePage);
		
		produtoPage = homePage.clicarProduto(indice);
		
		nomeProduto_ProdutoPage = produtoPage.obterNomeProduto();
		String precoProduto_ProdutoPage = produtoPage.obterPrecoProduto();
		
		System.out.println(nomeProduto_ProdutoPage);
		System.out.println(precoProduto_ProdutoPage);
		
		assertThat(nomeProduto_HomePage.toUpperCase(), is(nomeProduto_ProdutoPage.toUpperCase()));
		assertThat(precoProduto_HomePage, is(precoProduto_ProdutoPage));
	}
	
	LoginPage loginPage;
	@Test
	public void testLoginComsucesso_UsuarioLogado() {
//		Clicar no bot�o de Sign In na home page
		loginPage = homePage.clicarBotaoSignIn();
		
//		Preencher usuario e senha
		loginPage.preencherEmail("contachaves@test.com");
		loginPage.preencherPassword("01234");
		
//		Clicar no bot�o Sign In para logar
		loginPage.clicarBotaoSignIn();
		
//		Validar se o usuario est� logado de fato
		assertThat(homePage.estaLogado("Vanderson Oliveira"), is(true));
		
		carregarPaginaInicial();
	}
	
	ModalProdutoPage modalProdutoPage;
	@Test
	public void incluirProdutoNoCarrinho_ProdutoIncluidoComsucesso() {
		
		String tamanhoProduto = "M";
		String corProduto = "Black";
		int quantidadeProduto = 2;
		
//		--Pr�-condi��o
//		--usu�rio logado
		if(!homePage.estaLogado("Vanderson Oliveira")) {
			testLoginComsucesso_UsuarioLogado();
		}
	
//		--Teste	
//		Selecionando produto
		testValidarDetalhesDoProduto_DescricaoEValorIguais();

//		Selecionar tamanho
		List<String> listaOpcoes = produtoPage.obterOpcoesSeleconadas();
		
		System.out.println(listaOpcoes.get(0));
		System.out.println("Tamanho da lista: " + listaOpcoes.size());
		
		produtoPage.selecionarOpcaoDropdown("M");
		
		listaOpcoes = produtoPage.obterOpcoesSeleconadas();
		
		System.out.println(listaOpcoes.get(0));
		System.out.println("Tamanho da lista: " + listaOpcoes.size());
		
//		Selecionar cor
		produtoPage.selecionarCorPreta();
		
//		Selecionar quantidade
		produtoPage.alterarQuantidade(quantidadeProduto);
		
//		Adicionar no carrinho
		modalProdutoPage = produtoPage.clicarBotaoaddCart();
		
//		Valida��es
		
//		assertThat(modalProdutoPage.obterMensagemProdutoAdicionado(), is("Product successfully added to your shopping cart"));
		assertTrue(modalProdutoPage.obterMensagemProdutoAdicionado().endsWith("Product successfully added to your shopping cart"));
		
		System.out.println();
		
		assertThat(modalProdutoPage.obterDescricaoProduto().toUpperCase(), is(nomeProduto_ProdutoPage.toUpperCase()));
		
		String precoProdutoString = modalProdutoPage.obterPrecoProduto();
		precoProdutoString = precoProdutoString.replace("$", "");
		Double precoProduto = Double.parseDouble(precoProdutoString);
		
		assertThat(modalProdutoPage.obterTamanhoProduto(), is(tamanhoProduto));
		assertThat(modalProdutoPage.obterCorProduto(), is(corProduto));
		assertThat(modalProdutoPage.obterQuantidadeProduto(), is(Integer.toString(quantidadeProduto)));
		
		String subtotalString = modalProdutoPage.obterSubtotal();
		subtotalString = subtotalString.replace("$", "");
		Double subtotal = Double.parseDouble(subtotalString);
		
		Double subtotalCalculado = quantidadeProduto * precoProduto;
		
		assertThat(subtotal, is(subtotalCalculado));
		
//		System.out.println(modalProdutoPage.obterTamanhoProduto());
//		System.out.println(modalProdutoPage.obterCorProduto());
//		System.out.println(modalProdutoPage.obterQuantidadeProduto());
	}
	
	@Test
	public void IrParaCarrinho_InformacoesPersistidas() {
		//--Pr�-condi��es
//		Produto inclu�do na tela ModalProdutoPage
		incluirProdutoNoCarrinho_ProdutoIncluidoComsucesso();
		
		CarrinhoPage carrinhoPage = modalProdutoPage.clicarBotaoProceedToCheckout();
	}
}