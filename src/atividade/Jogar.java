package atividade;

import java.util.Scanner;

public class Jogar {
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int placarJogador = 0, placarPC = 0;
		
		// Apresenta��o do jogo e solicita o nome do jogador
		System.out.println("=-=-=-=-=- JOGO DA VELHA -=-=-=-=-=");
		System.out.println("=-=-=-=- Informe seu nome! -=-=-=-=");
		String nome = teclado.next();
		Jogador jogador = new Jogador(nome); // Cria o jogador.
		jogador.info();
		
		// Sele��o do n�vel para identificar o advers�rio.
		System.out.println("=-=-= Selecione um dos n�veis =-=-=");
		System.out.println("[1] - F�cil");
		System.out.println("[2] - M�dio");
		System.out.println("[3] - Dif�cl");
		int nivel = Integer.parseInt(teclado.next());
		ComputadorA pc1 = new ComputadorA(nivel); // Cria o computador no n�vel 1.
		ComputadorB pc2 = new ComputadorB(nivel); // Cria o computador no n�vel 2.
		ComputadorC pc3 = new ComputadorC(nivel); // Cria o computador no n�vel 3.
		
		Computador.pcInfo();
		
		// Inicia a partida apresentando os jogadores
		System.out.println();
		System.out.printf("X - %s | O - %s", jogador.getNome(), Computador.getPcNome());
		
		// La�o de in�cio das jogadas
		String confere = "S";
		while(confere.equals("S")) {
			Tabuleiro tab = new Tabuleiro();
			boolean vitoriaJogador;
			
			do {
				if(tab.Jogadas == 9) {
					break;
				}
				
				String x, y;
				x = y = "";
				tab.exibir();
				
				do { // O jogador informa as coordenada para sua jogada
					System.out.println("Informe as coordenadas para o jogo.");
					System.out.print("Linha: "); x = teclado.next();
					System.out.print("Coluna: "); y = teclado.next();
					//jogador.jogada(null, x, y);
				}while(!(jogador.jogada(tab.posicao, x, y)));
				tab.Jogadas++;
				
				/* Verifica se houve vencedor, caso n�o, solicita a jogada do computador
				 * pelo n�vel escolhido.
				 */
				vitoriaJogador = tab.checarVitoria();
				if(!(vitoriaJogador)) {
					switch(nivel) {
					case 1:
						pc1.jogaPC(tab.posicao);
						break;
					case 2:
						pc2.jogaPC(tab.posicao);
						break;
					case 3:
						pc3.jogaPC(tab.posicao);
						break;
					}
					tab.Jogadas++;
				}
			}while(!(tab.checarVitoria()));
			tab.exibir();
			
			// A condi��o mostra a mensagem de quem venceu a primeira rodada.
			if(tab.status().equals("Jogador")) {
				System.out.printf("%s venceu!\n", jogador.getNome());
				placarJogador += 1;
			}
			if(tab.status().equals("Computador")) {
				System.out.printf("%s venceu!\n", Computador.getPcNome());
				placarPC += 1;
			}
			
			System.out.println("Digite [S] para continuar ou [N] para sair.");
			confere = teclado.next().toUpperCase();
			
			// La�o de verifica��o, o jogador decide se vai continuar ou encerrar o jogo
			while(!(confere.equals("S")) && !(confere.equals("N"))){
				System.out.println("Informa��o inv�lida!");
				System.out.println("Digite [S] para continuar ou [N] para sair.");
			}
		}
		
		// Informa��es sobre o vencedor da partida, ser� exibida ao t�rmino do jogo
		String mens = "";
		if(placarJogador <= 1) {mens = "vit�ria";}
		else {mens = "vit�rias";}
		System.out.printf("O jogador %s teve %d %s.", jogador.getNome(), placarJogador, mens);
		
		if(placarPC <= 1) {mens = "vit�ria";}
		else {mens = "vit�rias";}
		System.out.printf("\nO jogador %s teve %d %s.", Computador.getPcNome(), placarPC, mens);
		
		System.out.println();
		
		String vencedor = "";
		if(placarJogador > placarPC) {
			vencedor = jogador.getNome();
			System.out.printf("\nO vencedor da partida foi %s.", vencedor);
		}
		if(placarJogador < placarPC){
			vencedor = Computador.getPcNome();
			System.out.printf("\nO vencedor da partida foi %s.", vencedor);
		}
		if(placarJogador == placarPC) {
			System.out.println("A partida finalizou com um empate!");
		}
		
		teclado.close();
	}
}