package boliche;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Placar {
	private Map<Jogador, Integer> placarJogadoresPartida = new HashMap<>();

	public Placar(List<Jogador> jogadoresPartida) {
		this.inicializarPlacar(jogadoresPartida);
	}
	
	private void inicializarPlacar(List<Jogador> jogadoresPartida) {
		for (Jogador jogador : jogadoresPartida) {
			placarJogadoresPartida.put(jogador, 0);
		}
	}
	
	public void imprimirColocacao() {
		this.ordenarColocacaoJogadores();
		this.imprimirColocacaoFinal();
	}
	
	private void ordenarColocacaoJogadores() {
		placarJogadoresPartida = placarJogadoresPartida.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(oldValue, newValue) -> oldValue, LinkedHashMap::new));
	}
	
	private void imprimirColocacaoFinal() {
		this.imprimirCabecalhoPlacarFinal();
		int colocacao = 1;
		for (Entry<Jogador, Integer> placar : placarJogadoresPartida.entrySet()) {
			System.out.println(colocacao + "ª colocação: "+ placar.getKey() + " com "+placar.getValue()+ " pontos");
			colocacao++;
		}
	}

	private void imprimirCabecalhoPlacarFinal() {
		System.out.println("\n>>>>>>>>>>>>>>>>>>> Placar Final <<<<<<<<<<<<<<<<<<<<<\n");
	}

	public Map<Jogador, Integer> getPlacarJogadoresPartida() {
		return placarJogadoresPartida;
	}
	
}
