import java.util.List;

public interface ServicoRastreamento {
	List<String> obterLocalizacaoAtual(String codigoRastreamento);
	List<String> obterHistoricoCompleto(String codigoRastreamento);
}