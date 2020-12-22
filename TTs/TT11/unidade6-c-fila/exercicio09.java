/**
 * @author Walker Freitas dos Santos - 698774
 * @version 1 09/10/2020
 */

/**
 * Implemente a fila flexivel sem no' cabec~a
 *
 * exercicio08, pg 39, slide06c
 */
class Fila3{
    private Celula primeiro, ultimo;
    
    public Fila3(){   
    }

    public void inserir(int x){
    	if(ultimo == null){
	    	ultimo = new Celula(x);
	    	primeiro = ultimo;		
    	}else{
	        ultimo.prox = new Celula(x);
		    ultimo = ultimo.prox;
	    }
    }
    
    public int remover(){
	    int elemen = 0;
        try{
	    	Celula tmp = primeiro;
	    	elemen = primeiro.elemento;
	    	primeiro = primeiro.prox;    	
	    	tmp.prox = null;
	    	tmp = null;
	    }catch (NullPointerException e){
    		System.out.print("\nErro ao apagar. Celula Vazia\n");
	    }
	    return elemen;
    }    

    public void mostrar(){
        System.out.print("\n[");
    	for(Celula i = primeiro; i!=null; i = i.prox){
		    System.out.print(i.elemento+", ");
	    }
        System.out.print("]\n");
    }
}
	
class exercicio09{
	public static void main(String[] args){
		System.out.print("\niniciando\n");
		Fila3 fila = new Fila3();
		fila.inserir(3);
		fila.inserir(4);
		fila.inserir(5);
		fila.inserir(6);
		fila.inserir(7);
		fila.mostrar();
		fila.remover();
		fila.remover();
		fila.remover();
		fila.remover();
		System.out.print("......\n");
		fila.mostrar();
	}
}
