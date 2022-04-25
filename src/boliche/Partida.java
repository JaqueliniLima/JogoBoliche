package boliche;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Partida {
	
	private List<Jogador> jogadores = new LinkedList<Jogador>();

	public Partida() {
		this.criar();
	}
	
	public void criar() {
		Scanner scanner = new Scanner(System.in);
		
        int quantidadeJogadores = this.solicitarQuantidadeJogadores(scanner);
        String nomeJogador = "";
        Jogador novoJogador = null;
        
        for (int i = 1; i <= quantidadeJogadores; i++) {
        	System.out.print("\nInforme o nome do "+i+"° jogador:");
            nomeJogador = scanner.next();
            novoJogador = new Jogador(i,nomeJogador);
			jogadores.add(novoJogador);
		}
        scanner.close();
	}
	
	private int solicitarQuantidadeJogadores(Scanner scanner) {
		System.out.print("Informe a quantidade de jogadores:");
        int quantidadeJogadores = scanner.nextInt();
		return quantidadeJogadores;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}
	
}
