package boliche;

public class Boliche {
	private static final int TOTAL_JOGADAS = 5;
	private Partida partida = null;
	private Placar placar = null;
	
	public Boliche() {
		this.partida = new Partida();
		this.placar = new Placar(partida.getJogadores());
	}
	
	public void iniciarJogo() {
		this.iniciarRodadas();
		this.placar.imprimirColocacao();
	}

	private void iniciarRodadas() {
		for (int rodada = 1; rodada <= TOTAL_JOGADAS; rodada++) {
			this.imprimirCabecalhoRodada(rodada);
			for (Jogador jogador : partida.getJogadores()) {
				this.iniciarRodadaJogador(jogador);
			}
		}
	}
	
	private void imprimirCabecalhoRodada(int rodada) {
		System.out.println("\n>>>>>>>>>>>>>>>>>>> " + rodada + "ª Rodada <<<<<<<<<<<<<<<<<<<<<\n");
	}

	private void iniciarRodadaJogador(Jogador jogador) {
		int pontuacao = new Jogada(jogador, this.placar.getPlacarJogadoresPartida().get(jogador)).getPontuacaoJogada();
		this.placar.getPlacarJogadoresPartida().put(jogador, pontuacao);
		this.imprimirPontuacaoParcial(jogador);
	}

	private void imprimirPontuacaoParcial(Jogador jogador) {
		System.out.println("\n *Pontuação parcial: " + this.placar.getPlacarJogadoresPartida().get(jogador)+ "\n");
	}
}
