package homepage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import base.BaseTests;
import pages.CarrinhoPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ModalProdutoPage;
import pages.ProdutoPage;
import util.Funcoes;

public class HomePageTests extends BaseTests {

	@Test
	public void testContarProdutos_oitoProdutosDiferentes() {
		carregarPaginaInicial();
		assertThat(homePage.contarProdutos(), is(8));
	}

	@Test
	public void testValidarCarrinhoZerado_ZeroItensNoCarrinho() {
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
	public void testLoginComSucesso_UsuarioLogado() {
//		Clicar no botão de Sign In na home page
		loginPage = homePage.clicarBotaoSignIn();

<<<<<<< HEAD
//		Preencher usuario e senha
=======
//		Preencher usuário e senha
>>>>>>> de43395c741d7848a1fdedba116b8bd03f324bf6
		loginPage.preencherEmail("contachaves@test.com");
		loginPage.preencherPassword("01234");

//		Clicar no botão Sign In para logar
		loginPage.clicarBotaoSignIn();

//		Validar se o usuario está logado de fato
		assertThat(homePage.estaLogado("Vanderson Oliveira"), is(true));

		carregarPaginaInicial();
	}

	ModalProdutoPage modalProdutoPage;

	@Test
	public void incluirProdutoNoCarrinho_ProdutoIncluidoComSucesso() {

		String tamanhoProduto = "M";
		String corProduto = "Black";
		int quantidadeProduto = 2;

//		--Pré-condição
//		--usuário logado
		if (!homePage.estaLogado("Vanderson Oliveira")) {
			testLoginComSucesso_UsuarioLogado();
		}

//		--Teste	
//		Selecionando produto
		testValidarDetalhesDoProduto_DescricaoEValorIguais();

//		Selecionar tamanho
<<<<<<< HEAD
		List<String> listaOpcoes = produtoPage.obterOpcoesSelecionadas();
=======
		List<String> listaOpcoes = produtoPage.obterOpcoesSeleconadas();

>>>>>>> de43395c741d7848a1fdedba116b8bd03f324bf6
		System.out.println(listaOpcoes.get(0));
		System.out.println("Tamanho da lista: " + listaOpcoes.size());

		produtoPage.selecionarOpcaoDropdown("M");

<<<<<<< HEAD
		listaOpcoes = produtoPage.obterOpcoesSelecionadas();
=======
		listaOpcoes = produtoPage.obterOpcoesSeleconadas();

>>>>>>> de43395c741d7848a1fdedba116b8bd03f324bf6
		System.out.println(listaOpcoes.get(0));
		System.out.println("Tamanho da lista: " + listaOpcoes.size());

//		Selecionar cor
		produtoPage.selecionarCorPreta();

//		Selecionar quantidade
		produtoPage.alterarQuantidade(quantidadeProduto);

//		Adicionar no carrinho
<<<<<<< HEAD
		modalProdutoPage = produtoPage.clicarBotaoAddToCart();
=======
		modalProdutoPage = produtoPage.clicarBotaoaddToCart();
>>>>>>> de43395c741d7848a1fdedba116b8bd03f324bf6

//		Validações

//		assertThat(modalProdutoPage.obterMensagemProdutoAdicionado(), is("Product successfully added to your shopping cart"));
		assertTrue(modalProdutoPage.obterMensagemProdutoAdicionado()
				.endsWith("Product successfully added to your shopping cart"));

<<<<<<< HEAD
		System.out.println(modalProdutoPage.obterDescricaoProduto());
=======
		System.out.println();
>>>>>>> de43395c741d7848a1fdedba116b8bd03f324bf6

		assertThat(modalProdutoPage.obterDescricaoProduto().toUpperCase(), is(nomeProduto_ProdutoPage.toUpperCase()));

		String precoProdutoString = modalProdutoPage.obterPrecoProduto();
		precoProdutoString = precoProdutoString.replace("$", "");
		Double precoProduto = Double.parseDouble(precoProdutoString);

		assertThat(modalProdutoPage.obterTamanhoProduto(), is(tamanhoProduto));
		assertThat(modalProdutoPage.obterCorProduto(), is(corProduto));
		assertThat(modalProdutoPage.obterQuantidadeProduto(), is(Integer.toString(quantidadeProduto)));

<<<<<<< HEAD
		String subtotalString = (modalProdutoPage.obterSubtotal());
=======
		String subtotalString = modalProdutoPage.obterSubtotal();
>>>>>>> de43395c741d7848a1fdedba116b8bd03f324bf6
		subtotalString = subtotalString.replace("$", "");
		Double subtotal = Double.parseDouble(subtotalString);

		Double subtotalCalculado = quantidadeProduto * precoProduto;

		assertThat(subtotal, is(subtotalCalculado));
<<<<<<< HEAD
	}
=======
>>>>>>> de43395c741d7848a1fdedba116b8bd03f324bf6

//		System.out.println(modalProdutoPage.obterTamanhoProduto());
//		System.out.println(modalProdutoPage.obterCorProduto());
//		System.out.println(modalProdutoPage.obterQuantidadeProduto());
<<<<<<< HEAD
=======
	}
>>>>>>> de43395c741d7848a1fdedba116b8bd03f324bf6

//	Valores esperados

