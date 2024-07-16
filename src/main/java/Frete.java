import java.util.ArrayList;
import java.util.List;

public class Frete {
	private String codigoRastreamento;
	private List<String> historicoStatus;

	public Frete() {
		this.historicoStatus = new ArrayList<>();
		this.historicoStatus.add("Pedido recebido no centro de distribuição");
	}

	public String getCodigoRastreamento() {
		return codigoRastreamento;
	}

	public void setCodigoRastreamento(String codigoRastreamento) {
		this.codigoRastreamento = codigoRastreamento;
	}

	public List<String> getHistoricoStatus() {
		return historicoStatus;
	}

	public void adicionarStatus(String novoStatus) {
		this.historicoStatus.add(novoStatus);
	}
}
