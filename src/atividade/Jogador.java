package atividade;

/*Classe respons�vel pelas jogadas do jogador usu�rio
 * 
 */
public class Jogador{
	public String nomeJogador;

	public Jogador(String nome){
        this.nomeJogador = nome;
    }
    public String getNome() {
        return nomeJogador;
    }
    public void setNome(String nome) {
        this.nomeJogador = nome;
    }

    void info(){ // Mensagem de boas vindas ao usu�rio
        System.out.printf("Seja bem vindo %s! Vamos jogar!\n\n", this.nomeJogador);
    }

    // M�todo para realizar as jogadas
	public boolean jogada(String matriz[][], String linha, String coluna) {
		try{
            int x = Integer.parseInt(linha);
            int y = Integer.parseInt(coluna);;
            if (matriz[x-1][y-1].equals(" ")){
                matriz[x-1][y-1] = "X";
                return true;
            }else{
                System.out.println("Essa posi��o j� est� ocupada");
                return false;
            }
        }catch(Exception e){
            System.out.println("As coordenadas digitadas s�o inv�lidas");
            return false;
        }
		
	}
	/*public void infoJogador() {
		System.out.printf("%s venceu!", getNome());
	}*/
}