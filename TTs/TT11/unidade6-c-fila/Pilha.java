/**
 * Pilha dinamica
 * 
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class Pilha {
	private Celula topo;

	/**
	 * Construtor da classe que cria uma fila sem elementos.
	 */
	public Pilha() {
		topo = null;
	}

	/**
	 * Insere elemento na pilha (politica FILO).
	 * 
	 * @param x int elemento a inserir.
	 */
	public void inserir(int x) {
		Celula tmp = new Celula(x);
		tmp.prox = topo;
		topo = tmp;
		tmp = null;
	}

	/**
	 * Remove elemento da pilha (politica FILO).
	 * 
	 * @return Elemento removido.
	 * @trhows Exception Se a sequencia nao contiver elementos.
	 */
	public int remover() throws Exception {
		if (topo == null) {
			throw new Exception("Erro ao remover!");
		}
		int resp = topo.elemento;
		Celula tmp = topo;
		topo = topo.prox;
		tmp.prox = null;
		tmp = null;
		return resp;
	}

	/**
	 * Mostra os elementos separados por espacos, comecando do topo.
	 */
	public void mostrar() {
		System.out.print("[ ");
		for (Celula i = topo; i != null; i = i.prox) {
			System.out.print(i.elemento + " ");
		}
		System.out.println("] ");
	}

	public int getSoma() {
		return getSoma(topo);
	}

	private int getSoma(Celula i) {
		int resp = 0;
		if (i != null) {
			resp += i.elemento + getSoma(i.prox);
		}
		return resp;
	}

	public int getMax() {
		int max = topo.elemento;
		for (Celula i = topo.prox; i != null; i = i.prox) {
			if (i.elemento > max)
				max = i.elemento;
		}
		return max;
	}

	public void mostraPilha() {
		mostraPilha(topo);
	}

	private void mostraPilha(Celula i) {
		if (i != null) {
			mostraPilha(i.prox);
			System.out.println("" + i.elemento);
		}
	}
    
     public void setPrimeiro(Celula novo){
        topo = novo;        
     }

     public int tamanho(){
        Celula tmp = topo;
        int resp = 0;
        while(tmp!=null){
            tmp = tmp.prox;
            resp++;
        }
        tmp = null;
        return resp;

     }

     /**
      * retorna uma fila flexivel que contem os elemento da pilha flexivel 
      * onde os dados estao disponiveis por ordem de inser~cao da pilha
     * @param topo Celula celula pilha que sera' analisada
      * @return fila Celula fila(endere~co) contendo os dados
      */
     public Celula toFila(Celula pilha){
         int n = tamanho();
         Celula fila = new Celula(); //no' cabe~ca da nova fila
         Celula ultimo = fila;
         Celula tmp = pilha;
         n--;
         for(int j = n; j>=0; j--){ 
             for(int f = 0; f<(n) ; f++, tmp = tmp.prox);
             ultimo.prox = new Celula(tmp.elemento);
             ultimo = ultimo.prox;        
             tmp =pilha;
             n--;
         }
         tmp = null;
         return fila;
     } 

     public Celula toFila(){
         return toFila(topo);
     }   
}
