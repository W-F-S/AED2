/*
 *
 * Classe para ler um cvs e criar uma lista de jogadores
 *
 * Walker Freitas dos Santos
 */

import java.io.*;

class Jogador {

	private static int[]    id;
	private static String[] nome;
	private static int[]    altura;
	private static int[]    peso;
	private static int[]    anoNascimento;
	private static String[] universidade;
	private static String[] cidadeNascimento;
	private static String[] estadoNascimento;

	/**
	 * contructor da classe Jogador 
	 */
	public Jogador(){
	
		  this.id               = null;
		  this.nome             = null;
		  this.altura           = null;
		  this.peso             = null;
		  this.anoNascimento    = null;
		  this.universidade     = null;
		  this.cidadeNascimento = null;
		  this.estadoNascimento = null;	
	
	}

	/**
	 * constructor da classe Jogador
	 */
	public Jogador(int i ){
                this.id               = new int[i];
                this.nome             = new String[i];
                this.altura           = new int[i];
                this.peso             = new int[i];
                this.universidade     = new String[i];
                this.anoNascimento    = new int[i];
                this.estadoNascimento = new String[i];
	}


	/** 
	 * Funcao para compiar tudo de um jogador para outro
	 * 
	 * @param : Jogador copia  =  Objeto Jogador a receber a copia;
	 */
	public static void clone(Jogador copia, int i){ 
		copia.setId(i, id[i]);
		copia.setNome(i, nome[i]);
		copia.setAltura(i, altura[i]);
		copia.setPeso(i, peso[i]);
		copia.setUniversidade(i, universidade[i]);
		copia.setAnoNascimento(i, anoNascimento[i]);
		copia.setEstadoNascimento(i, estadoNascimento[i]);
	}

	/**
	 * Function para imprimir os dados dos jogadores 
	 * 
	 * @param : int i = id do jogador;
	 */
	public static void imprimir(int i){//imprimir todos os atributos da classe
	
		MyIO.println("["+ id[i] + " ## " 
		         		+ nome[i]             + " ## "
				        + altura[i]           + " ## "
					+ peso[i]             + " ## "
       				        + anoNascimento[i]    + " ## "
					+ universidade[i]     + " ## "
					+ cidadeNascimento[i] + " ## "
					+ estadoNascimento[i] + "]");
	
	}

	/**
	 * function para ler o arquivo .csv e cadastrar os jogadores
	 */
	public static void ler(){
		String i = "/tmp/players.csv";
//		FileReader teste3 = new FileReader("/tmp/players.csv");

		String textos;
		String[] descart = new String[8];
//		BufferedReader teste = new BufferedReader(teste3);
//        teste.lineNumber();
		Arq.openRead(i);	
		int v = 0;
		int contador = 0;

		Arq.readLine();
		while(Arq.hasNext() != false){
			Arq.readLine();
			contador++;
		}

		id               = new int[contador];
		nome             = new String[contador];
		altura           = new int[contador];
		peso             = new int[contador];
		anoNascimento    = new int[contador];
		universidade     = new String[contador];
		cidadeNascimento = new String[contador];
		estadoNascimento = new String[contador];

		Arq.close();
		
		Arq.openRead(i);

		Arq.readLine();
		while(Arq.hasNext() == true){
			
			textos              = Arq.readLine();
			descart             = textos.split(",", 8);	
			id[v]               = Integer.parseInt(descart[0]);
			nome[v]             = descart[1];
			altura[v]           = Integer.parseInt(descart[2]);
			peso[v]             = Integer.parseInt(descart[3]);
			universidade[v]     = descart[4];
			anoNascimento[v]    = Integer.parseInt(descart[5]);
			cidadeNascimento[v] = descart[6];
			estadoNascimento[v] = descart[7];

        	  if (descart[1].length() == 0 ){	  
				nome[v] = "nao informado";
			} if (descart[4].length() == 0 ){
				universidade[v] = "nao informado"; 
			} if (descart[6].length() == 0 ){
				cidadeNascimento[v] = "nao informado"; 
			} if (descart[7].length() == 0 ){
				estadoNascimento[v] = "nao informado"; 
			}	
			v++;
		}
		Arq.close();
	}
	
	
	/**
	 * Funcao para retornar a id deste jogador
	 *
	 * @return: int id = id deste objeto
	 */
	public static int getsId(int i){
		return id[i];
	}
	
