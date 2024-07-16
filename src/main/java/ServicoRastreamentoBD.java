import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServicoRastreamentoBD {
	private static Map<String, Frete> fretes = new HashMap<>();

	public static Frete getFrete(String codigoRastreamento) {
		return fretes.get(codigoRastreamento);
	}

	public static void addFrete(Frete frete) {
		fretes.put(frete.getCodigoRastreamento(), frete);
	}

	public static void clearFretes() {
		fretes.clear();
	}
}
