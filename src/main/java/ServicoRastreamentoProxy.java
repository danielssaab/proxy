import java.util.List;

public class ServicoRastreamentoProxy implements IServicoRastreamento {
	private boolean isAdmin;
	private ServicoRastreamento servicoReal;

	public ServicoRastreamentoProxy(boolean isAdmin, ServicoRastreamento servicoReal) {
		this.isAdmin = isAdmin;
		this.servicoReal = servicoReal;
	}

	@Override
	public List<String> obterLocalizacaoAtual(String codigoRastreamento) {
			return servicoReal.obterLocalizacaoAtual(codigoRastreamento);
	}

	@Override
	public List<String> obterHistoricoCompleto(String codigoRastreamento) {
		if (isAdmin) {
			return servicoReal.obterHistoricoCompleto(codigoRastreamento);
		} else {
			throw new IllegalArgumentException("Usuário não autorizado a consultar histórico completo");
		}
	}

	public void adicionarFrete(Frete frete) {
		if (isAdmin) {
			servicoReal.adicionarFrete(frete);
		} else {
			throw new IllegalArgumentException("Usuário não autorizado a adicionar frete");
		}
	}

	public void adicionarStatus(String codigoRastreamento, String novoStatus) {
		if (isAdmin) {
			servicoReal.adicionarStatus(codigoRastreamento, novoStatus);
		} else {
			throw new IllegalArgumentException("Usuário não autorizado a adicionar status");
		}
	}
}
