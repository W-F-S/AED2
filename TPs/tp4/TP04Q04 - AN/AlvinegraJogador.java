import java.util.Scanner;

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

		MyIO.println("["+ id + " ## " 
				+ nome + " ## "
				+ altura + " ## "
				+ peso  + " ## "
				+ anoNascimento + " ## "
				+ universidade + " ## "
				+ cidadeNascimento + " ## "
				+ estadoNascimento + "]");

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

//-------------------------------------------------------------------------------------------------------------------------------------------------------
/**
 * NoAN da arvore binaria
 * @author Max do Val Machado
 */
class NoAN{
	public boolean cor;
	public String elemento;
	public NoAN esq, dir;
	public NoAN (){
		this(null);
	}
	public NoAN (String elemento){
		this(elemento, false, null, null);
	}
	public NoAN (String elemento, boolean cor){
		this(elemento, cor, null, null);
	}
	public NoAN (String elemento, boolean cor, NoAN esq, NoAN dir){
		this.cor = cor;
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
	}
}
//--------------------------------------------------------------------------------------------------------------------------------------------------------

/**
 * Arvore de arvore
 * @author Max do Val Machado
 */
class Alvinegra {
	public int comparacoes = 0;

	private NoAN raiz; // Raiz da arvore.

	/**
	 * Construtor da classe.
	 */
	public Alvinegra() {
		raiz = null;
	}

	/**
	 * Metodo  iterativo para pesquisar elemento.
	 * @param elemento Elemento que sera procurado.
	 * @return <code>true</code> se o elemento existir,
	 * <code>false</code> em caso contrario.
	 */
	public boolean pesquisar(String elemento) {
		System.out.print(elemento + " raiz ");
		return pesquisar(elemento, raiz);
	}

	/**
	 * Metodo  recursivo para pesquisar elemento.
	 * @param elemento Elemento que sera procurado.
	 * @param i NoAN em analise.
	 * @return <code>true</code> se o elemento existir,
	 * <code>false</code> em caso contrario.
	 */
	private boolean pesquisar(String elemento, NoAN i) {
		boolean resp;
		comparacoes++;
		if (i == null){
			System.out.print("NAO\n");
			resp = false;
		} else if (elemento.equals(i.elemento)) {
			comparacoes++;
			System.out.print("SIM\n");
			resp = true;
		} else if (elemento.compareTo(i.elemento) < 0 ) {
			comparacoes++;
			System.out.print("esq ");
			resp = pesquisar(elemento, i.esq);
		} else {
			comparacoes++;
			System.out.print("dir ");
			resp = pesquisar(elemento, i.dir);
		}
		return resp;
	}

	/**
	 * Metodo  iterativo para inserir elemento.
	 * @param elemento Elemento a ser inserido.
	 * @throws Exception Se o elemento existir.
	 */
	public void inserir(String elemento) throws Exception {
		comparacoes++;
		if(raiz == null){
			raiz = new NoAN(elemento, false);
		} else if (raiz.esq == null && raiz.dir == null){
			comparacoes += 2;
			if (raiz.elemento.compareTo(elemento) > 0){
				raiz.esq = new NoAN(elemento, true);
			} else {
				raiz.dir = new NoAN(elemento, true);
			}
		} else if (raiz.esq == null){
			comparacoes += 2;
			if(raiz.elemento.compareTo(elemento)  > 0){
				raiz.esq = new NoAN(elemento);
			} else if (raiz.dir.elemento.compareTo(elemento) > 0){
				comparacoes++;
				raiz.esq = new NoAN(raiz.elemento);
				raiz.elemento = elemento;
			} else {
				raiz.esq = new NoAN(raiz.elemento);
				raiz.elemento = raiz.dir.elemento;
				raiz.dir.elemento = elemento;
			}
			raiz.esq.cor = raiz.dir.cor = false;
		} else if (raiz.dir == null){
			comparacoes+=2;
			if(raiz.elemento.compareTo(elemento) < 0){
				raiz.dir = new NoAN(elemento);
			} else if (raiz.esq.elemento.compareTo(elemento) < 0){
				comparacoes++;
				raiz.dir = new NoAN(raiz.elemento);
				raiz.elemento = elemento;
			} else {
				raiz.dir = new NoAN(raiz.elemento);
				raiz.elemento = raiz.esq.elemento;
				raiz.esq.elemento = elemento;
			}
			raiz.esq.cor = raiz.dir.cor = false;
		} else {
			inserir(elemento, null, null, null, raiz);
		}
		raiz.cor = false;
	}

