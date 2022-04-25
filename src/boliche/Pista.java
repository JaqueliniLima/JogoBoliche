package boliche;

import java.util.Random;

public class Pista {
	private Random random = new Random();
	private int pinosRestantes = 10;
	private int pinosDerrubados = 0;
	private int totalPinosDerrubadosJogada = 0;
	
	
	public void arremessarBola() {
		int pinosDerrubados = random.nextInt(pinosRestantes + 1);
		this.pinosDerrubados = pinosDerrubados;
		this.totalPinosDerrubadosJogada += pinosDerrubados;
	}
	
	public int getPinosRestantes() {
		return pinosRestantes;
	}
	public void setPinosRestantes(int pinosRestantes) {
		this.pinosRestantes = pinosRestantes;
	}
	public int getPinosDerrubados() {
		return pinosDerrubados;
	}
	
	public int getTotalPinosDerrubadosJogada() {
		return totalPinosDerrubadosJogada;
	}

	public void reiniciar() {
		pinosRestantes = 10;
		pinosDerrubados = 0;
	}

	public void reporPinos() {
		pinosRestantes = pinosRestantes - pinosDerrubados;
	}
	
}
