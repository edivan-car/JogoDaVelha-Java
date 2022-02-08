package atividade;

/* Classe responsável pelas informações no tabuleiro */
public class Tabuleiro{
	public String posicao[][] = new String [3][3];
    public int Jogadas;
    private String marcaDoVencedor;
    public String jogadorNome;
    public String pcNome;

    public Tabuleiro() {
        super();
        this.Jogadas = 0;
        posicaoInicial();
        this.marcaDoVencedor ="";
    }

	private void posicaoInicial() { // Inicia o posicionamento das jogadas, posição inicial
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                this.posicao[i][j] = " ";
            }
        }
    }

    public void reiniciar(){ // reinicia o tabuleiro a posição inicial
    	posicaoInicial();
    }

    public void exibir(){ //Exibe a situação do tabuleiro mostrando as posições ocupadas
    	System.out.println();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(this.posicao[i][j]);
                if(j<2) {
                    System.out.print("|");
                }
            }System.out.println();
        } System.out.println();
    }
    
    public boolean checarVitoria(){ // Verifica a situação das jogadas se há um vencedor.

        if(Jogadas < 5){
            return false;
        }
        if(posicao[0][0].equals(posicao[1][1])&& posicao[1][1].equals(posicao[2][2]) && !(posicao[1][1].equals(" "))){
            this.marcaDoVencedor = posicao[0][0];
            return true;
        }
        if(posicao[2][0].equals(posicao[1][1]) && posicao[1][1].equals(posicao[0][2]) && !(posicao[1][1].equals(" "))){
            this.marcaDoVencedor = posicao[2][0];
            return true;
        }

        for(int i = 0; i < 3; i++){
            if(posicao[i][0].equals(posicao[i][1]) && posicao[i][1].equals(posicao[i][2]) && !(posicao[i][1].equals(" "))){
                this.marcaDoVencedor = posicao[i][0];
                return true;
            }
            if(posicao[0][i].equals(posicao[1][i]) && posicao[1][i].equals(posicao[2][i]) && !(posicao[1][i].equals(" "))){
                this.marcaDoVencedor = posicao[0][i];
                return true;
            }
        }
        return false;
    }

    public String status(){ // Exibe o status da partida informando se há um vencedor

        boolean Vitoria = checarVitoria();
        if(Vitoria == false && Jogadas == 9){
            return "EMPATE";
        }else if(Vitoria == false){
            return "INCOMPLETO";
        }else{
            if(this.marcaDoVencedor == "X"){
                return "Jogador";
            }else{
                return "Computador";
            }
        }
    }
    
}

