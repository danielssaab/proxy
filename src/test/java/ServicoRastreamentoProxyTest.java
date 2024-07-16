import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServicoRastreamentoProxyTest {

	private ServicoRastreamento servicoReal;
	private ServicoRastreamentoProxy servicoProxyAdmin;
	private ServicoRastreamentoProxy servicoProxyCliente;

	@BeforeEach
	void setUp() {
		// Criar uma única instância de ServicoRastreamentoReal
		servicoReal = new ServicoRastreamento();

		// Criar proxies para admin e cliente, passando a mesma instância de ServicoRastreamentoReal
		servicoProxyAdmin = new ServicoRastreamentoProxy(true, servicoReal);
		servicoProxyCliente = new ServicoRastreamentoProxy(false, servicoReal);
	}

	@Test
	void deveRetornarLocalizacaoAtualParaAdmin() {
		Frete frete = new Frete();
		servicoProxyAdmin.adicionarFrete(frete);
		List<String> localizacaoAtual = servicoProxyAdmin.obterLocalizacaoAtual(frete.getCodigoRastreamento());
		assertEquals(Arrays.asList("Pedido recebido no centro de distribuição"), localizacaoAtual);
	}

	@Test
	void deveRetornarLocalizacaoAtualParaCliente() {
		Frete frete = new Frete();
		servicoProxyAdmin.adicionarFrete(frete);
		List<String> localizacaoAtual = servicoProxyCliente.obterLocalizacaoAtual(frete.getCodigoRastreamento());
		assertEquals(Arrays.asList("Pedido recebido no centro de distribuição"), localizacaoAtual);
	}

	@Test
	void deveRetornarExcecaoClienteConsultarHistoricoCompleto() {
		Frete frete = new Frete();
		servicoProxyAdmin.adicionarFrete(frete);
		assertThrows(IllegalArgumentException.class, () -> {
			servicoProxyCliente.obterHistoricoCompleto(frete.getCodigoRastreamento());
		});
	}

	@Test
	void deveRetornarExcecaoClienteAdicionarStatus() {
		Frete frete = new Frete();
		servicoProxyAdmin.adicionarFrete(frete);
		assertThrows(IllegalArgumentException.class, () -> {
			servicoProxyCliente.adicionarStatus(frete.getCodigoRastreamento(), "Em processo de separação");
		});
	}
}
