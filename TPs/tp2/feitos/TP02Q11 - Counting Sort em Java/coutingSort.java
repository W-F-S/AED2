
import java.io.*;

class Jogador {

	private  int    id;
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

	public Jogador(int idN, int alturaN, int pesoN, int anoNascimentoN, String universidadeN, String cidadeNascimentoN, String estadoNascimentoN, String nomeN ){
                id               = idN;
                nome             = nomeN;
                altura           = alturaN;
                peso             = pesoN;
                universidade     = universidadeN;
                anoNascimento    = anoNascimentoN;
                estadoNascimento = estadoNascimentoN;
                estadoNascimento = estadoNascimentoN;
	}

    public Jogador[] swap(Jogador[] P1, int pri, int seg){   
        Jogador temp = P1[seg];
        P1[seg] = P1[pri];
        P1[pri] = temp;
        return P1;
    }

	/**
	 * Funcao para abrir um arquivo e retornar a sua quantidade de linhas
	 *
	 * @param   local  String localizacao do arquivo
	 * @return: linhas int    quantidade de linhas do arquivo
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
                                + this.cidadeNascimento  + " ## "
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

			player[v].setId(Integer.parseInt(descart[0]));
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
		return  this.id;
	}
	
	/**
	 * Funcao para setar a id deste jogador
	 *
	 * @param : int i = nova id
	 */
	void setId( int v){
		this.id = v;
	}

	/**
	 * Funcao para retornar o nome deste jogador
	 * @param : int i       = id do jogador
	 * @return: String nome = nome deste jogador
	 */
	String getNome(){
        	return this.nome;
	}

	/**
	 * Funcao para setar o nome deste jogador
	 *                
	 * @param : String i = novo nome    
         *             int i = id do jogador
	 */
	void setNome( String v){
		this.nome = v;
	}
	
	/**
	 * Funcao para retornar a altura do jogador
         * 
         * @return: int altura  = altura do jogador
         */
        int getAltura(){
		return  this.altura;
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
		return  this.peso;
	}
	
	/**
	 * Funcao para setar o novo peso do jogador 
         * 
	 * @param : int i = id do jogador         
	 *          int v = novo peso
         */
	void setPeso(int v){
		 this.peso = v;
	}
		
        /**
	 * Funcao para retornar a universidade do jogador 
	 * 
	 * @param : int i = id do jogador
	 * @return: String universidade  = retorna a universidade do jogador
         */
	String getUniverdade(){
		return  this.universidade;
		}
          	
        /**
	 * Funcao para setar a universidade do jogador 
	 * 
	 * @param : int i    = id do jogador
	 * 	    String v = nova universidade	
         */
	void setUniversidade(String v){
	 	 this.universidade  = v;
	} 
            	
        /**
	 * Funcao para retornar o ano de nascimento do jogador 
	 * 
	 * @param : int i            = id do jogador
	 * @return: anoNascimento  = ano de nascimento do jogador
         */
	int getAnoNascimento(){
	 	return this.anoNascimento ;
	} 
            	
        /**
	 * Funcao para setar o ano de nascimento do jogador 
	 * 
	 * @param : int i = id do jogador
	           int v = novo ano de nascimento do jogador
*/
	void setAnoNascimento( int v){
		 this.anoNascimento  = v;
	}
                	
    /**
	 * Funcao para setar a cidade de nascimento do jogador 
	 * 
	 * @param : int i = id do jogador
     */     
	void setCidadeNascimento( String v){
		 this.cidadeNascimento  = v;
	}
     

    /**
	 * Funcao para retornar a cidade de nascimento do jogador 
	 * 
	 * @param : int i = id do jogador
     */     
	String getCidadeNascimento(){
		 return this.cidadeNascimento;
	}
                    	
    /**
	 * Funcao para retornar o estado de nascimento do jogador 
	 * 
	 * @param : int i                   = id do jogador
	 * @return: String estadoNascimento = retorna o estado de nascimento do jogador
     */
	String getEstadoNascimento(){
		return this.estadoNascimento ;
	}
                      	
