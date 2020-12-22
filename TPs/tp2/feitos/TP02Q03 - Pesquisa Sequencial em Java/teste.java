
import java.io.*;

class Jogador {

	private static int      id;
	private static String nome;
	private static int    altura;
	private static int    peso;
	private static int    anoNascimento;
	private static String universidade;
	private static String cidadeNascimento;
	private static String estadoNascimento;

	private static int comparacoes = 0;

	/**
	 * contructor da classe Jogador 
	 */
	public Jogador(){
	
		   id               = -1;
		   nome             = "";
		   altura           = -1;
		   peso             = -1;
		   anoNascimento    = -1;
		   universidade     = "";
		   cidadeNascimento = "";
		   estadoNascimento = "";	
	}

	/**
	 * constructor da classe Jogador
	 */
	public Jogador(int idN, 
                   int alturaN, 
                   int pesoN, 
                   int anoNascimentoN, 
                   String universidadeN, 
                   String estadoNascimentoN, 
                   String nomeN ){

                id               = idN;
                nome             = nomeN;
                altura           = alturaN;
                peso             = pesoN;
                universidade     = universidadeN;
                anoNascimento    = anoNascimentoN;
                estadoNascimento = estadoNascimentoN;
	}


	/** 
	 * Funcao para compiar tudo de um jogador para outro
	 * 
	 * @param : Jogador copia  =  Objeto Jogador a receber a copia;
	 */
	public static void clone(Jogador copia){ 
		copia.setId( getId() );
		copia.setNome(nome );
		copia.setAltura(altura );
		copia.setPeso( peso );
		copia.setUniversidade( universidade );
		copia.setAnoNascimento( anoNascimento );
		copia.setEstadoNascimento( estadoNascimento );
	}

	/**
	 * Function para imprimir os dados dos jogadores 
	 * 
	 * @param : int i = id do jogador;
	 */
	public static void imprimir(){//imprimir todos os atributos da classe
	
		MyIO.println("["+   id                + " ## " 
		         		+   nome              + " ## "
				        +   altura            + " ## "
					    +   peso              + " ## "
       				    +   anoNascimento     + " ## "
					    +   universidade      + " ## "
					    +   cidadeNascimento  + " ## "
					    +   estadoNascimento  + "]");
	
	}

	/**
	 * function para ler o arquivo .csv e cadastrar os jogadores
	 */
	public static Jogador[] ler(){

        int playersNum = getArqLinha("/tmp/players.csv");
      	Jogador[] player  = new Jogador[playersNum]; 

        
        int v = 0;
		String textos;
		String[] descart = new String[8];

		Arq.openRead("/tmp/players.csv");

		Arq.readLine();
		while(Arq.hasNext() == true){
            player[v] = new Jogador();
			
			textos              = Arq.readLine();
			descart             = textos.split(",", 8);	

            MyIO.print("\n\nPlayer["+ v +"] antes de tudo: ");
            player[v].imprimir();           

			player[v].id = (Integer.parseInt(descart[0]));
			player[v].setNome(descart[1]);
            player[v].setAltura(Integer.parseInt(descart[2]));
			player[v].setPeso(Integer.parseInt(descart[3]));
            player[v].setUniversidade(descart[4]);
            player[v].setAnoNascimento(Integer.parseInt(descart[5]));
            player[v].setCidadeNascimento(descart[6]);
            player[v].setEstadoNascimento(descart[7]);

        	  if (descart[1].length() == 0 ){	  
				player[v].setNome            ("nao informado");
			} if (descart[4].length() == 0 ){
				player[v].setUniversidade    ("nao informado"); 
			} if (descart[6].length() == 0 ){
				player[v].setCidadeNascimento("nao informado"); 
			} if (descart[7].length() == 0 ){
				player[v].setEstadoNascimento("nao informado"); 
			}	

            MyIO.print("\n\nPlayer["+ v +"] depois de tudo: ");
            player[v].imprimir();
			v++;
		}
		Arq.close();



        return player;
	}
	


	/**
	 * Funcao para abrir um arquivo e retornar a sua quantidade de linhas
	 *
	 * @param : String local = localizacao do arquivo
	 *
	 * @return: int linhas   = quantidade de linhas do arquivo
     */	 
	public static int getArqLinha(String i){
	

		Arq.openRead(i);	
		int v = 0;
		int contador = 0;

		Arq.readLine();
		while(Arq.hasNext() != false){
			Arq.readLine();
			contador++;
		}
        
		Arq.close();	
        return contador;
	}

	
	/**
	 * Funcao para retornar a id deste jogador
	 *
	 * @return: int id = id deste objeto
	 */
	public static int getId(){
		return  id;
	}
	

/////////////////////////////////////////////////////////////////////////FUNCOES SET GET


	/**
	 * Funcao para setar a id deste jogador
	 *
	 * @param : int i = nova id
	 */
	public static void setId( int v){
		 id = v;
	}

	/**
	 * Funcao para retornar o nome deste jogador
	 * @param : int i       = id do jogador
	 * @return: String nome = nome deste jogador
	 */
	public static String getNome(){
		return   nome;
	}

	/**
	 * Funcao para setar o nome deste jogador
	 *                
	 * @param : String i = novo nome    
         *             int i = id do jogador
	 */
	public static void setNome( String v){
		  nome = v;
	}
	
	/**
	 * Funcao para retornar a altura do jogador
         * @param : int i         = id do jogador
         * @return: int altura  = altura do jogador
         */
	public static int getAltura(){
		return  altura;
	}
	
