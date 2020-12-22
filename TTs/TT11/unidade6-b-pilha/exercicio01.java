//walker freitas dos santos 
//698774
//exercicio 01, pg 51, slide 06b

//Seja nossa Pilha, faca um metodo RECURSIVO que soma o conteudo dos
//elementos contidos na mesma


class Celula {
	public int elemento; // Elemento inserido na celula.
	public Celula prox; // Aponta a celula prox.

	public Celula() {
		this(0);
	}
	
	public Celula(int elemento) {
        	this.elemento = elemento;
    	        this.prox = null;
	}
}

class Pilha {
	private Celula topo;

	public Pilha() {
		topo = null;
	}
	public void inserir(int x) {
		Celula tmp = new Celula(x);
		tmp.prox = topo;
		topo = tmp;
		tmp = null;
	}

		
	public int somaRecursiva(Celula i)
	{	
		int resp = 0;
		if(i != null)
		{	
                	resp += i.elemento + somaRecursiva(i.prox); 
		}	
		return resp;
	}
	public int somaRecursiva(){
		return somaRecursiva(topo);
	}	
}

class exercicio01 {
	public static void main(String[] args) {
			Pilha pilha = new Pilha();
                        int resp;
 
			pilha.inserir(0);
			pilha.inserir(1);
			pilha.inserir(2);
			pilha.inserir(3);
			pilha.inserir(4);
				resp = pilha.somaRecursiva();
			System.out.print("soma: "+resp);
	}
}

