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
		for(Celula i=primeiro.prox; i!=null; i=i.prox){
			System.out.print(" "+i.elemento+",");
		}
		System.out.print("\n");
	}
}

class exercicio{
	public static void main(String[] args){
		try{
			Lista lista = new Lista();
			int x;
			lista.inserir(25);
			lista.inserir(32);
			lista.inserir(12);
			lista.inserir(23);
			lista.inserir(42);
			System.out.print("\nantes da remoção:\n");
			lista.mostrar();
			System.out.print("\napós a remoção:\n");
			x = lista.removerSegunda();
			lista.mostrar();
			System.out.print("Removido = "+x+"\n");
		} catch(Exception e){
			System.out.print("\n "+e+" \n");
		}
		
	}
}