    /**
	 * Funcao para setar o estado de nascimento do jogador 
	 * 
	 * @param : int i    = id do jogador
	 * 	    String v = novo estado de nascimento do jogador
     */
	void setEstadoNascimento(String v){
		 this.estadoNascimento  = v;
	}




    /**
     * Funcao para ordenar um arranjo usando um algoritmo de insercao em funcao no nome dos Jogadores
     *
     * @param player Jogador[] referencia para o arranjo Jogador
     * @param n      int       quantidade de jogadores cadastrados
     **/
    public static void insercao(Jogador[] player, int n){
        for(int i = 1; i < n; i++){
            Jogador temp = player[i];
            int j = i - 1;
            while(j >= 0 &&  player[j].getAltura() == temp.getAltura() && player[j].getNome().compareTo(temp.getNome()) > 0 ){
                  player[j + 1] = player[j];
                  j--;
            }
            player[j + 1] = temp;
        }
    }

   /**
	* Funcao para retornar a maior altura dentro do arranjo de jogadores
    *
    * @param  player Jogador[] referencia para o arranjo Jogador
    * @param  tam    int       tamanho de player
    * @return maior  int       maior altura encontrada no array 
	*/
    static int getMaior(Jogador[] player, int tam){
        int maior = player[0].getAltura();    
        for(int i = 1; i < tam; i++){
            if(maior < player[i].getAltura()){
                maior = player[i].getAltura();             
            }
        }
        return(maior);
    }

   /**
	* Funcao para ordenar um arranjo de jogadores em funcao da altura usando um coutinsort
    *
    * @param  player Jogador[] referencia para o arranjo Jogador
    * @param  tam    int       tamanho de player
	*/  
    public static void sort(Jogador[] player, int tam){
        int maior = (getMaior(player, tam)) + 1;
        Jogador[] array  = new Jogador[maior];
        Jogador[] output = new Jogador[tam];
        for(int i = 0; i < maior; i++){
            array[i] = new Jogador();
        }
        // Inicializando as posições de array.
        for(int i = 0; i < maior; array[i].setAltura(0), i++);
        // array[i] contem o numero de elementos iguais a i.
        for(int i = 0; i < tam; array[player[i].getAltura()].altura++, i++);
        // Agora, array[i] contem o numero de elementos menores ou iguais a i.
        for(int i = 1; i < array.length; array[i].altura += array[i - 1].getAltura(), i++);
            movimentacoes += 1;
        // Ordenando
        for(int i = tam - 1; i >= 0; output[array[player[i].getAltura()].altura - 1] = player[i], array[player[i].getAltura()].altura--, i--);
            movimentacoes += 1;
        // Copiando para o array original
        for(int i = 0; i < tam; player[i] = output[i], i++);
            movimentacoes += 1;
    }
}


//CLASSE PRINCIPAL
class coutingSort{
    public static void main(String[] args) throws Exception {
        double exeTime = System.currentTimeMillis();
        Jogador[] player;
        Jogador[] player2 = new Jogador[1000];
        String entrada   = " ";
        int i = 0;
        int contador;
        player = Jogador.ler();
        //INICIANDO A LEITURA DAS ENTRADAS
        entrada = MyIO.readLine();
        for(contador = 0; entrada.equals("FIM") == false; contador++){
            // Construindo Jogadores somente com valores da entrada
            player2[contador] = player[Integer.parseInt(entrada)].clone();
            player2[contador].setCidadeNascimento(player[Integer.parseInt(entrada)].getCidadeNascimento());
            entrada = MyIO.readLine();
        }
       //ORDENANDO
       player2[0].sort(player2, contador);//COUTING 
       player2[0].insercao(player2, contador);//DESEMPATE
       //MOSTRARNDO O ARRAY
       exeTime = System.currentTimeMillis() - exeTime;
       for(int j = 0; j < contador; j++){
            player2[j].imprimir();
       }
		Arq.openWrite("698774_countingSort.txt");
   		String matricula = "698774" + "\t" + player2[0].comparacoes + "\t" + player2[0].movimentacoes + "\t" + exeTime;
		Arq.print(matricula);
		Arq.close();
    }
}
