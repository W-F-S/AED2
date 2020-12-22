

class Jogador {
        private  int      id;
        private  String nome;
        private  int    altura;
        private  int    peso;
        private  int    anoNascimento;
        private  String universidade;
        private  String cidadeNascimento;
        private  String estadoNascimento;

 /////////////////////////////////////////////////////////////////CONSTRUTORES
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

//-------------------------------------------------------------------------------------------------------------------------------------------------------------------

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

//--------------------------------------------------------------------------------------------------------------------------------------------------------------

class ListaJogador{
        private CelulaJogador primeiro;
	private CelulaJogador ultimo;

	public ListaJogador(){
                primeiro = new CelulaJogador();
		ultimo = primeiro;
        }

	/**
	 * Metodo para inserir no fim da lista
	 * @param jogador Jogador jogador a ser inserido
	 */
	void inserir(Jogador jogador){
		ultimo.prox = new CelulaJogador(jogador);
		ultimo = ultimo.prox;
	}

	/**
	 * Metodo interativo para pesquisar um nome na lista
	 * @param x string a ser pesquisada
	 * @return <code> true </code> caso a string seja encontrada 
	 * @return <code> false </code> caso a string nao seja encontrada
	 */
	public boolean pesquisar(String x){
		boolean resp = false;
		CelulaJogador i = new CelulaJogador();
		i = primeiro.prox;
		for(; i != null && !resp; i = i.prox){
			if(i.elemento.getNome().equals(x) ){
				resp = true;
			        System.out.println(x + " SIM");
			}
		}

		return resp;
	}
}

//--------------------------------------------------------------------------

class No {
	public Jogador elemento; // Conteudo do no.
	public No esq, dir;  // Filhos da esq e dir.

	//construtor da class
	//@param elemento Jogador
	public No(Jogador elemento) {
		this(elemento, null, null);
	}

	public No(Jogador elemento, No esq, No dir) {
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
	}
}

//--------------------------------------------------------------------------

class ArvoreBinaria {
	private No raiz; // Raiz da arvore.
	public int comparacoes = 0;
	

	/**
	 * Construtor da classe.
	 */
	public ArvoreBinaria() {
		raiz = null;
	}

	/**
	 * Metodo iterativo para pesquisar elemento.
	 * @param x Elemento que sera procurado.
	 * @return <code>true</code> se o elemento existir,
	 * <code>false</code> em caso contrario.
	 */
	public boolean pesquisar(String x) {
		System.out.print(x + " raiz ");
		return pesquisar(x, raiz);
	}

	/**
	 * Metodo recursivo para pesquisar elemento.
	 * @param x Elemento que sera procurado.
	 * @param i No em analise.
	 * @return <code>true</code> se o elemento existir,
	 * <code>false</code> em caso contrario.
	 */
	private boolean pesquisar(String x, No i) {
		boolean resp;
		if (i == null) {//Jogador nao existe
			comparacoes++;
			System.out.print("NAO\n");
			resp = false;

		} else if (x.equals(i.elemento.getNome())) {//Jogador existe
			comparacoes++;
			System.out.print("SIM\n");
			resp = true;

		} else if (x.compareTo(i.elemento.getNome()) < 0) {//arvore a esquerda
			comparacoes++;	
			System.out.print("esq ");
			resp = pesquisar(x, i.esq);

		} else {//arvore a direita
			System.out.print("dir ");
			resp = pesquisar(x, i.dir);
		}
		return resp;
	}

	/**
	 * Metodo interativo para inserir jogadores
	 * @param x Elemento a ser inserido.
	 * @throws Exception Se o elemento existir
	 */
	public void inserir(Jogador x) {
		raiz = inserir(x, raiz);
	}