	String esperado_nomeProduto = "Hummingbird printed t-shirt";
	Double esperado_precoProduto = 19.12;
	String esperado_tamanhoProduto = "M";
	String esperado_corProduto = "Black";
	int esperado_input_quantidadeProduto = 2;
	Double esperado_subtotalProduto = esperado_precoProduto * esperado_input_quantidadeProduto;

	int esperado_numeroItensTotal = esperado_input_quantidadeProduto;
	Double esperado_subtotalTotal = esperado_subtotalProduto;
	Double esperado_shippingTotal = 7.00;
	Double esperado_totalTaxExclTotal = esperado_subtotalTotal + esperado_shippingTotal;
	Double esperado_totalTaxInclTotal = esperado_totalTaxExclTotal;
	Double esperado_taxesTotal = 0.00;
<<<<<<< HEAD
	
	CarrinhoPage carrinhoPage;
=======

	CarrinhoPage carrinhoPage;

>>>>>>> de43395c741d7848a1fdedba116b8bd03f324bf6
	@Test
	public void IrParaCarrinho_InformacoesPersistidas() {
		// --Pré-condições
//		Produto incluído na tela ModalProdutoPage
		incluirProdutoNoCarrinho_ProdutoIncluidoComSucesso();

		carrinhoPage = modalProdutoPage.clicarBotaoProceedToCheckout();

<<<<<<< HEAD
//	Teste

//	Validar todos elementos da Tela
=======
		// Test

		// Validar todos elementos da Tela
>>>>>>> de43395c741d7848a1fdedba116b8bd03f324bf6
		System.out.println("*** TELA DO CARRINHO ***");

		System.out.println(carrinhoPage.obter_nomeProduto());
		System.out.println(Funcoes.removeCifraoDevolveDouble(carrinhoPage.obter_precoProduto()));
		System.out.println(carrinhoPage.obter_tamanhoProduto());
		System.out.println(carrinhoPage.obter_corProduto());
		System.out.println(carrinhoPage.obter_input_quantidadeProduto());
		System.out.println(Funcoes.removeCifraoDevolveDouble(carrinhoPage.obter_subtotalProduto()));

		System.out.println("** ITENS DE TOTAIS **");

		System.out.println(Funcoes.removeTextoItemsDevolveInt(carrinhoPage.obter_numeroItensTotal()));
		System.out.println(Funcoes.removeCifraoDevolveDouble(carrinhoPage.obter_subtotalTotal()));
		System.out.println(Funcoes.removeCifraoDevolveDouble(carrinhoPage.obter_shippingTotal()));
		System.out.println(Funcoes.removeCifraoDevolveDouble(carrinhoPage.obter_totalTaxExclTotal()));
<<<<<<< HEAD
		System.out.println(Funcoes.removeCifraoDevolveDouble(carrinhoPage.obter_totalTaxInclTotal()));
=======
		System.out.println(Funcoes.removeCifraoDevolveDouble(carrinhoPage.obter_totalTaxIncTotal()));
>>>>>>> de43395c741d7848a1fdedba116b8bd03f324bf6
		System.out.println(Funcoes.removeCifraoDevolveDouble(carrinhoPage.obter_taxesTotal()));

//	Asserções hamcrest
		assertThat(carrinhoPage.obter_nomeProduto(), is(esperado_nomeProduto));
		assertThat(Funcoes.removeCifraoDevolveDouble(carrinhoPage.obter_precoProduto()), is(esperado_precoProduto));
		assertThat(carrinhoPage.obter_tamanhoProduto(), is(esperado_tamanhoProduto));
		assertThat(carrinhoPage.obter_corProduto(), is(esperado_corProduto));
		assertThat(Integer.parseInt(carrinhoPage.obter_input_quantidadeProduto()),
				is(esperado_input_quantidadeProduto));
		assertThat(Funcoes.removeCifraoDevolveDouble(carrinhoPage.obter_subtotalProduto()),
				is(esperado_subtotalProduto));

		assertThat(Funcoes.removeTextoItemsDevolveInt(carrinhoPage.obter_numeroItensTotal()),
				is(esperado_numeroItensTotal));
		assertThat(Funcoes.removeCifraoDevolveDouble(carrinhoPage.obter_subtotalTotal()), is(esperado_subtotalTotal));
		assertThat(Funcoes.removeCifraoDevolveDouble(carrinhoPage.obter_shippingTotal()), is(esperado_shippingTotal));
		assertThat(Funcoes.removeCifraoDevolveDouble(carrinhoPage.obter_totalTaxExclTotal()),
				is(esperado_totalTaxExclTotal));
<<<<<<< HEAD
		assertThat(Funcoes.removeCifraoDevolveDouble(carrinhoPage.obter_totalTaxInclTotal()),
				is(esperado_totalTaxInclTotal));
		assertThat(Funcoes.removeCifraoDevolveDouble(carrinhoPage.obter_taxesTotal()), is(esperado_taxesTotal));

//	AsserçõesJUnit
/*		
=======
		assertThat(Funcoes.removeCifraoDevolveDouble(carrinhoPage.obter_totalTaxIncTotal()),
				is(esperado_totalTaxIncTotal));
		assertThat(Funcoes.removeCifraoDevolveDouble(carrinhoPage.obter_taxesTotal()), is(esperado_taxesTotal));

//	AsserçõesJUnit
>>>>>>> de43395c741d7848a1fdedba116b8bd03f324bf6
		assertEquals(esperado_nomeProduto, carrinhoPage.obter_nomeProduto());
		assertEquals(esperado_precoProduto, Funcoes.removeCifraoDevolveDouble(carrinhoPage.obter_precoProduto()));
		assertEquals(esperado_tamanhoProduto, carrinhoPage.obter_tamanhoProduto());
		assertEquals(esperado_corProduto, carrinhoPage.obter_corProduto());
		assertEquals(esperado_input_quantidadeProduto, Integer.parseInt(carrinhoPage.obter_input_quantidadeProduto()));
		assertEquals(esperado_subtotalProduto, Funcoes.removeCifraoDevolveDouble(carrinhoPage.obter_subtotalProduto()));

		assertEquals(esperado_numeroItensTotal,
				Funcoes.removeTextoItemsDevolveInt(carrinhoPage.obter_numeroItensTotal()));
		assertEquals(esperado_subtotalTotal, Funcoes.removeCifraoDevolveDouble(carrinhoPage.obter_subtotalTotal()));
		assertEquals(esperado_shippingTotal, Funcoes.removeCifraoDevolveDouble(carrinhoPage.obter_shippingTotal()));
		assertEquals(esperado_totalTaxExclTotal,
				Funcoes.removeCifraoDevolveDouble(carrinhoPage.obter_totalTaxExclTotal()));
<<<<<<< HEAD
		assertEquals(esperado_totalTaxInclTotal,
				Funcoes.removeCifraoDevolveDouble(carrinhoPage.obter_totalTaxInclTotal()));
		assertEquals(esperado_taxesTotal, Funcoes.removeCifraoDevolveDouble(carrinhoPage.obter_taxesTotal()));
*/
=======
		assertEquals(esperado_totalTaxIncTotal,
				Funcoes.removeCifraoDevolveDouble(carrinhoPage.obter_totalTaxIncTotal()));
		assertEquals(esperado_taxesTotal, Funcoes.removeCifraoDevolveDouble(carrinhoPage.obter_taxesTotal()));

	}

