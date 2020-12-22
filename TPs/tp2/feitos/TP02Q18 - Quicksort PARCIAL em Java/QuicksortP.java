
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

    private  static int comparacoes     = 0;
    private  static int movimentacoes   = 0;
    private  static double tempo;
    

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
	public static void makeLog(double exeTime) throws Exception {
		File arq= new File("./698774_quicksortP.txt");
		RandomAccessFile arquivo = new RandomAccessFile(arq, "rw");
		String matricula = "698774" + "\t" + comparacoes + "\t" + movimentacoes + "\t" + exeTime;
		arquivo.writeChars(matricula);
		arquivo.close();
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

/////////////////////////////////////////////////////////////////////////FUNCOES SET GET

	/**
	 * Funcao para verificar se um nome existe dentro de um array de Jogadores
	 *
	 * @param :    Jogador[] P -- arranjo de Jogadores
	 * 	       int i       -- quantidade de jogadores cadastrados
	 * 	       String S    -- nome a ser comparardo
	 *
	 * @return : boolean resp  -- TRUE caso o nome esteja dentro do arranjo e FALSE caso nao
	 **/
	public static boolean compararIdName(Jogador[] P, int i, String S){
		boolean resp = false;
		
		for(int j=0; j<i; j++){
 //           comparacoes+=2;
    		if(P[j].getNome().equals(S))
        	{
                resp = true; 
				j = i;
			}
		}
		return resp;
	}


	/**
	 * Funcao para ordenar um arranjo usando um algoritmo de selecao em funcao no nome dos Jogadores
	 *
	 * @param :    Jogador[] P -- arranjo de Jogadores
	 * 	           int n       -- quantidade de jogadores cadastrados
	 **/
   public void selecao(Jogador[] P, int n ) {
      for (int i = 0; i < (n - 1); i++) {
 //        comparacoes += 1;
         int menor = i;
         for (int j = (i + 1); j < n; j++){
   //         comparacoes += 2;
            if (P[menor].getNome().compareTo(P[j].getNome()) > 0){
               menor = j;
            }
         }
     //    movimentacoes += 3;
         P = swap(P,menor, i);
      }
   }




    /**
     * Funcao para ordenar um arranjo usando um algoritmo de insercao em funcao no nome dos Jogadores
     *
     * @param :    Jogador[] P -- arranjo de Jogadores
     * 	           int n       -- quantidade de jogadores cadastrados
     **/
    public void insercao(Jogador[] P, int n) {
        for (int i = 1; i < n; i++) {
            //comparacoes += 1;
                //movimentacoes += 1;
            Jogador tmp = P[i];
            int j = i-1;

            while ( (j >=0) && 
    ((P[j].getAnoNascimento() >  tmp.getAnoNascimento())  )
    || (P[j].getAnoNascimento() == tmp.getAnoNascimento()) && P[j].getNome().compareTo(tmp.getNome()) > 0 ) {
                //comparacoes += 4;
                P[j + 1] = P[j];
              //  movimentacoes += 1;
                j--;
            }
            P[j + 1] = tmp;
                //movimentacoes += 1;
        }
   }



    /**
     * Funcao para ordenar um arranjo de jogadores usando uma ordenacao parcial(selecao) onde k==10
     *    
     * @param : Jogador[] P -- arranjo de jogadores 
     *          int n       -- quantidade de jogadores cadastrados
     *          int k       -- fatia a ser ordenada
     */
    public void selecaoP(Jogador[] P, int n, int k){
      //  comparacoes += 1;
        for (int i = 0; i < k; i++) {
            
            int menor = i;
        //    comparacoes += 1;
            for (int j = (i + 1); j < n; j++){
          //      comparacoes += 1;
                if (P[menor].getNome().compareTo(P[j].getNome()) > 0){
                    menor = j;
                }
            }
    //        movimentacoes += 3;
            P = swap(P, menor, i);
        }
     
    }

    /**
     * Funcao para ordenar um arranjo de jogadores usando uma ordenacao parcial(selecao) onde k==10
     *    
     * @param : Jogador[] P -- arranjo de jogadores 
     *          int esq     -- quantidade de jogadores cadastrados
     *          int dir     -- quantidade de jogadores cadastrados
     *          int k       -- fatia a ser ordenada
     */
    public void quicksort(Jogador[] P, int esq, int dir, int k) {
        int i = esq;
        int j = dir;

        Jogador pivo = P[(esq+dir)/2];
        while (i <= j) {

            while((P[i].getEstadoNascimento().compareTo(pivo.getEstadoNascimento()) < 0)||
                 ( P[i].getEstadoNascimento().compareTo(pivo.getEstadoNascimento())==0 )&&
                 ( P[i].getNome().compareTo(pivo.getNome()) < 0 ))
            {
                i++;
            }
            while ((P[j].getEstadoNascimento().compareTo(pivo.getEstadoNascimento())  > 0) || 
                  ( P[j].getEstadoNascimento().compareTo(pivo.getEstadoNascimento()) ==0 ) && 
                  ( P[j].getNome().compareTo(pivo.getNome()) > 0 ))
            {
                j--;
            }
            if (i <= j)
            {
                P = swap(P, i, j);
                i++;
                j--; 
            }
        }
        if (esq < j){
            quicksort(P, esq, j, k);
        }
        if ((i < dir) && (i < k) ){
            quicksort(P, i, dir, k);
        }
    }
}




class QuicksortP{


	public static void main(String[] args) throws Exception {

		double tempo = System.currentTimeMillis();
		int contador, v=0;

		int ints;
		String entrada = new String();
		
  		Jogador[] player;
		Jogador[] player2 = new Jogador[1000];
        player            = Jogador.ler();


		entrada = MyIO.readLine();

    	for(contador=0; entrada.equals("FIM") == false; contador++){           		

		    player2[contador] = player[Integer.parseInt(entrada)];
		    entrada=MyIO.readLine();
  		}

        player[0].quicksort(player2, 0, contador-1, 11);

		for(int i=0; i<10; i++){   		
	    	player2[i].imprimir();
	    }	
        player[0].makeLog(System.currentTimeMillis() - tempo);    
    }
}
