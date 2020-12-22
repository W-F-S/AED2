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

        //////////////////////////////////////////////////////////FUNCOES AUXILIARES

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
         * Function para imprimir os dados dos jogadores 
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
         * function para ler o arquivo .csv e cadastrar os jogadores
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

class PilhaJogador{
        private  Jogador[] player;
        private  int    total;

        public PilhaJogador(){
                this(1000);
        }

        public PilhaJogador(int x){
                player = new Jogador[x];
                total = 0;
        }

	void imprimirTotal(){
              for(int i = 0; i < total; i++ ){
                MyIO.println("["+ i + "] ## "
                    + player[i].getNome() + " ## "
                    + player[i].getAltura() + " ## "
                    + player[i].getPeso()  + " ## "
                    + player[i].getAnoNascimento() + " ## "
                    + player[i].getUniversidade() + " ## "
                    + player[i].getCidadeNascimento() + " ## "
                    + player[i].getEstadoNascimento() + " ##");
              }
        }

	public int getTamanho(){
                return total;
        }

        /**
	 * insere um jogador no topo da pilha
         */
	void inserir(Jogador jogador){
		player[total] = jogador.clone();
		total++;    
	}

        /*
         * remove e retorna um jogador no final do arranjo
         */
        Jogador remover(){	
		return player[--total].clone();
        }
}


class PilhaAlocSeq{
	public static void main(String[] args){
	try{
		String lido;
		int n = 0, ent1 = 0;
	        Jogador r = new Jogador();
		Jogador[] tudo = r.ler();
		PilhaJogador pilha = new PilhaJogador();

		lido = MyIO.readLine();
		while( !lido.equals("FIM") ){
			pilha.inserir(tudo[Integer.parseInt(lido)].clone());
	         	lido = MyIO.readLine();
		}
		n = MyIO.readInt();
		while((n)>0){
			lido = MyIO.readString();
			switch(lido){
				case "I":
					ent1 = MyIO.readInt();
					pilha.inserir(tudo[ent1]);
					break;
				
				case "R":
					r = pilha.remover();
					MyIO.print("(R) "+r.getNome()+"\n");
					break;
			}
			n--;
		}
		pilha.imprimirTotal();
	}catch(Exception e){
		System.out.print("\nErro: \n");
		 e.printStackTrace();
	}}
}
