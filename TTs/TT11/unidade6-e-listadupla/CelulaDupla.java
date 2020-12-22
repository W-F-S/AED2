class CelulaDupla{
	public int elemento;
	public CelulaDupla ant;
	public CelulaDupla prox;

	public CelulaDupla(){
		this(0);
	}

	public CelulaDupla(int elemento){
		this.elemento = elemento;
		this.ant = null;
		this.prox = null;
	}

}

class Celula{
	public int elemento;
	public Celula prox;

	public Celula(){
		this(0);
	}
	public Celula(int x){
		elemento = x;
		this.prox = null;
	}

}
