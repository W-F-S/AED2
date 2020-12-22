
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

        public Jogador(int idN, int alturaN, int pesoN, int anoNascimentoN, String universidadeN, String estadoNascimentoN, String nomeN ){
                id               = idN;
                nome             = nomeN;
                altura           = alturaN;
                peso             = pesoN;
                universidade     = universidadeN;
                anoNascimento    = anoNascimentoN;
                estadoNascimento = estadoNascimentoN;
        }


        /**
         * Funcao para abrir um arquivo e retornar a sua quantidade de linhas
         *
         * @param P1 Jogador[] arranjo de jogadores
         * @param pri seg int posicao a ser trocada
         * 
         * @return P1 arranjo com as posicoes trocadas
         */	           
        public static Jogador[] swap(Jogador[] P1, int pri, int seg){   
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
         * @param: novo Jogador Objeto Jogador a receber a copia;
         */
        public Jogador clone(){ 
                Jogador novo = new Jogador();
                novo.id = this.id;
                novo.nome = this.nome;
                novo.altura = this.altura;
                novo.peso = this.peso;
                novo.universidade = this.universidade;
                novo.cidadeNascimento = this.cidadeNascimento;
		novo.anoNascimento = this.anoNascimento;
                novo.estadoNascimento = this.estadoNascimento;
                return novo;
        }

        /**
         * Funcao para imprimir os dados dos jogadores 
         */
        void imprimir(){
		
                MyIO.println("["+ id + "] ## " 
                                + nome + " ## "
                                + altura + " ## "
                                + peso  + " ## "
                                + anoNascimento + " ## "
                                + universidade + " ## "
                                + cidadeNascimento + " ## "
                                + estadoNascimento + "");

        }

        /**
         * funcao para ler o arquivo .csv e cadastrar os jogadores
	 * @return player Jogador[] arranjos com os jogadores lidos; 
         */
        public Jogador[] ler(){
                int playersNum = getArqLinha("/tmp/players.csv");
                Jogador[] player  = new Jogador[playersNum];
		int total = 0;
		String textos;
                String[] descart = new String[8];
                Arq.openRead("/tmp/players.csv");
                Arq.readLine();
                while(Arq.hasNext() == true){
                        player[total] = new Jogador();
                        textos  = Arq.readLine();
                        descart = textos.split(",", 8);	

                        player[total].id = (Integer.parseInt(descart[0]));
                        player[total].setNome(descart[1]);
                        player[total].setAltura(Integer.parseInt(descart[2]));
                        player[total].setPeso(Integer.parseInt(descart[3]));
                        player[total].setUniversidade(descart[4]);
                        player[total].setAnoNascimento(Integer.parseInt(descart[5]));
                        player[total].setCidadeNascimento(descart[6]);
                        player[total].setEstadoNascimento(descart[7]);

                        if (descart[4].equals("") ){
                                player[total].setUniversidade    ("nao informado"); 
                        } if (descart[6].equals("") ){
                                player[total].setCidadeNascimento("nao informado"); 
                        } if (descart[7].equals("") ){
                                player[total].setEstadoNascimento("nao informado"); 
                        }	
                        total++;
                }      
                Arq.close();
                return player;
        }

        // id,Player,height,weight,collage,born,birth_city,birth_state
        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public int getAltura() {
                return altura;
        }

        public void setAltura(int altura) {
                this.altura = altura;
        }

        public int getPeso() {
                return peso;
        }

        public void setPeso(int peso) {
                this.peso = peso;
        }

        public void setAnoNascimento(int anoNascimento){
                this.anoNascimento = anoNascimento;
        }

        public int getAnoNascimento(){
                return anoNascimento;
        }

        public String getUniversidade() {
                return universidade;
        }

        public void setUniversidade(String universidade) {
                this.universidade = universidade;
        }

        public String getCidadeNascimento() {
                return cidadeNascimento;
        }

        public void setCidadeNascimento(String cidadeNascimento) {
                this.cidadeNascimento = cidadeNascimento;
        }

        public String getEstadoNascimento() {
                return estadoNascimento;
        }
        
	public void setEstadoNascimento(String estadoNascimento) {
                this.estadoNascimento = estadoNascimento;
        }
}


class CelulaJogador{
	public Jogador elemento; 
	public CelulaJogador prox; 
	public static Jogador jogador = new Jogador();//

	public CelulaJogador(){
		this(jogador);
	}

	/**
	 * Construtor da classe.
	 */
	public CelulaJogador(Jogador elemento) {
      		this.elemento = elemento.clone();
      		this.prox = null;
	}
}


class ListaJogador{

        private CelulaJogador primeiro;
	private CelulaJogador ultimo;
        private  int    total;

	public ListaJogador(){
                primeiro = new CelulaJogador();
		ultimo = primeiro;
        }

