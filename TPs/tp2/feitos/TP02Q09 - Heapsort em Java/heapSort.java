
import java.io.*;

class Jogador {

	private  int      id;
	private  String nome;
	private  int    altura;
	private  int    peso;
	private  int    anoNascimento;
	private  String universidade;
	private  String cidadeNascimento;
	private  String estadoNascimento;
    public  static int comparacoes     = 0;
    public  static int movimentacoes   = 0;
    public  static double tempo;

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

//////////////////////////////////////////////////////////CONSTRUTORES


//////////////////////////////////////////////////////////FUNCOES AUXILIARES

    public static Jogador[] swap(Jogador[] P1, int pri, int seg)
    {   
        Jogador temp = P1[seg];
        P1[seg] = P1[pri];
        P1[pri] = temp;
        return P1;
    }

	/**
	 * Funcao para abrir um arquivo e retornar a sua quantidade de linhas
	 *
	 * @param : String local = localizacao do arquivo
	 *
	 * @return: int linhas   = quantidade de linhas do arquivo
         */	 
	 static int getArqLinha(String i){
		int v = 0;
		int contador = 0;
		Arq.openRead(i);	
		Arq.readLine();

		while(Arq.hasNext() != false){
			Arq.readLine();
			contador++;
		}
		Arq.close();	
        return contador;
	}

	/** 
	 * Funcao para compiar tudo de um jogador para outro
	 * 
	 * @param : Jogador copia  =  Objeto Jogador a receber a copia;
	 */
	public Jogador clone(){ 
		Jogador copia = new Jogador();

		copia.setId( this.getId() );
		copia.setNome( this.nome );
		copia.setAltura( this.altura );
		copia.setPeso( this.peso );
		copia.setUniversidade( this.universidade );
		copia.setAnoNascimento( this.anoNascimento );
		copia.setEstadoNascimento( this.estadoNascimento );

        return copia;
	}

	/**
	 * Function para imprimir os dados dos jogadores 
	 * 
	 * @param : int i = id do jogador;
	 */
        void imprimir(){
	
		MyIO.println("["+ id                + " ## " 
		                + nome              + " ## "
                                + altura            + " ## "
                                + peso              + " ## "
                                + anoNascimento     + " ## "
                                + universidade      + " ## "
                                + cidadeNascimento  + " ## "
                                + estadoNascimento  + "]");
	
 	}

	/**
	 * function para ler o arquivo .csv e cadastrar os jogadores
	 */
	static Jogador[] ler(){
		
                int playersNum = getArqLinha("/tmp/players.csv");
          	Jogador[] player  = new Jogador[playersNum];
                int v = 0;
		String textos;
		String[] descart = new String[8];
		Arq.openRead("/tmp/players.csv");
		Arq.readLine();
		
		while(Arq.hasNext() == true){
                        player[v] = new Jogador();
			textos    = Arq.readLine();
			descart   = textos.split(",", 8);	

			player[v].id = (Integer.parseInt(descart[0]));
			player[v].setNome(descart[1]);
                        player[v].setAltura(Integer.parseInt(descart[2]));
			player[v].setPeso(Integer.parseInt(descart[3]));
                        player[v].setUniversidade(descart[4]);
                        player[v].setAnoNascimento(Integer.parseInt(descart[5]));
                        player[v].setCidadeNascimento(descart[6]);
                        player[v].setEstadoNascimento(descart[7]);

 //            if(descart[1].contains("*")){
   //         	player[v].setNome(descart[1].replace("*", ""));

			 if (descart[4].equals("") ){
				player[v].setUniversidade    ("nao informado"); 
			} if (descart[6].equals("") ){
				player[v].setCidadeNascimento("nao informado"); 
			} if (descart[7].equals("") ){
				player[v].setEstadoNascimento("nao informado"); 
			}	
			v++;
		}      
		Arq.close();
                return player;
	}

	/**
	 * Funcao para retornar a id deste jogador
	 *
	 * @return: int id = id deste objeto
	 */
	int getId(){
		return  id;
	}
	
	/**
	 * Funcao para setar a id deste jogador
	 *
	 * @param : int i = nova id
	 */
	void setId( int v){
		id = v;
	}

	/**
	 * Funcao para retornar o nome deste jogador
	 * @param : int i       = id do jogador
	 * @return: String nome = nome deste jogador
	 */
	String getNome(){
        	return nome;
	}

	/**
	 * Funcao para setar o nome deste jogador
	 *                
	 * @param : String i = novo nome    
         *             int i = id do jogador
	 */
	void setNome( String v){
		nome = v;
	}
	
	/**
	 * Funcao para retornar a altura do jogador
         * 
         * @return: int altura  = altura do jogador
         */
        int getAltura(){
		return  altura;
	}
	
	/**
	 * Funcao para setar a altura do jogador 
         * @param : int i = id do jogador
         *          int v = nova altura do jogador
         */
        void setAltura(int v){
		 this.altura = v;
	}
	
	/**
	 * Funcao para retornar o peso do jogador
	 *
	 * @param : int i       = id do jogador 
         * @return: int peso  = atual peso do jogador
         */
        int getPeso(){
		return  peso;
	}
	
	/**
	 * Funcao para setar o novo peso do jogador 
         * 
	 * @param : int i = id do jogador         
	 *          int v = novo peso
         */
	void setPeso(int v){
		 peso = v;
	}
		
