/**
 * Walker Freitas dos Santos
 * 698774
 * @version 1 13/10/2020
 */

/**
 * Faça um método que inverta a ordem dos elementos da lista simples. 
 * No exemplo abaixo, após a inversão, os elementos ficarão na ordem 
 * crescente
 *
 * exercicio02, pg 35, Unidade06-e
 */
class Celula{
	public int elemento;
	public Celula prox;

	public Celula(){
		this(0);
	}
	public Celula(int x){
		this.elemento = x;
		this.prox = null;
	}
}

class Lista{
	private Celula primeiro, ultimo;
         
	public Lista(){
		primeiro = new Celula();
		ultimo = primeiro;
	}

	public int tamanho(){
		int resp = 0;
		for(Celula i = primeiro; i!=null; i = i.prox, resp++);
		return resp;
	}
	
	public void inserir(int x){
		if(primeiro == ultimo){
			primeiro.prox=ultimo;
		}
        	ultimo.prox = new Celula(x);
	        ultimo = ultimo.prox;
    }

	public int removerSegunda() throws Exception{
		int resp = 0;
		if(primeiro.prox.prox == null){
			throw new Exception ("Erro ao remover segundo elemento. ele não existe!");
		} else if (primeiro == ultimo){
			throw new Exception("Erro ao remover, lista vazia!");
		}
		Celula i = primeiro.prox;
		if(i.prox.prox == null){
			ultimo = i;
		}
		Celula tmp = i.prox;
		resp = tmp.elemento;
		i.prox = tmp.prox;
		tmp.prox = null; tmp = null;

		return resp;
	}

	public void mostrar(){
		System.out.print("\n[");
		for(Celula i=primeiro.prox; i!=null; i=i.prox){
			System.out.print(" "+i.elemento+",");
		}
		System.out.print("]\n");
	}

	public void inverter(){
		Celula i = primeiro.prox;
		Celula j = ultimo;
		Celula k;
		while(i != j && j.prox != i){
			int tmp = i.elemento;
			i.elemento = j.elemento;
			j.elemento = tmp;
			i = i.prox;
			for(k=primeiro; k.prox != j; k=k.prox);
			j = k;
		}	
	}
}

class exercicio02{
	public static void main(String[] args){
		Lista lista = new Lista();
		lista.inserir(5);
		lista.inserir(4);
		lista.inserir(3);
		lista.inserir(2);
		lista.inserir(1);
		System.out.print("\n--Lista before--");
		lista.mostrar();
		System.out.print("--Lista after--");
		lista.inverter();
		lista.mostrar();			
	}
}