	/**
	 * funcao para imprir todos os jogadores da lista
	 */
	void imprimirTotal(){
	      int i = 0;
              for(CelulaJogador player = primeiro.prox; player != null; player=player.prox, i++){
		      MyIO.println("["+ i + "] ## "
                    + player.elemento.getNome() + " ## "
                    + player.elemento.getAltura() + " ## "
                    + player.elemento.getPeso()  + " ## "
                    + player.elemento.getAnoNascimento() + " ## "
                    + player.elemento.getUniversidade() + " ## "
                    + player.elemento.getCidadeNascimento() + " ## "
                    + player.elemento.getEstadoNascimento() + " ##");
              }
        }

        /**
	 * funcao para inserir no inicio da lista
	 *
	 * @param jogador Jogador jogador a ser inserido
         */
	void inserirInicio(Jogador jogador){
		CelulaJogador i = new CelulaJogador(jogador);
		i.prox = primeiro.prox;
		primeiro.prox = i;
		total++;
	}

	/**
	 * funcao para inserir no fim da lista
	 *
	 * @param jogador Jogador jogador a ser inserido
	 */
	void inserirFim(Jogador jogador){
		ultimo.prox = new CelulaJogador(jogador);
		ultimo = ultimo.prox;
		total++;
	}

	/**
	 * funcao para inserir em determinada posicao um Jogador
	 *
	 * @param jogador Jogador jogador a ser inserido
	 * @param posicao int posicao onde o jogador vai ser inserido
	 */
	void inserir(Jogador jogador, int posicao){
		CelulaJogador i = primeiro.prox;
		CelulaJogador foo = new CelulaJogador(jogador);
		for(int j=0; (j+1) != posicao; i = i.prox, j++);//movendo o i ate a posicao desejada
		foo.prox = i.prox;
		i.prox = foo;//pulando a celula indesejada
	        foo = null;	
		total++;
	}

	/**
	 * remover uma certa posicao
	 *
	 * @param posicao int posicao onde o jogador vai ser removido
	 * @return resp Jogador jogador removido
	 */
	Jogador remover(int posicao){
		CelulaJogador i = primeiro.prox;
		CelulaJogador teste;
		Jogador resp;
		for(int j=0; (j+1) != posicao; i = i.prox, j++);//movendo i ate a posicao desejada
		teste = i.prox;
		resp = teste.elemento.clone();
		i.prox = i.prox.prox;//pulando a celula indesejada
		teste.prox = null;//desvinculando a celula indesejada
		teste = null;//desvinculando o ponteiro
		total--;
		return resp;
          }

        /**
         * remove e retorna um jogador no final da lista
	 *
	 * @return resp Jogador jogador removido
         */
        Jogador removerFim(){
		Jogador resp = ultimo.elemento.clone();
		CelulaJogador i = primeiro.prox;
		for(; i.prox != ultimo; i = i.prox);
		ultimo = i;
		ultimo.prox = null;
		total--;
	        return resp;
        }

        /**
         * remove e retorna um jogador no inicio da lista
	 *
	 * @return resp Jogador jogador removido
         */
        Jogador removerInicio(){
		Jogador resp = primeiro.prox.elemento.clone();//salvando o jogador
		CelulaJogador tmp = primeiro;
		primeiro = primeiro.prox;
		tmp.prox = null;//desconectando a celula indesejada
		tmp = null;
		total--;
                return resp;
        }
}


class ListaAlocFlex{

	public static void main(String[] args){
	try{
		String lido;
		int n = 0, ent1 = 0, pos = 0;
	        Jogador r = new Jogador();
		Jogador[] tudo = r.ler();
		ListaJogador lista = new ListaJogador();
		lido = MyIO.readLine();
		while( !lido.equals("FIM") ){
			lista.inserirFim(tudo[Integer.parseInt(lido)]);
	         	lido = MyIO.readLine();
		}
		n = MyIO.readInt();
		while(n>0){
			lido = MyIO.readString();
			switch(lido){

				case "II":
					ent1 = MyIO.readInt();
					lista.inserirInicio(tudo[ent1]);
					break;

				case "I*":
					pos = MyIO.readInt();
					ent1 = MyIO.readInt();
					lista.inserir(tudo[ent1], pos);
					break;

				case "IF":
					ent1 = MyIO.readInt();
					lista.inserirFim(tudo[ent1]);
					break;

				case "RI":
			                r = lista.removerInicio();
					MyIO.print("(R) "+r.getNome()+"\n");
					break;

				case "R*":
					ent1 = MyIO.readInt();
					r = lista.remover(ent1);
					MyIO.print("(R) "+r.getNome()+"\n");
					break;

				case "RF":
					r = lista.removerFim();
					MyIO.print("(R) "+r.getNome()+"\n");
					break;
			}
			n--;
		}
		lista.imprimirTotal();
	}catch(Exception e){
		System.out.print("\nErro: \n");
		 e.printStackTrace();
	}}
}