        /**
	 * Funcao para retornar a universidade do jogador 
	 * 
	 * @param : int i = id do jogador
	 * @return: String universidade  = retorna a universidade do jogador
         */
	String getUniverdade(){
		return  universidade;
		}
          	
        /**
	 * Funcao para setar a universidade do jogador 
	 * 
	 * @param : int i    = id do jogador
	 * 	    String v = nova universidade	
         */
	void setUniversidade(String v){
	 	 universidade  = v;
	} 
            	
        /**
	 * Funcao para retornar o ano de nascimento do jogador 
	 * 
	 * @param : int i            = id do jogador
	 * @return: anoNascimento  = ano de nascimento do jogador
         */
	int getAnoNascimento(){
	 	return  anoNascimento ;
	} 
            	
        /**
	 * Funcao para setar o ano de nascimento do jogador 
	 * 
	 * @param : int i = id do jogador
	           int v = novo ano de nascimento do jogador
*/
	void setAnoNascimento( int v){
		 anoNascimento  = v;
	}
                	
        /**
	 * Funcao para retornar setar a cidade de nascimento do jogador 
	 * 
	 * @param : int i = id do jogador
         */     
	void setCidadeNascimento( String v){
		 cidadeNascimento  = v;
	}
                	
    /**
	 * Funcao para retornar o estado de nascimento do jogador 
	 * 
	 * @param : int i                   = id do jogador
	 * @return: String estadoNascimento = retorna o estado de nascimento do jogador
     */
	String getEstadoNascimento(){
		return  estadoNascimento ;
	}
                      	
    /**
	 * Funcao para setar o estado de nascimento do jogador 
	 * 
	 * @param : int i    = id do jogador
	 * 	    String v = novo estado de nascimento do jogador
     */
	void setEstadoNascimento(String v){
		 estadoNascimento  = v;
	}

    public static void constroi(Jogador[] player, int tamHeap){
        for(int i = tamHeap; (i > 1 && ((player[i].getAltura() > player[i / 2].getAltura()) || 
                                        (player[i].getAltura() == player[i / 2].getAltura() && 
                                         player[i].getNome().compareTo(player[i / 2].getNome()) > 0))); i /= 2){
                                  comparacoes += 3;
                                  swap(player, i, i / 2); 
                              }
    }

    public static int getMaiorFilho(Jogador[] player, int i, int tamHeap){
        int filho;
        comparacoes += 4;
        if((2 * i == tamHeap) || (player[2 * i].getAltura() > player[2 * i + 1].getAltura() || 
                                  ((player[2 * i].getAltura() == player[2 * i + 1].getAltura()) && 
                                   (player[i * 2].getNome().compareTo(player[i * 2 + 1].getNome()) > 0)))){
               filho = 2 * i;
           } else {
               filho = 2 * i + 1;
           }
        return filho;
    }

    public static void reconstroi(Jogador[] player, int tamHeap){
        int i = 1;
        while(i <= (tamHeap / 2)){
            int filho = getMaiorFilho(player, i, tamHeap);
            comparacoes += 3;
            if((player[i].getAltura() < player[filho].getAltura()) || (player[i].getAltura() == player[filho].getAltura() 
                                                                   && (player[i].getNome().compareTo(player[filho].getNome()) < 0))){
                   movimentacoes += 3;
                   swap(player, i, filho);
                   i = filho; 
               } else {
                   i = tamHeap;
               }
        }
    }

    public static Jogador[] heapSort(Jogador[] player, int tam){
        Jogador[] tmp = new Jogador[tam + 1];
        for(int i = 0; i < tam; i++){
            tmp[i + 1] = new Jogador();
            movimentacoes += 1;
            tmp[i + 1] = player[i];
        }
        player = tmp;
        for(int tamHeap = 2; tamHeap <= tam; tamHeap++){
            constroi(player, tamHeap);
        }
        int tamHeap = tam;
        while(tamHeap > 1){
            movimentacoes += 3;
            swap(player, 1, tamHeap--);
            reconstroi(player, tamHeap);
        }
        tmp = player;
        player = new Jogador[tam];
        for(int i = 0; i < tam; i++){
            movimentacoes += 1;
            player[i] = tmp[i + 1];
        }
        return player;
    }
}

class heapSort{
	public static void main(String[] args) throws Exception {
		double tempo = System.currentTimeMillis();
		int contador, v=0;
		int ints;
		String entrada = new String();
  		Jogador[] player;
		Jogador[] player2 = new Jogador[500];
        player            = Jogador.ler();
        int playersNum = Jogador.getArqLinha("/tmp/players.csv");
		entrada = MyIO.readLine();
    	for(contador=0; !entrada.equals("FIM"); contador++){
		    player2[contador] =  player[Integer.parseInt(entrada)];
		    entrada=MyIO.readLine();
  		}
        player2 = player2[0].heapSort(player2, contador);
		for(int i=0; i<contador; i++){	
	    	player2[i].imprimir();
	    }	
       tempo = System.currentTimeMillis() - tempo;
		Arq.openWrite("698774_heapSort.txt");
   		String matricula = "698774" + "\t" + player2[0].comparacoes + "\t" + player2[0].movimentacoes + "\t" + tempo;
		Arq.print(matricula);
		Arq.close();
    }
    
}


    

