package atividade;

import java.util.Random;

/* Classe responsável pelas jogadas no nível 3
 * As jogadas são baseadas nas jogadas do jogador, tentando bloquear
 */
public class ComputadorC extends Computador{
	
	public ComputadorC(int nivel) {
		super(nivel);
	}
	
	Random numeroAleatorio = new Random();

    @Override
    public void jogaPC(String[][] matriz) {
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(matriz[i][j].equals("X")){
                    //verifica as horizontais
                    try{
                        if(matriz[i+1][j].equals(" ")){
                            matriz[i+1][j] = "O";
                            return;
                        }
                    }catch(Exception e){

                    }
                    try{
                        if(matriz[i-1][j].equals(" ")){
                            matriz[i-1][j] = "O";
                            return;
                        }
                    }catch(Exception e){

                    }

                    try{
                        if(matriz[i][j+1].equals(" ")){
                            matriz[i][j+1] = "O";
                            return;
                        }
                    }catch(Exception e){

                    }
                    //verifica as verticais
                    try{
                        if(matriz[i][j-1].equals(" ")){
                            matriz[i][j-1] = "O";
                            return;
                        }
                    }catch(Exception e){

                    }
                }
            }
        }
        
        int x;
        while(true){
            x = numeroAleatorio.nextInt(3);
            for(int j = 0; j < 3; j++){
                if(matriz[x][j].equals(" ")){
                    matriz[x][j] = "O";
                    return;
                }
            }
        }
    }
}
