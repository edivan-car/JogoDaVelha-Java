package atividade;

import java.util.Random;

/* Classe respons�vel pelas jogasa no n�vel 2
 * As jogadas ser�o feitas em coordenadas aleat�rias
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
