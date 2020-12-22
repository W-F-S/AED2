/**
 * @author Walker Freitas dos Santos - 698774
 * @version 2 06/10/2020
 */

/**
 * Seja nossa Fila, faça um método recursivo para contar o número de
 * elementos pares AND múltiplos de cinco contidos na fila
 *
 * exercicio06, pg 35, slide06c
 */

class exercicio06{
    public static void main(String[] args){
        try{
            Fila fila = new Fila();
            int x;
            fila.inserir(40);
            fila.inserir(10);
            fila.inserir(10);
            fila.inserir(4);
            fila.inserir(25);
            fila.inserir(01);
            fila.inserir(33);
            fila.inserir(40);
            System.out.print("--Fila--\n");
            fila.mostrar();
            x = fila.contar();
            System.out.print("\nResultado: "+x+"\n");
        } catch(Exception e){            
            System.out.print("\n"+ e +"\n");
            e.printStackTrace();
        }
    }
}
