/**
 * @author Walker Freitas dos Santos - 698774
 * @version 1 09/10/2020
 */

/**
 * Implemente a fila flexivel com no' cabec~a
 *
 * exercicio09, pg 40, slide06c
 */

class Celula2{
    public int elemento;
    public Celula2 prox;

    public Celula2(){
        this(0);
    }
   
    public Celula2(int elemento){
        this.elemento = elemento;
        this.prox = null;
    }
}

class Fila2{
    private Celula2 inicio, fim;
    
    public Fila2(){
        inicio = new Celula2();
        fim = inicio;
    }

    public void inserir(int x){
        fim.prox = new Celula2(x);
        fim  = fim.prox;
    }
    
    public int remover(){
        int resp = 0;
        try{
            Celula2 tmp = inicio;
            inicio = inicio.prox;
            resp = inicio.elemento;
            tmp.prox = null;
            tmp = null;
          
        } catch(NullPointerException e) {
            System.out.print("Erro; pilha possivelmente vazia.");
        }
        return resp;
    }    

    public void mostrar(){
        System.out.print("\n[");
        for(Celula2 i = inicio.prox; i != null; i = i.prox){
            System.out.print(i.elemento+", ");
        }
        System.out.print("]\n");
    }
}

class exercicio10{
	public static void main(String[] args){
        Fila2 fila = new Fila2();
        fila.inserir(2);
        fila.inserir(4);
        fila.inserir(5);
        fila.inserir(9);
        fila.inserir(18);
        fila.mostrar();

    }
}
