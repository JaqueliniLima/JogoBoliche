package boliche;

public class Jogada {
	
	private Jogador jogador;
	private CalculoPontuacao calculoPontuacao;
	
	public Jogada(Jogador jogador, int pontuacaoAtual) {
		this.jogador = jogador;
		this.calculoPontuacao = new CalculoPontuacao(pontuacaoAtual);
		this.jogar();
	}
	
	private void jogar() {
		
		Pista pista = new Pista();
		System.out.println("---------------- Jogador da vez: " + jogador.getNome() + " ----------------");
		
		for (int tentativa = 1; tentativa <= 2; tentativa++) {
			
			System.out.println("\n--> Tentativa " + tentativa);
			pista.arremessarBola();
			calculoPontuacao.calcular(tentativa, pista.getPinosDerrubados());
			
			Pontuacao pontuacao = new PontuacaoFactory().initialize(pista, tentativa);
			pontuacao.apresentarResultado();
			
			this.verificarSeDuplicaProximaPontuacao(pontuacao);
			
		}
	}

	private void verificarSeDuplicaProximaPontuacao(Pontuacao pontuacao) {
		if(pontuacao instanceof PontuacaoStrike) {
			calculoPontuacao.setDuplicaPontuacao(true);				
		}else {
			calculoPontuacao.setDuplicaPontuacao(false);
		}
	}
	
	public int getPontuacaoJogada() {
		return calculoPontuacao.getValor();
	}
}