	private void balancear(NoAN bisavo, NoAN avo, NoAN pai, NoAN i){
		comparacoes++;
		if(pai.cor == true){
			comparacoes++;
			if(pai.elemento.compareTo(avo.elemento) > 0){ // rotacao a esquerda ou direita-esquerda
				comparacoes++;
				if(i.elemento.compareTo(pai.elemento) > 0){
					avo = rotacaoEsq(avo);
				} else {
					avo = rotacaoDirEsq(avo);
				}
			} else { // rotacao a direita ou esquerda-direita
				comparacoes++;
				if(i.elemento.compareTo(pai.elemento) < 0){
					avo = rotacaoDir(avo);
				} else {
					avo = rotacaoEsqDir(avo);
				}
			}
			comparacoes++;
			if (bisavo == null){
				raiz = avo;
			} else {
				comparacoes++;
				if(avo.elemento.compareTo(bisavo.elemento) < 0){
					bisavo.esq = avo;
				} else {
					bisavo.dir = avo;
				}
			}
			avo.cor = false;
			avo.esq.cor = avo.dir.cor = true;
		}
	}

	/**
	 * Metodo recursivo para inserir elemento.
	 * @param elemento Elemento a ser inserido.
	 * @param avo NoAN em analise.
	 * @param pai NoAN em analise.
	 * @param i NoAN em analise.
	 * @throws Exception Se o elemento existir.
	 */
	private void inserir(String elemento, NoAN bisavo, NoAN avo, NoAN pai, NoAN i) throws Exception {
		if (i == null) {
			comparacoes++;
			if(elemento.compareTo(pai.elemento) < 0){
				comparacoes++;
				i = pai.esq = new NoAN(elemento, true);
			} else {
				i = pai.dir = new NoAN(elemento, true);
			}
			comparacoes++;
			if(pai.cor == true){
				balancear(bisavo, avo, pai, i);
			}
		} else {
			comparacoes++;
			if(i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true){
				i.cor = true;
				i.esq.cor = i.dir.cor = false;
				comparacoes++;
				if(i == raiz){
					i.cor = false;
				}else if(pai.cor == true){
					balancear(bisavo, avo, pai, i);
				}
			}
			comparacoes++;
			if (elemento.compareTo(i.elemento) < 0) {
				inserir(elemento, avo, pai, i, i.esq);
			} else if (elemento.compareTo(i.elemento) > 0) {
				comparacoes++;
				inserir(elemento, avo, pai, i, i.dir);
			} else {
				throw new Exception("Erro inserir (elemento repetido)!");
			}
		}
	}

	private NoAN rotacaoDir(NoAN no) {//rotacao simples
		NoAN noEsq = no.esq;
		NoAN noEsqDir = noEsq.dir;
		noEsq.dir = no;
		no.esq = noEsqDir;
		return noEsq;
	}

	private NoAN rotacaoEsq(NoAN no) {//rotacao simples
		NoAN noDir = no.dir;
		NoAN noDirEsq = noDir.esq;
		noDir.esq = no;
		no.dir = noDirEsq;
		return noDir;
	}

	private NoAN rotacaoDirEsq(NoAN no) {//rotacao dupla
		no.dir = rotacaoDir(no.dir);
		return rotacaoEsq(no);
	}

	private NoAN rotacaoEsqDir(NoAN no) {//rotacao dupla
		no.esq = rotacaoEsq(no.esq);
		return rotacaoDir(no);
	}
}

class AlvinegraJogador{
	public static void main(String[] args){try{
		double time = 0;
		Scanner scan = new Scanner(System. in);
		String lido;
		Jogador r = new Jogador();
		Alvinegra arvore = new Alvinegra();
		Jogador[] lista = r.ler();//lendo todos os jogadores

		//inserindo jogadores
		lido = MyIO.readString();
		while(!lido.equals("FIM")){
			arvore.inserir(lista[Integer.parseInt(lido)].getNome());
			lido = MyIO.readString();
		}

		//fazendo a pesquisa
		lido = MyIO.readLine();
		time = System.currentTimeMillis();
		while(!lido.equals("FIM")){
			arvore.pesquisar(lido);
			lido = MyIO.readLine();
		}

		//fazendo o arquivo de log
		time = (System.currentTimeMillis() - time);
		Arq.openWrite("698774_alvinegra.txt");
		String matricula = "698774" + "\t" + time + "\t" + arvore.comparacoes;
		Arq.print(matricula);
		Arq.close();
	}catch(Exception e){
		System.out.print(e);
	}}
}