	CheckoutPage checkoutPage;

	@Test
	public void IrParaCheckout_FreteMeioPagamentoEntregaListadosOk() {
		// --Pré-condições
//			Produto disponível na tela ModalProdutoPage
		IrParaCarrinho_InformacoesPersistidas();
//			Teste

//			Clicar no botão
		checkoutPage = carrinhoPage.clicarBotaoProceedToCheckout();

//			Preencher informações

//			Validar Informações na tela
		assertThat(Funcoes.removeCifraoDevolveDouble(checkoutPage.obter_totalTaxIncTotal()), is(esperado_totalTaxIncTotal));

//			

>>>>>>> de43395c741d7848a1fdedba116b8bd03f324bf6
	}
	
	CheckoutPage checkoutPage;
	
	@Test
	public void irParaCheckout_FreteMeioPagamentoEnderecoListadosOk() {
//		Pré-condições
		
//		Produto disponível no carrinho de compras
		IrParaCarrinho_InformacoesPersistidas();
		
//		Teste
		
//		Clicar no botão
		checkoutPage = carrinhoPage.clicarBotaoProceedToCheckout();
		
//		Preencher informacoes
		
//		Validar Informações na tela
		assertThat(Funcoes.removeCifraoDevolveDouble(checkoutPage.obter_totalTaxInclTotal()), is(esperado_totalTaxInclTotal));
	}
}
