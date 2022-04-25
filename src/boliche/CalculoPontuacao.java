package boliche;

public class CalculoPontuacao {
	private int valor;
	private boolean duplicaPontuacao;
	
	public CalculoPontuacao(int valor) {
		this.valor = valor;
	}
	
	public void calcular(int tentativa, int pontos) {
		if(tentativa == 2 && duplicaPontuacao) {
			valor += pontos * 2;
		} else {
			valor += pontos;
		}
	}

	public int getValor() {
		return valor;
	}

	public boolean isDuplicaPontuacao() {
		return duplicaPontuacao;
	}

	public void setDuplicaPontuacao(boolean duplicaPontuacao) {
		this.duplicaPontuacao = duplicaPontuacao;
	}
	
}
