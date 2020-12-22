
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





class No{
	public Jogador elemento;
	public No prox;
	
	public No(){
		elemento = null;
		prox = null;
	}
	
	public No(Jogador x){
		prox = null;
		elemento = x.clone();
	}

}


class No2{
	public No primeiro;
	public No ultimo;
	public int comparacoes = 0;
	

	public No2(){
		primeiro = new No();
		ultimo = primeiro;
	}

	public void inserirFim(Jogador x){
		ultimo.prox = new No(x); 
		ultimo = ultimo.prox;
	}


	public void mostrar(){
		No i = primeiro.prox;
		for(; i!= null; i = i.prox){
			i.elemento.imprimir();
		}
	}

	public boolean pesquisar(String x){
		boolean resp = false;
		No i = primeiro.prox;
		comparacoes += 2;
		for(; i != null && resp == false; i = i.prox){
			comparacoes += 3;
			if(i.elemento.getNome().equals(x)){
				resp = true;
			}
		}
		return resp;
	}
}

class HashIndireta{
	private No2 lista[] = new No2[25];
	public int comparacoes = 0;

	public HashIndireta(){	
		for(int i = 0; i < 25; i++){
			lista[i] = new No2();
		}
	}
	
	public int h(int x){
		return x % 25;
	}

	public void inserir(Jogador x){
		int hash = h(x.getAltura());
		lista[hash].inserirFim(x);
	}

	public boolean imprimir(String x){
		boolean resp = false;
		for(int i = 0; i < 25; i++){
			lista[i].pesquisar(x);
		}
		return resp;
	}

	public void mostrar(){
		for(int i = 0; i < 25; i++){
			MyIO.println("-------lista " + i + " --------");
			lista[i].mostrar();
		}
	}

	public boolean pesquisar(String x){
		boolean resp = false;
		comparacoes++;
		for(int i = 0; i < 25 && resp == false; i++){
			if(lista[i].pesquisar(x)){
				resp = true;
			}
			comparacoes = 2 + lista[i].comparacoes + comparacoes;
		}
		
		return resp;
	}
}

class HashJogador{

	public static void main(String[] args){
		String lido;
		double time = 0;
	        Jogador r = new Jogador();
		Jogador[] tudo = r.ler();
		HashIndireta lista = new HashIndireta();

		lido = MyIO.readLine();
		while( !lido.equals("FIM") ){
			lista.inserir(tudo[Integer.parseInt(lido)]);
	         	lido = MyIO.readLine();
		}	
		
		lido = MyIO.readLine();
		time = System.currentTimeMillis();
		while( !lido.equals("FIM") ){
			if(lista.pesquisar(lido))
				MyIO.println(lido + " SIM");
			else
				MyIO.println(lido + " NAO");

	         	lido = MyIO.readLine();
		}	
		time = (System.currentTimeMillis() - time) / 1000;
		//fazendo arquivo de log
		Arq.openWrite("698774_hashIndireta.txt");
		String matricula = "698774" + "\t" + time + "\t" + lista.comparacoes;
		Arq.print(matricula);
		Arq.close();
	}
}
