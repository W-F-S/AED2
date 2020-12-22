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
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
class No {
	public char elemento;
	public int tamanho = 255;//ASCII
	public No[] prox;//numero de filhos
	public boolean folha;

	public No (){
		this(' ');
	}

	public No (char elemento){
		this.elemento = elemento;
		prox = new No [tamanho];
		for (int i = 0; i < tamanho; i++) prox[i] = null;//setando cada um como null pois saberemos se esta vazio
		folha = false;
	}
}
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class ArvoreTrie {
	private No raiz;
	public int comparacoes = 0;

	public ArvoreTrie(){
		raiz = new No();
	}

	public void inserir(String s) throws Exception {
		inserir(s, raiz, 0 );
	}

	/**
	 * Metodo recursivo para inserir
	 * @param s String a ser inserida
	 * @param no raiz da arvore
	 * @param i posicao inicial da string
	 */
	private void inserir(String s, No no, int i) throws Exception {
		if(no.prox[s.charAt(i)] == null){//podemos inserir pois a posicao destinada para aquela letra esta vazia
			no.prox[s.charAt(i)] = new No(s.charAt(i));
			if(i == s.length() - 1){//transformamos em folha esta insercao pois a string acabou
				no.prox[s.charAt(i)].folha = true;
			}else{
				inserir(s, no.prox[s.charAt(i)], i + 1);//proxima letra
			}
		} else if (no.prox[s.charAt(i)].folha == false && i < s.length() - 1){//nao e preciso inserir pois a letra ja existe
			inserir(s, no.prox[s.charAt(i)], i + 1);

		} else {
		} 
	}

	public boolean pesquisar(String s) throws Exception {
		System.out.print(s);
		return pesquisar(" "+s, raiz, 0);
	}

	/**
	 * Metodo recursivo para pesquisar na arvore
	 * @param s String a ser analisada
	 * @param no raiz da arvore a ser analisada
	 * @param i posicao inicial
	 * @return <code>true</code> caso s for encontrado
	 * @return <code>false</code> caso s nao for encontrado
	 */
	public boolean pesquisar(String s, No no, int i) throws Exception {
		boolean resp;
		comparacoes++;
		if(no.prox[s.charAt(i)] == null){
			System.out.println(" NAO");
			resp = false;
		} else if(i == s.length() - 1){
			comparacoes++;
			System.out.println(" SIM");
			resp = (no.prox[s.charAt(i)].folha == true);
		} else if(i < s.length() - 1 ){
			comparacoes++;
			resp = pesquisar(s, no.prox[s.charAt(i)], i + 1);
		} else {
			throw new Exception("Erro ao pesquisar!");
		}
		return resp;
	}

	public void mostrar()throws Exception{
		mostrar("", raiz);
	}

	/**
	 * Metodo recursivo para mostrar a arvore 
	 * @param s String a ser analisada
	 * @param no raiz da arvore a ser analisada
	 */
	private void mostrar(String s, No no) throws Exception{
		if(no.folha == true){
			System.out.println(s + no.elemento);
		} else {
			for(int i = 0; i < no.prox.length; i++){
				if(no.prox[i] != null){
					mostrar(s + no.elemento, no.prox[i]);
				}
			}
		}
	}

	public void inserir2(ArvoreTrie nova)throws Exception{
		inserir2("", nova.raiz);
	}

	/**
	 * Metodo recursivo para inserir uma arvore em outra
	 * @param s String a ser inserida
	 * @param no raiz da arvore a ser copiada 
	 */
	private void inserir2(String s, No no) throws Exception{
		if(no.folha == true){
			inserir(s + no.elemento);
		} else {
			for(int i = 0; i < no.prox.length; i++){
				if(no.prox[i] != null){
					inserir2(s + no.elemento, no.prox[i]);
				}
			}
		}
	}

	public void merge(ArvoreTrie v1, ArvoreTrie v2)throws Exception{
		inserir2(v1);
		inserir2(v2);
	}
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class TrieJogador{

	public static void main(String[] args){try{
		double time = 0;
		Scanner scan = new Scanner(System. in);
		String lido;
		Jogador r = new Jogador();
		Jogador[] lista = r.ler();//lendo todos os jogadores

		ArvoreTrie av1    = new ArvoreTrie();
		ArvoreTrie av2    = new ArvoreTrie();
		ArvoreTrie result = new ArvoreTrie();

		//inserindo jogadores
		time = System.currentTimeMillis();
		lido = scan.nextLine();
		while(!lido.equals("FIM")){
			av1.inserir(lista[Integer.parseInt(lido)].getNome());
			System.out.println(lido+"\t"+ lista[Integer.parseInt(lido)].getNome());
			lido = scan.nextLine();
		}

		lido = scan.nextLine();
		while(!lido.equals("FIM")){
			av2.inserir(lista[Integer.parseInt(lido)].getNome());
			System.out.println(lido+"\t"+ lista[Integer.parseInt(lido)].getNome());
			lido = scan.nextLine();
		}

		result.merge(av1, av2);
		//fazendo as pesquisas
		lido = scan.nextLine();
		while(!lido.equals("FIM")){
			result.pesquisar(lido);
			lido = scan.nextLine();
		}
		time = ((System.currentTimeMillis() - time) / 1000);
		//fazendo arquivo de log
		Arq.openWrite("698774_arvoreTrie.txt");
		String matricula = "698774" + "\t" + time + "\t" + result.comparacoes;
		Arq.print(matricula);
		Arq.close();
	}catch(Exception e){
		System.out.print(e);
	}}
}


