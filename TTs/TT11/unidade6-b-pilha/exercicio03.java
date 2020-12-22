//walker freitas dos santos 
//698774
//exercicio 03, pg 53, slide 06b

//Seja nossa Pilha, faça um método RECURSIVO que retorna o maior
//elemento contido na pilha
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

    public int getMaxRecursivo(Celula i, int maior){

         if(i != null){
            if(i.elemento > maior){
                maior = i.elemento;
                maior = getMaxRecursivo(i.prox, maior);
            }
            else{
                maior = getMaxRecursivo(i.prox, maior);
            }
        }
        return maior;
    }

    public int getMaxRecursivo(){
           return getMaxRecursivo(topo , topo.elemento);
    }

}

class exercicio03 {
	public static void main(String[] args) {
			Pilha pilha = new Pilha();
                        int resp;
 
			pilha.inserir(0);
			pilha.inserir(4);
			pilha.inserir(727);
			pilha.inserir(12);
			pilha.inserir(3);
     		resp = pilha.getMaxRecursivo();
			System.out.print("Maior elemento: "+resp);
	}
}

