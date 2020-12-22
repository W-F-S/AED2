
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



//////////////////////////////////////////////////////////CONSTRUTORES

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

    public Jogador[] swap(Jogador[] P1, int pri, int seg)
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
	 * Funcao para fazer um arquivo log
	 */
	public static void makeLog(double exeTime, int comparacoes, int movimentacoes) throws Exception {
		Arq.openWrite("698774_merge.txt");
		String matricula = "698774" + "\t" + comparacoes + "\t" + movimentacoes + "\t" + exeTime;
		Arq.print(matricula);
		Arq.close();
	}


	/** 
	 * Funcao para compiar tudo de um jogador para outro
	 * 
	 * @param : Jogador copia  =  Objeto Jogador a receber a copia;
	 */
	void clone(Jogador copia){ 
		Jogador player = new Jogador();

		copia.setId( player.getId() );
		copia.setNome( player.nome );
		copia.setAltura( player.altura );
		copia.setPeso( player.peso );
		copia.setUniversidade( player.universidade );
		copia.setAnoNascimento( player.anoNascimento );
		copia.setEstadoNascimento( player.estadoNascimento );
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
             if (descart[1].length() == 0 ){	  
				player[v].setNome            ("nao informado");
			} if (descart[4].length() == 0 ){
				player[v].setUniversidade    ("nao informado"); 
			} if (descart[6].length() == 0 ){
				player[v].setCidadeNascimento("nao informado"); 
			} if (descart[7].length() == 0 ){
				player[v].setEstadoNascimento("nao informado"); 
			}	
			v++;
		}
		Arq.close();
                return player;
	}
	

//////////////////////////////////////////////////////////FUNCOES AUXILIARES


/////////////////////////////////////////////////////////////////////////FUNCOES SET GET
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
         * @param : int i         = id do jogador
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
		 altura = v;
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
	String getUniversidade(){
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


}

class Mergesort{
   public static int comparacoes   = 0;
   public static int movimentacoes = 0;
   /**
    * Funcao que inicia o mergsort
    *
    * @param: Jogador[] array -- array de jogadores a ser ordenado
    * @param: int n           -- quantidade de jogadores cadastrados em array
    */ 
   public static void sort(Jogador[] array, int n) {
      mergesort(array, 0, n-1);
   }

   /**
    * Funcao para definir os elementos esq, dir e meio usados no mergsort
    *
    * @param: Jogador[] array -- array de jogadores a ser ordenado
    * @param: int esq
    * @param: int dir
    */ 
   private static void mergesort(Jogador[] array, int esq, int dir) {
      if (esq < dir){
         comparacoes += 1;
         int meio = (esq + dir) / 2;
         mergesort(array, esq, meio);
         mergesort(array, meio + 1, dir);
         intercalar(array, esq, meio, dir);
      }
    comparacoes += 1;
   }

   /**
    * Funcao para intercalar os elementos entre as posicoes esq e dir
    *
    * @param: Jogador[] array -- array de jogadores a ser ordenado
    * @param: int esq
    * @param: int meio
    * @param: int dir
    */ 
   public static void intercalar(Jogador[] array, int esq, int meio, int dir){
      int n1, n2, i, j, k;

      n1 = meio-esq+1;
      n2 = dir - meio;

      Jogador[] a1 = new Jogador[n1+1];
      Jogador[] a2 = new Jogador[n2+1];
      for(i = 0; i < n1+1; i++){
         comparacoes += 1; 
         a1[i] = new Jogador();
      }
    
      for(i = 0; i < n2+1; i++){
         comparacoes += 1;
         a2[i] = new Jogador();
      }
    

      for(i = 0; i < n1; i++){
         comparacoes += 1;
         a1[i] = array[esq+i];
      }


      for(j = 0; j < n2; j++){
         comparacoes += 1;
         a2[j] = array[meio+j+1];
      }


     a1[i].setUniversidade("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
     a2[j].setUniversidade("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
     for(i = j = 0, k = esq; k <= dir; k++){
           comparacoes += 1;
            if(  (a1[i].getUniversidade().compareTo(a2[j].getUniversidade()) < 0) || 
                  a1[i].getUniversidade().compareTo(a2[j].getUniversidade()) == 0 &&    
                  a1[i].getNome().compareTo(a2[j].getNome()) < 0) 
            {
                comparacoes += 3;
                array[k] = a1[i++];
                movimentacoes+=1;
            }else{
                array[k] = a2[j++];
                movimentacoes+=1;
            }
      }
    }

    public static void main(String[] args)throws Exception {
   		double tempo = System.currentTimeMillis();
		int contador, v=0;

		int ints;
		String entrada = new String();
		
  		Jogador[] player;
		Jogador[] player2 = new Jogador[500];
        player            = Jogador.ler();

		entrada = MyIO.readLine();

    	for(contador=0; entrada.equals("FIM")==false; contador++)
        {
		    player2[contador] =  player[Integer.parseInt(entrada)];
		    entrada=MyIO.readLine();
  		}

        sort(player2, contador);

	    for(int i=0; i<contador; i++){   		
	    	player2[i].imprimir();
	    }	
        player[0].makeLog(System.currentTimeMillis() - tempo, comparacoes, movimentacoes);
    }  
}


    

