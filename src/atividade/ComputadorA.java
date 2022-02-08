package atividade;

/* Classe responsável pelas jogadas no nível 1*/

public class ComputadorA extends Computador{
		
	public ComputadorA(int nivel) {
		super(nivel);
		
	}

	@Override
	public void jogaPC(String[][] matriz) {
		for(int i=0; i<matriz.length; i++) {
			for(int j=0; j<matriz.length; j++){
				if(matriz[i][j].equals(" ")) {
					matriz[i][j] = "O";
					return;
				}
			}
		}
	}
}
