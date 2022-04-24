package boliche;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Boliche {
	private Map<Jogador, Integer> placarJogo = new HashMap<>();
	
	public void iniciarJogo() {
		List<Jogador> jogadores = new LinkedList<Jogador>();
		Scanner scanner = new Scanner(System.in);
        System.out.print("Informe a quantidade de jogadores:");
        int quantidadeJogadores = scanner.nextInt();
        String nomeJogador = "";
        Jogador novoJogador = null;
        
        for (int i = 1; i <= quantidadeJogadores; i++) {
        	System.out.print("\nInforme o nome do "+i+"° jogador:");
            nomeJogador = scanner.next();
            novoJogador = new Jogador(i,nomeJogador);
			jogadores.add(novoJogador);
    		placarJogo.put(novoJogador, 0);
		}
        scanner.close();
		
		for (int rodada = 1; rodada <= 10; rodada++) {
			System.out.println("\n>>>>>>>>>>>>>>>>>>> " + rodada + "ª Rodada <<<<<<<<<<<<<<<<<<<<<\n");
			for (Jogador jogador : jogadores) {
				jogar(jogador);
			}
		}
		placarJogo = placarJogo.entrySet().stream()
											.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
							                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
							                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		
		System.out.println("\n>>>>>>>>>>>>>>>>>>> Placar Final <<<<<<<<<<<<<<<<<<<<<\n");
		int colocacao = 1;
		for (Entry<Jogador, Integer> placar : placarJogo.entrySet()) {
			System.out.println(colocacao + "ª colocação: "+ placar.getKey() + " com "+placar.getValue()+ " pontos");
			colocacao++;
		}
	}
	
	private void jogar(Jogador jogador) {
		Random random = new Random();
		int pinosDePe = 10;
		int pinosDerrubados = 0;
		int totalPinosDerrubadosJogada = 0;
		
		int pontuacao = placarJogo.get(jogador);
		boolean isDuplicaPontuacao = false;
		
		System.out.println("---------------- Jogador da vez: " + jogador.getNome() + " ----------------");
		
		for (int tentativa = 1; tentativa <= 2; tentativa++) {
			System.out.println("\n--> Tentativa " + tentativa);
			pinosDerrubados = random.nextInt(pinosDePe+1);
			totalPinosDerrubadosJogada += pinosDerrubados;
			
			if(tentativa == 2 && isDuplicaPontuacao) {
				pontuacao +=  pinosDerrubados * 2;
			} else {
				pontuacao +=  pinosDerrubados;
			}
			
			if(totalPinosDerrubadosJogada == 10 && tentativa == 1) {
				System.out.println("STRIKE!");
				pinosDePe = 10;
				pinosDerrubados = 0;
				isDuplicaPontuacao = true;
				
			} else if(totalPinosDerrubadosJogada == 10 ) {
				System.out.println("SPARE!");
				isDuplicaPontuacao = false;
			} else {
				System.out.println("Pinos derrubados: " + pinosDerrubados);
				pinosDePe = pinosDePe - pinosDerrubados;
				System.out.println("Faltam " + pinosDePe);
				isDuplicaPontuacao = false;
			}
			
			placarJogo.put(jogador, pontuacao);
		}
		System.out.println("\n *Pontuação parcial: " + placarJogo.get(jogador)+ "\n");
		
	}
}
