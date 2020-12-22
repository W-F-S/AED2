//walker freitas dos santos 
//698774
//exercicio 7, pg 57, slide 06b

//As ilustrações abaixo mostram a execução dos métodos construtor e do
//inserir de uma pilha, apresente o código dessa classe e desses métodos

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
	private Celula pilhaFim;

	public Pilha() {
		pilhaFim = null;
	}

	public void inserir(int x) {
		Celula pilhaTemp = new Celula(x);
		pilhaTemp.prox = pilhaFim;
		pilhaFim = pilhaTemp;
		pilhaTemp = null;
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
         mostrarRecursivo(pilhaFim);
    }
}

class exercicio07 {
	public static void main(String[] args) {
    	Pilha pilha = new Pilha();
        int resp;
 
        pilha.inserir(3);
		pilha.inserir(5);
   	 //   pilha.mostrarRecursivo();
    }
}