	/**
	 * Funcao para setar a altura do jogador 
         * @param : int i = id do jogador
         *          int v = nova altura do jogador
         */
	public static void setAltura(int v){
		 altura = v;
	}
	
	/**
	 * Funcao para retornar o peso do jogador
	 *
	 * @param : int i       = id do jogador 
         * @return: int peso  = atual peso do jogador
         */
	public static int getPeso(){
		return  peso;
	}
	
	/**
	 * Funcao para setar o novo peso do jogador 
         * 
	 * @param : int i = id do jogador         
	 *          int v = novo peso
         */
	public static void setPeso(int v){
		 peso = v;
	}
		
        /**
	 * Funcao para retornar a universidade do jogador 
	 * 
	 * @param : int i = id do jogador
	 * @return: String universidade  = retorna a universidade do jogador
         */
	public static String getUniverdade(){
		return  universidade;
	}
          	
        /**
	 * Funcao para setar a universidade do jogador 
	 * 
	 * @param : int i    = id do jogador
	 * 	    String v = nova universidade	
         */
	public static void setUniversidade(String v){
	 	 universidade  = v;
	} 
            	
        /**
	 * Funcao para retornar o ano de nascimento do jogador 
	 * 
	 * @param : int i            = id do jogador
	 * @return: anoNascimento  = ano de nascimento do jogador
         */
	public static int getAnoNascimento(){
	 	return  anoNascimento ;
	} 
            	
        /**
	 * Funcao para setar o ano de nascimento do jogador 
	 * 
	 * @param : int i = id do jogador
	           int v = novo ano de nascimento do jogador
*/
	public static void setAnoNascimento( int v){
		 anoNascimento  = v;
	}
                	
        /**
	 * Funcao para retornar setar a cidade de nascimento do jogador 
	 * 
	 * @param : int i = id do jogador
         */     
	public static void setCidadeNascimento( String v){
		 cidadeNascimento  = v;
	}
                	
        /**
	 * Funcao para retornar o estado de nascimento do jogador 
	 * 
	 * @param : int i                   = id do jogador
	 * @return: String estadoNascimento = retorna o estado de nascimento do jogador
         */
	public static String getEstadoNascimento(){
		return  estadoNascimento ;
	}
                      	
        /**
	 * Funcao para setar o estado de nascimento do jogador 
	 * 
	 * @param : int i    = id do jogador
	 * 	    String v = novo estado de nascimento do jogador
         */
	public static void setEstadoNascimento(String v){
		 estadoNascimento  = v;
	}

	/**
	 * Funcao para verificar se ja chegou ao fim do programa
	 *
	 * @param : String i = string a ser analisada
	 * @return: booleam  = true caso seja igual a "FIM"
	 * 		       false caso nao seja igual a "FIM"
	 */
	public static boolean fim(String i){
		return (i.length() == 3 && i.charAt(0)=='F' && i.charAt(1) == 'I' && i.charAt(2) == 'M');
	}




	public static boolean compIdName( String name){
	
		boolean resp = false;

		if( nome.equals(name)){
			resp=true;
		}
		return resp;
	}



	public static boolean compNome(int tamanho, Jogador[] player2, String i){ 
		boolean resp = false;
        
        MyIO.println("Tamanho: "+ tamanho);
		for(int v=0; v<tamanho; v++){ 
               MyIO.println("Comparando: "+ player2[v].getNome() + " com: " + i);

			if( player2[v].getNome().equals(i) ){
                MyIO.println("encontrado: "+ player2[v].getNome());
			    resp = true;
			    v    = tamanho;
            }
            comparacoes += 2;
        }   
		return resp;
	}


	public static void makeLog(int comp, long exeTime) throws Exception {
		File arq= new File("./matrícula_sequencial.txt");
		RandomAccessFile arquivo = new RandomAccessFile(arq, "rw");
		String matricula = "698774" + "\t" + exeTime + "\t" + comp;
		arquivo.writeChars(matricula);
		arquivo.close();
	}





}


class teste{


	public static void main(String[] args) throws Exception {

		long start = System.currentTimeMillis();
		long end;
		int contador=0, v=0;


		int ints;
		String nomes;
		
      	Jogador[] player;
        player = Jogador.ler();

        int playersNum = Jogador.getArqLinha("/tmp/players.csv");
        for(int j=0; j<playersNum; j++){
                MyIO.println("j = "+j);
                   player[j].imprimir(); 
      
        }


        Jogador[] player2 = new Jogador[500];
        for(int i=0; i<500; i++){
                player2[i] = new Jogador();
        }
	}

}





//        for(int i=0; i<playersNum; i++){
  //              player[i].imprimir();             
    //    }
 
    /*		String entrada =  MyIO.readLine();
	   
		while(!fim(entrada) && contador < 500){
    
            ints = Integer.parseInt(entrada);
            MyIO.print("\n\n\n\n\n\nENTRADA:"+entrada+"\n\n\n\n\n\n");
            player[ints].imprimir();

        
			player2[contador].clone( player[ints] );
            contador++;			
            entrada = MyIO.readLine();     
		}  

		entrada = MyIO.readLine();

		while(!fim(entrada)){

	        if(compNome(contador, player2, entrada))
	    		   MyIO.println("SIM");  
            else
                   MyIO.println("NAO");

            entrada = MyIO.readLine();
		} 

		end = (System.currentTimeMillis() - start);
		makeLog(comparacoes, end);			*/

