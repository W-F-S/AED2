/**
 * Fila dinamica
 * @author walker
 * @version 3 13/08/2020
 */
public class Fila {
	private Celula primeiro;
	private Celula ultimo;


	/**
	 * Construtor da classe que cria uma fila sem elementos (somente no cabeca).
	 */
	public Fila() {
		primeiro = new Celula();
		ultimo = primeiro;
	}

	/**
	 * Insere elemento na fila (politica FIFO).
	 * @param x int elemento a inserir.
	 */
	public void inserir(int x) {
		ultimo.prox = new Celula(x);
		ultimo = ultimo.prox;
	}

	/**
	 * Remove elemento da fila (politica FIFO).
	 * @return Elemento removido.
	 * @trhows Exception Se a fila nao tiver elementos.
	 */
	int remover() {//throws Exception
		int resp = primeiro.elemento;
        try{
            Celula tmp = primeiro;
		    primeiro = primeiro.prox;
            tmp.prox = null;
            tmp = null;
        } catch(NullPointerException e) {
        
            System.out.print("\nErro ao remover!\n");
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
		return resp;
	}

    /**
     * remove fisicamente um elemento da fila
     * @return resp int elemento removido;
     */
    public int removerFisicamente(){
        int resp = 0;
        if(ultimo == primeiro){
            System.out.print("ERRO");
        }
        Celula tmp = primeiro; 
        primeiro.prox = primeiro.prox.prox;
        resp = primeiro.elemento;
        tmp.prox = null;//desvinculando o elemento deletado e a tmp
        tmp = null;//apontando toda a tmp null
        return resp;
    }

    /**
     * Mostra os elementos separados por espacos.
     */
     public void mostrar() {
  	System.out.print("[ ");		
      	     for(Celula i = primeiro.prox; i != null; i = i.prox) {
		System.out.print(i.elemento + " ");
	     }	
	     System.out.println("] ");
	}

    /**
     * pega o maior elemento da fila
     * @return resp int maior elemento da fila
     */  
    public int getMaior(){
        int resp = primeiro.prox.elemento;
        if(primeiro == ultimo){
            System.out.print("\nerro\n"); 
        } else {
            for(Celula i = primeiro.prox.prox; i!=null; i=i.prox)
                if(resp<i.elemento)
                    resp = i.elemento;
        }
        return resp;
   }
    
   /**
     * @return terceiro elemento da fila
     */  
   public int tercElemento(){
        return(primeiro.prox.prox.prox.elemento);
   } 

  /**
   * retorna a soma de todos os elementos da fila
   * @return resp int soma de todos os elementos
   */
   public int somElementos(){
        int resp = primeiro.prox.elemento;
        if(primeiro == ultimo){
            System.out.print("\nERRO\n");
        } else {
            for(Celula i = primeiro.prox.prox; i!=null; i = i.prox)
                resp += i.elemento;      
        } 
        return resp;
   }
 

  /**
   * @return resp int tamanho da fila
   */
    public int getTamanho(){
        int resp = 0;
        for(Celula i = primeiro; i !=null; i = i.prox){
            resp += 1;
        }
        return resp;
    }


    /**
     * contar o numero de elementos pares AND multiplos de cinco contidos na
     * fila 
     * @param i Celula celula a ser analisada 
     * @return contador int quantidade de elementos solicitados 
     */
    public int contar(Celula i){
        int contador;
        if(i == null){
            contador = 0;
        } else if(i.elemento % 2 == 0 && i.elemento % 5 == 0) {
            contador = contar(i.prox) + 1;
        } else {
            contador = contar(i.prox);   
        }
        return contador;
    }

    public int contar(){
        return contar(primeiro.prox);
    }
    
    /**
     * inverte a pilha
     */
    public void inverter(){
        int n = getTamanho();
        Celula nova = new Celula();
        Celula ult = nova;
        Celula tmp = primeiro.prox;
        for(int j = n-1; j>0; j--){
            for(int f = 0; f<(n-2); f++, tmp = tmp.prox);
            ult.prox = new Celula(tmp.elemento);
            ult = ult.prox;
            tmp = primeiro.prox;
            n--;
        }
        primeiro = nova;
        ultimo = ult;
        nova = null;
        tmp = null;
    }

    /**
     * retorna uma fila flexivel que contem os elemento da pilha flexivel 
     * onde os dados estao disponiveis por ordem de inser~cao da pilha
     * @param topo Celula celula pilha que sera' analisada
     * @return fila Celula fila(endere~co) contendo os dados
     */
    public Celula toFila(Celula topo){
	int n = getTamanho();
    	Celula fila = new Celula();
	Celula ultimo = fila;
	Celula tmp = primeiro.prox;	
	while( tmp!=null ){
		ultimo.prox = new Celula(tmp.elemento);
		ultimo = ultimo.prox;
		tmp = tmp.prox;
	}
	tmp = null;
	return fila;
    }
  
    public Celula toFila(){
    	return toFila(primeiro);
    }
    
    public void setPrimeiro(Celula novo){
    	primeiro = novo;	
    }

}
