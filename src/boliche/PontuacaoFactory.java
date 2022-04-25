package boliche;

public class PontuacaoFactory {
	
	private static final int TOTAL_MAXIMO_PINOS = 10;
	
	public Pontuacao initialize(Pista pista, int tentativa) {
		if(this.isStrike(pista.getTotalPinosDerrubadosJogada(), tentativa)) {
			return new PontuacaoStrike(pista);
			
		} else if(this.isSpare(pista.getTotalPinosDerrubadosJogada(), tentativa)) {
			return new PontuacaoSpare();
		}
		return new PontuacaoPadrao(pista);
	}
	
	private boolean isSpare(int totalPinosDerrubadosJogada, int tentativa) {
		return totalPinosDerrubadosJogada == TOTAL_MAXIMO_PINOS && tentativa == 2;
	}

	private boolean isStrike(int totalPinosDerrubadosJogada, int tentativa) {
		return totalPinosDerrubadosJogada == TOTAL_MAXIMO_PINOS && tentativa == 1;
	}
}
