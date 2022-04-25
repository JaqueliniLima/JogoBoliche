package boliche;

public class PontuacaoPadrao implements Pontuacao{
	
	private Pista pista;
	
	public PontuacaoPadrao(Pista pista) {
		this.pista = pista;
	}
	
	@Override
	public void apresentarResultado() {
		System.out.println("Pinos derrubados: " + pista.getPinosDerrubados());
		pista.reporPinos();
		System.out.println("Faltam " + pista.getPinosRestantes());	
	}

}
