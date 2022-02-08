package atividade;

import java.util.Random;

/* Classe responsável pelas jogasa no nível 2
 * As jogadas serão feitas em coordenadas aleatórias
 */
public class ComputadorB extends Computador{

	public ComputadorB(int nivel) {
		super(nivel);
		
	}

	Random numeroAleatorio = new Random();

	@Override
	public void jogaPC(String[][] matriz) {
		int x, y;
		while(true) {
			x = numeroAleatorio.nextInt(3);
			y = numeroAleatorio.nextInt(3);
			if(matriz[x][y].equals(" ")) {
				matriz[x][y] = "O";
				return;
			}
		}
	}
}