	/**
	 * Metodo recursivo para inserir jogadores
	 * @param x Elemento a ser inserido.
	 * @param i No em analise.
	 * @return No em analise, alterado ou nao.
	 * @throws Exception Se o elemento existir.
	 */
	private No inserir(Jogador x, No i) {
		if (i == null) {//insere caso nao exista
			comparacoes++;
			i = new No(x);
		} else if (x.getNome().compareTo(i.elemento.getNome()) < 0) {//proxima arvore a esquerda
			comparacoes++;
			i.esq = inserir(x, i.esq);
		} else if (x.getNome().compareTo(i.elemento.getNome()) > 0) {//proxima arvore a direita
			comparacoes++;
			i.dir = inserir(x, i.dir);
		}
		return i;
	}
}

//--------------------------------------------------------------------------------------------------------------------------------------------------------------

class TabelaT2{
	private Jogador[] t2 = new Jogador[9];
	
	public TabelaT2(){
		for(int i = 0; i < 9; i++){
			t2[i] = new Jogador();
		}
	}

	//Fazer a hash com a altura do jogador
	private int h(int x){
		return x % 9;
	}

	//Fazer a ReHash com a altura do jogador
	private int h2(int x){
		return ++x % 9;
	}

	/**
	 * Metodo interativo para inserir um Jogador na ReHash
	 * @param x jogador a ser inserido 
	 */
	public void inserir(Jogador x){
		int hash = h(x.getAltura());
		if(t2[hash].getId() < 0){
			t2[hash] = x.clone();
		} else {
			hash = h2(x.getAltura());
			if(t2[hash].getId() < 0){
				t2[hash] = x.clone();
			}
		}
	}

        /**
         * Metodo interativo para pesquisar um jogador na tabela
         * @param x nome do jogador a ser pesquisado
         * @return false caso nao encontrado
         * @return true caso encontrado
         */
	public boolean pesquisar(String x){
		boolean resp = false;
//MyIO.println("\n--------------------------------Procurando t2: ");
		for(int i = 0; i < 9; i++){
   //             	t2[i].imprimir();
			if(t2[i].getNome().equals(x)){
				i = 9;
				resp  = true;
			        MyIO.println(x + " SIM");
			}
		}
		return resp;
	}
}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------

class TabelaT1{

	private Jogador[] t1 = new Jogador[11];
	private ArvoreBinaria arvore = new ArvoreBinaria();
	private TabelaT2 tabela2 = new TabelaT2();
	private ListaJogador lista = new ListaJogador();
	
	public TabelaT1(){
		for(int i = 0; i < 11; i++){
			t1[i] = new Jogador();
		}
	}

	public int h(int x){
		return x % 11;
	}

	public int h2(int x){
		return x % 3;
	}

	/**
	 * Metodo interativo para inserir um jogador
	 * @param x jogador a ser inserido
	 */
	public void inserir(Jogador x){
		int hash = h(x.getAltura());
	
		if(t1[hash].getId() < 0){
			t1[hash] = x.clone();
		}else{
			hash = h2(x.getAltura());//verificando em qual estrutura inserir
			if(hash == 0){
				tabela2.inserir(x);
			} else if (hash == 1){
				lista.inserir(x);
			} else {
				arvore.inserir(x);
			}
		}
	}


	/**
	 * Metodo interativo para pesquisar um nome nas estruturas
	 * @param x string a ser pesquisada
	 * @return <code> true </code> caso a string seja encontrada 
	 * @return <code> false </code> caso a string nao seja encontrada
	 */
	public boolean pesquisar(String x){
		boolean resp = false;

		for(int i = 0; i < 11; i++){
			if(t1[i].getNome().equals(x)){
				i = 11;
				resp = true;
			        MyIO.println(x + " SIM");
			}
		}
		
		if(!resp) {
		        resp = tabela2.pesquisar(x);
			if(!resp){
				resp = lista.pesquisar(x);
				if(!resp){
					resp = arvore.pesquisar(x);
				}
			}
		}
		return resp;
	}
}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------

class Doidona{
	public static void main(String[] args){
		String lido;
	        Jogador r = new Jogador();
		Jogador[] tudo = r.ler();
		TabelaT1 lista = new TabelaT1();

		lido = MyIO.readLine();
		while( !lido.equals("FIM") ){
			lista.inserir(tudo[Integer.parseInt(lido)]);
	         	lido = MyIO.readLine();
		}	
		
		lido = MyIO.readLine();
		while( !lido.equals("FIM") ){
			lista.pesquisar(lido);
	         	lido = MyIO.readLine();
		}	
	}
}