	/**
	 * Funcao para setar a id deste jogador
	 *
	 * @param : int i = nova id
	 */
	public static void setId(int i, int v){
		id[i] = v;
	}

	/**
	 * Funcao para retornar o nome deste jogador
	 * @param : int i       = id do jogador
	 * @return: String nome = nome deste jogador
	 */
	public static String getsNome(int i){
		return nome[i];
	}

	/**
	 * Funcao para setar o nome deste jogador
	 *                
	 * @param : String i = novo nome    
         *             int i = id do jogador
	 */
	public static void setNome(int i, String v){
		nome[i] = v;
	}
	
	/**
	 * Funcao para retornar a altura do jogador
         * @param : int i         = id do jogador
         * @return: int altura[i] = altura do jogador
         */
	public static int getsAltura(int i){
		return altura[i];
	}
	
	/**
	 * Funcao para setar a altura do jogador 
         * @param : int i = id do jogador
         *          int v = nova altura do jogador
         */
	public static void setAltura(int i, int v){
		altura[i] = v;
	}
	
	/**
	 * Funcao para retornar o peso do jogador
	 *
	 * @param : int i       = id do jogador 
         * @return: int peso[i] = atual peso do jogador
         */
	public static int getsPeso(int i){
		return peso[i];
	}
	
	/**
	 * Funcao para setar o novo peso do jogador 
         * 
	 * @param : int i = id do jogador         
	 *          int v = novo peso
         */
	public static void setPeso(int i, int v){
		peso[i] = v;
	}
		
        /**
	 * Funcao para retornar a universidade do jogador 
	 * 
	 * @param : int i = id do jogador
	 * @return: String universidade[i] = retorna a universidade do jogador
         */
	public static String getsUniverdade(int i){
		return universidade[i];
	}
          	
        /**
	 * Funcao para setar a universidade do jogador 
	 * 
	 * @param : int i    = id do jogador
	 * 	    String v = nova universidade	
         */
	public static void setUniversidade(int i, String v){
	 	universidade[i] = v;
	} 
            	
        /**
	 * Funcao para retornar o ano de nascimento do jogador 
	 * 
	 * @param : int i            = id do jogador
	 * @return: anoNascimento[i] = ano de nascimento do jogador
         */
	public static int getsAnoNascimento(int i){
	 	return anoNascimento[i];
	} 
            	
        /**
	 * Funcao para setar o ano de nascimento do jogador 
	 * 
	 * @param : int i = id do jogador
	 *          int v = novo ano de nascimento do jogador
         */
	public static void setAnoNascimento(int i, int v){
		anoNascimento[i] = v;
	}
	  	
        /**
	 * Funcao para retornar a cidade de nascimento do jogador 
	 * 
	 * @param : int i                      = id do jogador
	 * @return: String cidadeNascimento[i] = retorna a cidade de nascimento do jogador
         */             
	public static String getsCidadeNascimento(int i){
		return cidadeNascimento[i];	
	}
                	
        /**
	 * Funcao para retornar setar a cidade de nascimento do jogador 
	 * 
	 * @param : int i = id do jogador
         */     
	public static void setCidadeNascimento(int i, String v){
		cidadeNascimento[i] = v;
	}
                	
        /**
	 * Funcao para retornar o estado de nascimento do jogador 
	 * 
	 * @param : int i                   = id do jogador
	 * @return: String estadoNascimento = retorna o estado de nascimento do jogador
         */
	public static String getEstadoNascimento(int i){
		return estadoNascimento[i];
	}
                      	
        /**
	 * Funcao para setar o estado de nascimento do jogador 
	 * 
	 * @param : int i    = id do jogador
	 * 	    String v = novo estado de nascimento do jogador
         */
	public static void setEstadoNascimento(int i, String v){
		estadoNascimento[i] = v;
	}

	/**
	 * Funcao para verificar se ja chegou ao fim do programa
	 *
	 * @param : String i = string a ser analisada
	 * @return: booleam  = true caso seja igual a "FIM"
	 * 		       false caso nao seja igual a "FIM"
	 */
	public static boolean fim(String i){
		return (i.length() == 3 && i.charAt(0)=='F'&& i.charAt(1) == 'I' && i.charAt(2) == 'M');
	}

	public static void main(String[] args) throws Exception {

		Jogador player = new Jogador();
		String entrada =  MyIO.readLine();
		player.ler();
		do{
			player.imprimir(Integer.parseInt(entrada));
			entrada = MyIO.readLine();
		}while(!fim(entrada));  
	}
}
