//walker freitas dos santos 
//698774
//exercicio 02, pg 52, slide 06b

//Seja nossa Pilha, faça um método que retorna o maior elemento contido na pilha
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

    public int getMax()
    {
        int elem = topo.elemento;    
        for(Celula i = topo.prox; i != null; i = i.prox){
            if(i.elemento > elem){
                elem = i.elemento;
            } 
        }

        return elem;
    }
	
}

class exercicio02 {
	public static void main(String[] args) {
			Pilha pilha = new Pilha();
                        int resp;
 
			pilha.inserir(0);
			pilha.inserir(4);
			pilha.inserir(77);
			pilha.inserir(12);
			pilha.inserir(222);
     		resp = pilha.getMax();
			System.out.print("Maior elemento: "+resp);
	}
}

