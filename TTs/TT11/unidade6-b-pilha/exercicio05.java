//walker freitas dos santos 
//698774
//exercicio 05, pg 55, slide 06b

//Seja nossa Pilha, faça um método RECURSIVO para mostrar os elementos
//da pilha na ordem em que os mesmos foram inseridos

class Celula {
	public int elemento;
	public Celula prox; 

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

    public void mostrarRecursivo(Celula i){
         int resp;
         if(i != null){
                resp = i.elemento;
                mostrarRecursivo(i.prox);
                System.out.print(resp+"\n");
        }
    }

    public void mostrarRecursivo(){
         mostrarRecursivo(topo);
    }
}

class exercicio05 {
	public static void main(String[] args) {
			Pilha pilha = new Pilha();
            int resp;
 
			pilha.inserir(0);
			pilha.inserir(4);
			pilha.inserir(727);
			pilha.inserir(12);
			pilha.inserir(3);
        	pilha.mostrarRecursivo();
	}
}

