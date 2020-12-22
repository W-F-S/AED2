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
//--------------------------------------------------------------------------


class No2 {
	public String elemento; // Conteudo do no.
	public No2 esq; // No da esquerda.
	public No2 dir; // No da direita.

	/**
	 * Construtor da classe.
	 * @param elemento Conteudo do no.
	 */
	No2(String elemento) {
		this.elemento = elemento;
		this.esq = this.dir = null;
	}

	/**
	 * Construtor da classe.
	 * @param elemento Conteudo do no.
	 * @param esq No2 da esquerda.
	 * @param dir No2 da direita.
	 */
	No2(String elemento, No2 esq, No2 dir) {
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
	}
}






class No {
	public int elemento; // Conteudo do no.
	public No esq; // No da esquerda.
	public No dir; // No da direita.
	public No2 outro;

	/**
	 * Construtor da classe.
	 * @param elemento Conteudo do no.
	 */
	No(int elemento) {
		this.elemento = elemento;
		this.esq = this.dir = null;
		this.outro = null;
	}

	/**
	 * Construtor da classe.
	 * @param elemento Conteudo do no.
	 * @param esq No da esquerda.
	 * @param dir No da direita.
	 */
	No(int elemento, No esq, No dir) {
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
		this.outro = null;
	}
}

/**
 * Arvore de arvore
 * @author Max do Val Machado
 */
class ArvoreArvore {
	private No raiz; // Raiz da arvore.
	private int altura;
	public int comparacoes = 0;


	/**
	 * Construtor da classe.
	 */
	public ArvoreArvore() throws Exception{
		raiz = null;
		inserir(7);
		inserir(3);
		inserir(11);
		inserir(1);
		inserir(5);             
		inserir(9);
		inserir(12);            
		inserir(0);
		inserir(2);             
		inserir(4);
		inserir(6);            
		inserir(8);
		inserir(10);					
		inserir(13);
		inserir(14);	
	}

	/**
	 * Metodo publico iterativo para pesquisar elemento.
	 * @param elemento Elemento que sera procurado.
	 * @return <code>true</code> se o elemento existir,
	 * <code>false</code> em caso contrario.
	 */
	public void pesquisar(String elemento){
		System.out.print(elemento + " raiz ");
		comparacoes++;
		if(pesquisar(raiz, elemento))
			System.out.print("SIM\n");	
		else 
			System.out.print("NAO\n");
	}

	private boolean pesquisar(No no, String x) {
		boolean resp = false;
		comparacoes++;
		if(no != null){ 

			resp = pesquisarSegundaArvore(no.outro, x);
			comparacoes++;
			if(!resp){
				System.out.print("esq ");
				resp = pesquisar(no.esq, x);	
				comparacoes++;
				if(!resp){
					System.out.print("dir ");
					resp = pesquisar(no.dir, x);
				}
			}
		} 
		return resp;
	}

	private boolean pesquisarSegundaArvore(No2 no, String x) {
		boolean resp = false;
		comparacoes++;
		if (no != null) { 
			comparacoes++;
			if(no.elemento.equals(x)){
				resp = true;
			}else{
				System.out.print("ESQ ");
				resp = pesquisarSegundaArvore(no.esq, x);
				comparacoes++;
				if(!resp){
					System.out.print("DIR ");
					resp = pesquisarSegundaArvore(no.dir, x);
				}
			}
		}
		return resp;
	}

	public void inserir(Jogador x)throws Exception{
		raiz = inserir(raiz, (x.getAltura() % 15), x.getNome());

	}

	public void inserir(int x)throws Exception{
		raiz = inserir(raiz, x, null);
	}

	private No inserir(No i, int altura, String elemento)throws Exception{
		if(i == null){
			comparacoes++;
			i = new No (altura);
		} else if (altura < (i.elemento)){
			comparacoes++;
			i.esq = inserir(i.esq, altura, elemento);
		} else if (altura > (i.elemento)){
			comparacoes++;
			i.dir = inserir(i.dir, altura, elemento);
		} else if (altura == (i.elemento)){
			comparacoes++;
			i.outro = inserirSegunda(i.outro, elemento);
		}
		return i;
	}

	private No2 inserirSegunda(No2 no, String x)throws Exception{
		if(no == null){
			comparacoes++;
			no = new No2(x);
		} else if (x.compareTo(no.elemento) < 0) { 
			comparacoes++;
			no.esq = inserirSegunda(no.esq, x);
		} else if (x.compareTo(no.elemento) > 0){ 
			comparacoes++;
			no.dir = inserirSegunda(no.dir, x);
		} else {
			throw new Exception("Erro inserir (elemento repetido)!");
		}
		return no;
	}
}

class ArvoreDeArvores{
	public static void main(String[] args){try{
		double time = 0;
		Scanner scan = new Scanner(System. in);
		String lido;
		Jogador r = new Jogador();
		ArvoreArvore arvore = new ArvoreArvore();
	
		Jogador[] lista = r.ler();//lendo todos os jogadores
		//inserindo os jogadore
		lido = MyIO.readString();
		while(!lido.equals("FIM")){
			arvore.inserir(lista[Integer.parseInt(lido)].clone());
			lido = MyIO.readString();
		}

		//fazendo as pesquisas
		lido = MyIO.readLine();
		time = System.currentTimeMillis();
		while(!lido.equals("FIM")){
			arvore.pesquisar(lido);
			lido = MyIO.readLine();
		}

		//fazendo o arquivo de log
		time = (System.currentTimeMillis() - time);
		Arq.openWrite("698774_arvoreArvore.txt");
		String matricula = "698774" + "\t" + time + "\t" + arvore.comparacoes;
		Arq.print(matricula);
		Arq.close();
	}catch(Exception e){
		System.out.print(e);
	}}
}







