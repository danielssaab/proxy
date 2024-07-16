import java.util.List;

public interface IServicoRastreamento {
	List<String> obterLocalizacaoAtual(String codigoRastreamento);
	List<String> obterHistoricoCompleto(String codigoRastreamento);
}