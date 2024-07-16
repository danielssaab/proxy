import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServicoRastreamentoReal implements ServicoRastreamento {
	private Map<String, Frete> fretes;

	public ServicoRastreamentoReal() {
		this.fretes = new HashMap<>();
	}

	@Override
	public List<String> obterLocalizacaoAtual(String codigoRastreamento) {
		Frete frete = fretes.get(codigoRastreamento);
		if (frete != null) {
			List<String> historico = frete.getHistoricoStatus();
			return historico.subList(historico.size() - 1, historico.size()); // Retorna apenas o último status
		} else {
			throw new IllegalArgumentException("Frete não encontrado");
		}
	}

	@Override
	public List<String> obterHistoricoCompleto(String codigoRastreamento) {
		Frete frete = fretes.get(codigoRastreamento);
		if (frete != null) {
			return frete.getHistoricoStatus();
		} else {
			throw new IllegalArgumentException("Frete não encontrado");
		}
	}

	public void adicionarFrete(Frete frete) {
		String codigoRastreamento = gerarCodigoRastreamento(); // Gerar código de rastreamento dinamicamente
		frete.setCodigoRastreamento(codigoRastreamento);
		fretes.put(codigoRastreamento, frete);
	}

	public void adicionarStatus(String codigoRastreamento, String novoStatus) {
		Frete frete = fretes.get(codigoRastreamento);
		if (frete != null) {
			frete.adicionarStatus(novoStatus);
		} else {
			throw new IllegalArgumentException("Frete não encontrado");
		}
	}

	private String gerarCodigoRastreamento() {
		// Implementação para gerar um código de rastreamento único
		return "FRETE-" + System.currentTimeMillis();
	}
}
