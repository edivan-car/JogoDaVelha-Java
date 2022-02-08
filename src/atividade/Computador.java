package atividade;

/* Essa classe recebe a informa��o do n�vel selecionado e fornece o m�todo para as classes
 * com os n�vel de dificuldade das jogadas. 
 */
public abstract class Computador{
	public abstract void jogaPC(String matriz [][]);
	
	// Atributos
	public static String pcNome;
	public static int nivel;
	public static int select;	
	
	// Construtor
	public Computador(int nivel) {
		super();
		this.setNivel(nivel);
		this.setPcNome(pcNome);
	}
	
	public static int getNivel() {
		return select;
	}
	
	// Verifica o n�vel selecionado pelo jogador e retorna um nome para o Computador.
	public void setNivel(int select) {
		if(Computador.nivel == 1) {
			select = 1;
		}
		if(Computador.nivel == 2) {
			select = 2;
		}
		if(Computador.nivel == 3) {
			select = 3;
		}
		Computador.select = select;
	}
	
	public static String getPcNome() {
		return pcNome;
	}
	public void setPcNome(String nome) {
		if(Computador.select == 1) {
			nome = "Wall-E";
		}
		if(Computador.select == 2) {
			nome = "R2-D2";
		}
		if(Computador.select == 3) {
			nome = "Darth Vader";
		}
		Computador.pcNome = nome;
	}
	
	// Retorna informa��o do n�vel e nome do advers�rio.
		static void pcInfo() {
			System.out.printf("Voc� selecionou o n�vel %d.\n", getNivel());
			System.out.printf("Seu advers�rio ser� %s.\n", getPcNome());
		}	
	}