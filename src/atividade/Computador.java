package atividade;

/* Essa classe recebe a informação do nível selecionado e fornece o método para as classes
 * com os nível de dificuldade das jogadas. 
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
	
	// Verifica o nível selecionado pelo jogador e retorna um nome para o Computador.
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
	
	// Retorna informação do nível e nome do adversário.
		static void pcInfo() {
			System.out.printf("Você selecionou o nível %d.\n", getNivel());
			System.out.printf("Seu adversário será %s.\n", getPcNome());
		}	
	}