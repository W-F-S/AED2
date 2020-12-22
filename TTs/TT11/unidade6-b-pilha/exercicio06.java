//walker freitas dos santos 
//698774
//exercicio 06, pg 56, slide 06b

//Seja nossa Pilha, faça um método ITERATIVO para mostrar os elementos
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

    public int elementos(Celula i){
        int resp = 0;
        for (i = topo; i != null; i = i.prox){
            resp++;            
        }
        return resp;
    }

    public void mostrar() {
        int parada = 0;
        Celula i = topo;
        int n = elementos(i);
        int p = n;

        for (int temp = 0; temp < p; temp++){   
        
            n -= 1;
            for(int j=0; j<n; j++){
                i = i.prox;
          parada = i.elemento;
                if(j+1 == n){
                    System.out.print(parada+"\n");
                }
            }
            i = topo;
        }
        parada = i.elemento;
        System.out.print(parada+"\n");      
    }

}

class exercicio06 {
	public static void main(String[] args) {
		Pilha pilha = new Pilha();
        int resp;
 
		pilha.inserir(0);
		pilha.inserir(4);
		pilha.inserir(727);
		pilha.inserir(12);
		pilha.inserir(3);
    	pilha.mostrar();
	}
}

